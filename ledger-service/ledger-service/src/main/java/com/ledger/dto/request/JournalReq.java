package com.ledger.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class JournalReq {
    private long idOrder;
    private String itemCode;
    private String userId;
    private String brand;
    private String description;
    private BigDecimal totalPrice;
    private BigDecimal fee;
    private BigDecimal discount;
}
