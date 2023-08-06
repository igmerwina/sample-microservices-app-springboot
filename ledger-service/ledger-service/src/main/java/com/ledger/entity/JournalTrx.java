package com.ledger.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class JournalTrx {
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private long id;

    @Column(name = "id_order", nullable = false, length = 20)
    private long idOrder;

    @Column(name = "item_code", length = 30)
    private String itemCode;

    @Column(name = "user_id", length = 30)
    private  String userId;

    @Column(name = "brand", length = 100)
    private  String brand;

    @Column(name = "description", length = 200)
    private  String description;

    @Column(name = "total_price", precision = 20, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "fee", precision = 20, scale = 2)
    private BigDecimal fee;

    @Column(name = "discount", precision = 20, scale = 2)
    private BigDecimal discount;

}
