package com.transaction.repo;

import com.transaction.dto.response.OrderResponse;
import com.transaction.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, String> {

    @Query("SELECT new com.transaction.dto.response.OrderResponse (o.itemCode, i.description, i.brand, i.price, i.itemType) " +
                    "FROM com.transaction.entity.Order o " +
                    "RIGHT JOIN com.transaction.entity.Item i ON o.itemCode = i.itemCode " +
                    "WHERE o.itemCode = ?1 " +
                    "AND o.id = ?2"
    )
    OrderResponse findByItemCode(String itemCode, Long id);

    List<Order> getOrderByUserId(String userId);

}