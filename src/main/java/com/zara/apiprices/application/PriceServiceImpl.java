package com.zara.apiprices.application;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.infra.port.in.PriceService;
import com.zara.apiprices.infra.port.out.PricePersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private final PricePersistance pricePersistance;

    @Autowired
    public PriceServiceImpl(PricePersistance pricePersistance) {
        this.pricePersistance = pricePersistance;
    }

    @Override
    public List<Price> getPrices(Long brandId, Long productId, LocalDateTime applicationDate) {
        return pricePersistance.getPrices(brandId, productId, applicationDate);
    }
}
