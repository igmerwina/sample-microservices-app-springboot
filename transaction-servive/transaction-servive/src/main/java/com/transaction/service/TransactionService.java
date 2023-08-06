package com.transaction.service;

import com.transaction.client.ParameterClient;
import com.transaction.dto.request.JournalReq;
import com.transaction.dto.request.ReqSubmit;
import com.transaction.dto.response.DiscountResponse;
import com.transaction.dto.response.OrderResponse;
import com.transaction.dto.response.ParameterResponse;
import com.transaction.dto.response.ResponseService;
import com.transaction.entity.Order;
import com.transaction.repo.OrderRepo;
import com.transaction.util.Constant;
import com.transaction.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {
    private final OrderRepo orderRepo;

    @Autowired
    private final TransactionProducer transactionProducer;
    @Autowired
    private final ParameterClient parameterClient;
    @Transactional
    public ResponseService submitOrder(ReqSubmit req) throws Exception {
        log.info("Start submitOrder {}", req.getItemCode());

        double discount = getDiscount(req.getUserId());

        ParameterResponse fee = parameterClient.getParam("FEE");
        double total_price = Double.parseDouble(req.getPrice()) + Double.parseDouble(fee.getValue()) - discount;

        Order order = new Order();
        order.setId(System.currentTimeMillis());
        order.setUserId(req.getUserId());
        order.setItemCode(req.getItemCode());
        order.setTotalPrice(BigDecimal.valueOf(total_price));
        order.setStatusOrder(Constant.STATUS_ORDER.SUCCESS);
        orderRepo.save(order);

        OrderResponse orderResp = orderRepo.findByItemCode(req.getItemCode(), order.getId());
        JournalReq journalReq = JournalReq.builder()
                .idOrder(order.getId())
                .itemCode(orderResp.getItemCode())
                .userId(order.getUserId())
                .brand(orderResp.getBrand())
                .description(orderResp.getDescription())
                .totalPrice(order.getTotalPrice())
                .fee(BigDecimal.valueOf(Double.parseDouble(fee.getValue())))
                .discount(BigDecimal.valueOf(discount))
                .build();

        /** Post to kafka producer **/
        transactionProducer.postJournalTrx(journalReq);

        log.info("End submitOrder {}", req.getItemCode());
        return ResponseUtil.setResponse(Constant.RESPONSE.APPROVED, null);
    }

    public Double getDiscount(String userId){
        double discount = 0.0;

        List<Order> listOrder = orderRepo.getOrderByUserId(userId);
        Long totalTrx = listOrder.stream()
                .filter(order -> Constant.STATUS_ORDER.SUCCESS.equals(order.getStatusOrder()))
                .count();

        DiscountResponse discResp = parameterClient.getDiscount(totalTrx.intValue());
        if(discResp.getDiscountNom() != null){
            discount = discResp.getDiscountNom().doubleValue();
        }
        return discount;
    }
}