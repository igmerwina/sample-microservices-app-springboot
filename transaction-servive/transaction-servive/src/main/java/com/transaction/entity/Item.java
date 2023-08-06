package com.transaction.entity;

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
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "item_code", nullable = false, length = 30)
    private String itemCode;

    @Column(name = "description", length = 200)
    private  String description;

    @Column(name = "brand", length = 100)
    private  String brand;

    @Column(name = "item_price", precision = 20, scale = 2)
    private BigDecimal price;

    @Column(name = "item_type", length = 30)
    private String itemType;
}
