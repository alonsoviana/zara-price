package com.zara.apiprices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Price {
    private Long id;
    private Long brandId;
    private String brandName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private String curr;
}
