package com.transaction.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "order_trx")
public class Order {
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private long id;

    @Column(name = "user_id", length = 30)
    private  String userId;

    @Column(name = "item_code", length = 30)
    private  String itemCode;

    @Column(name = "status_order", length = 1)
    private  String statusOrder;

    @Column(name = "total_price", precision = 20, scale = 2)
    private BigDecimal totalPrice;

}
