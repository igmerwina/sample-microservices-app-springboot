package com.param.entity;

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
@Table(name = "discount")
public class Discount {
    @Id
    @Column(name = "total_trx", nullable = false)
    private Integer totalTrx;

    @Column(name = "discount_nom")
    private BigDecimal discountNom;
}
