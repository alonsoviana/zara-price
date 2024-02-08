package com.zara.apiprices.infra.adapter.in;

import com.zara.apiprices.exception.ErrorMessage;
import com.zara.apiprices.infra.adapter.in.dto.PriceRs;
import com.zara.apiprices.infra.adapter.in.mapper.PriceRsMapper;
import com.zara.apiprices.infra.port.in.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/apisample")
@RequiredArgsConstructor
@Slf4j
public class PriceController {
    private PriceService priceService;
    private PriceRsMapper priceRsMapper;

    @Autowired
    public PriceController(PriceService priceService, PriceRsMapper priceRsMapper) {
        this.priceService = priceService;
        this.priceRsMapper = priceRsMapper;
    }

    @Operation(summary = "Method that returns price data")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found the price",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PriceRs.class))
        }),
        @ApiResponse(
            responseCode = "404",
            description = "Price not found",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorMessage.class))
        }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorMessage.class))
            })
    })

    @GetMapping("/prices")
    public ResponseEntity<List<PriceRs>> getPrices(
        @RequestParam(name = "brandId") Long brandId,
        @RequestParam(name = "productId") Long productId,
        @RequestParam(name = "applicationDate") LocalDateTime applicationDate) {

        log.info("Obtaining price data with brandId: " + brandId + ", productId: " + productId +
                 ", and application date: " + applicationDate + ".");
        List<PriceRs> priceRs = priceRsMapper.toPriceRsList(priceService.getPrices(brandId, productId, applicationDate));
        priceRs.forEach((PriceRs price) -> log.info(price.toString()));
        return ResponseEntity.ok(priceRs);
    }
}
