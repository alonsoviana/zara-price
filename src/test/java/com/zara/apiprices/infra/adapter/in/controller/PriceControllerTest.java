package com.zara.apiprices.infra.adapter.in.controller;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.infra.adapter.in.PriceController;
import com.zara.apiprices.infra.adapter.in.dto.PriceRs;
import com.zara.apiprices.infra.adapter.in.mapper.PriceRsMapper;
import com.zara.apiprices.infra.port.in.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PriceControllerTest {

    private static final PodamFactory podamFactory = new PodamFactoryImpl();

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

    @Mock
    private PriceRsMapper priceRsMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPrice_then_return_OK() {

        List<Price> priceList = List.of(podamFactory.manufacturePojo(Price.class));
        List<PriceRs> priceRsList = List.of(podamFactory.manufacturePojo(PriceRs.class));
        when(priceService.getPrices(anyLong(), anyLong(), any())).thenReturn(priceList);
        when(priceRsMapper.toPriceRsList(priceList)).thenReturn(priceRsList);

        ResponseEntity<List<PriceRs>> result = priceController.getPrices(1L, 1L, LocalDateTime.now());

        assertEquals(result.getStatusCode(), HttpStatus.OK);

    }
}
