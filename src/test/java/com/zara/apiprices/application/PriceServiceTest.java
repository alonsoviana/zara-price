package com.zara.apiprices.application;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.infra.port.out.PricePersistance;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


public class PriceServiceTest {

    private static final PodamFactory podamFactory = new PodamFactoryImpl();

    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private PricePersistance pricePersistance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPrice_then_return_price() {

        List<Price> price = List.of(podamFactory.manufacturePojo(Price.class));
        when(pricePersistance.getPrices(anyLong(), anyLong(), any())).thenReturn(price);

        List<Price> result = priceService.getPrices(1L, 1L, LocalDateTime.now());
        assertEquals(result.get(0).getPrice(), price.get(0).getPrice());
    }
}
