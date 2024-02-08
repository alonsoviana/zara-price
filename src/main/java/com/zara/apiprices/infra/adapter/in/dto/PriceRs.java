package com.zara.apiprices.infra.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRs {
    private Long productId;
    private Long brandId;
    private String brandName;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private String curr;

    @Override
    public String toString() {
        return "Price found with" +
                " product id: " + productId +
                ", brand id: " + brandId +
                ", brand name: '" + brandName +
                ", price list: " + priceList +
                ", start date: " + startDate +
                ", end date: " + endDate +
                ", price: " + price +
                ", and currency: '" + curr +
                '.';
    }
}
