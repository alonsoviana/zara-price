package com.zara.apiprices.infra.port.out;

import com.zara.apiprices.domain.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PricePersistance {
    List<Price> getPrices(Long brandId, Long productId, LocalDateTime applicationDate);
}
