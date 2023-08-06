package com.param.service;

import com.param.dto.response.ResponseService;
import com.param.entity.Discount;
import com.param.entity.ParameterCache;
import com.param.repo.DiscountRepo;
import com.param.repo.ParameterCacheRepo;
import com.param.util.Constant;
import com.param.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParameterService {

    private final ParameterCacheRepo parameterCacheRepo;
    private final DiscountRepo discountRepo;

    public ResponseService getParameter(String key) throws Exception {
        log.info("Start getParameter {}", key);

        Optional<ParameterCache> cache = parameterCacheRepo.findById(key);
        if(cache.isEmpty()){
            log.info("End getParameter {}", key);
            return ResponseUtil.setResponse(Constant.RESPONSE.DATA_NOT_FOUND, null);
        }

        log.info("--> return resp: " + cache.get().getParameterResponse());
        log.info("End getParameter {}", key);
        return ResponseUtil.setResponse(Constant.RESPONSE.APPROVED, cache.get().getParameterResponse());
    }

    public ResponseService getDiscount(Integer totalTrx) throws Exception {
        log.info("Start getDiscount {}", totalTrx);

        Optional<Discount> discount = discountRepo.findById(totalTrx);
        if(discount.isEmpty()){
            log.info("End getDiscount {}", totalTrx);
            return ResponseUtil.setResponse(Constant.RESPONSE.DATA_NOT_FOUND, null);
        }

        log.info("--> return resp: " + discount.get());
        log.info("End getDiscount {}", totalTrx);
        return ResponseUtil.setResponse(Constant.RESPONSE.APPROVED, discount.get());
    }
}
