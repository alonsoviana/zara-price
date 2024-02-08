package com.zara.apiprices.infra.port.in;

import com.zara.apiprices.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {

    List<Price> getPrices(Long brandId, Long productId, LocalDateTime applicationDate);
}
