package com.zara.apiprices.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIT {

    private MockMvc mockMvc;

    @Autowired
    public PriceControllerIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getPrice_with_at_10_hours_14_day_then_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value("35455"))
                .andExpect(jsonPath("$[0].brandId").value("1"))
                .andExpect(jsonPath("$[0].brandName").value("ZARA"))
                .andExpect(jsonPath("$[0].priceList").value("1"))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"));
    }

    @Test
    public void getPrice_with_at_16_hours_14_day_then_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T16:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value("35455"))
                .andExpect(jsonPath("$[0].brandId").value("1"))
                .andExpect(jsonPath("$[0].brandName").value("ZARA"))
                .andExpect(jsonPath("$[0].priceList").value("1"))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].productId").value("35455"))
                .andExpect(jsonPath("$[1].brandId").value("1"))
                .andExpect(jsonPath("$[1].brandName").value("ZARA"))
                .andExpect(jsonPath("$[1].priceList").value("2"))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$[1].price").value("25.45"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));
    }

    @Test
    public void getPrice_with_at_21_hours_14_day_then_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T21:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value("35455"))
                .andExpect(jsonPath("$[0].brandId").value("1"))
                .andExpect(jsonPath("$[0].brandName").value("ZARA"))
                .andExpect(jsonPath("$[0].priceList").value("1"))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"));
    }

    @Test
    public void getPrice_with_at_10_hours_15_day_then_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15T10:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value("35455"))
                .andExpect(jsonPath("$[0].brandId").value("1"))
                .andExpect(jsonPath("$[0].brandName").value("ZARA"))
                .andExpect(jsonPath("$[0].priceList").value("1"))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].productId").value("35455"))
                .andExpect(jsonPath("$[1].brandId").value("1"))
                .andExpect(jsonPath("$[1].brandName").value("ZARA"))
                .andExpect(jsonPath("$[1].priceList").value("3"))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$[1].price").value("30.5"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));
    }

    @Test
    public void getPrice_with_at_21_hours_16_day_then_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value("35455"))
                .andExpect(jsonPath("$[0].brandId").value("1"))
                .andExpect(jsonPath("$[0].brandName").value("ZARA"))
                .andExpect(jsonPath("$[0].priceList").value("1"))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].price").value("35.5"))
                .andExpect(jsonPath("$[0].curr").value("EUR"))
                .andExpect(jsonPath("$[1].productId").value("35455"))
                .andExpect(jsonPath("$[1].brandId").value("1"))
                .andExpect(jsonPath("$[1].brandName").value("ZARA"))
                .andExpect(jsonPath("$[1].priceList").value("4"))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].price").value("38.95"))
                .andExpect(jsonPath("$[1].curr").value("EUR"));
    }

    @Test
    public void getPrice_with_no_result_then_return_NOT_FOUND() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apisample/prices")
                        .param("brandId", "1")
                        .param("productId", "0")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNotFound());
    }
}
