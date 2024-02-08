package com.zara.apiprices.infra.adapter.out.persistence;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.exception.NotFoundException;
import com.zara.apiprices.infra.adapter.out.PricePersistenceImpl;
import com.zara.apiprices.infra.adapter.out.entity.PriceEntity;
import com.zara.apiprices.infra.adapter.out.mapper.PriceMapper;
import com.zara.apiprices.infra.adapter.out.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PricePersistanceTest {

    private static final PodamFactory podamFactory = new PodamFactoryImpl();

    @InjectMocks
    private PricePersistenceImpl pricePersistenceImpl;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPrice_then_found_price() {
        List<Price> priceList = List.of(podamFactory.manufacturePojo(Price.class));
        List<PriceEntity> priceEntityList = List.of(podamFactory.manufacturePojo(PriceEntity.class));
        when(priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
                anyLong(), anyLong(), any(), any())).thenReturn(priceEntityList);
        when(priceMapper.toPriceList(any(List.class))).thenReturn(priceList);

        List<Price> result = pricePersistenceImpl.getPrices(1L, 1L, LocalDateTime.now());
        assertEquals(result.get(0).getPrice(), priceList.get(0).getPrice());
    }

    @Test
    void get_price_then_not_found_data_and_throw_not_found_exception() {
        assertThrows(NotFoundException.class, () -> pricePersistenceImpl.getPrices(1L, 1L, LocalDateTime.now()));

    }
}
