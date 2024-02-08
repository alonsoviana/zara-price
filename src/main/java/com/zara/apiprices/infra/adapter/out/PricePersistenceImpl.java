package com.zara.apiprices.infra.adapter.out;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.exception.NotFoundException;
import com.zara.apiprices.infra.adapter.out.entity.PriceEntity;
import com.zara.apiprices.infra.adapter.out.mapper.PriceMapper;
import com.zara.apiprices.infra.adapter.out.repository.PriceRepository;
import com.zara.apiprices.infra.port.out.PricePersistance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PricePersistenceImpl implements PricePersistance {
    private static final String NOT_FOUND = "Price data not found";
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Autowired
    public PricePersistenceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> getPrices(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<PriceEntity> priceEntityList =
            priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
                brandId, productId, applicationDate, applicationDate);

        if (priceEntityList.isEmpty()) {
            log.info(NOT_FOUND);
            throw new NotFoundException("Price data not found");
        }
        return priceMapper.toPriceList(priceEntityList);
    }
}
