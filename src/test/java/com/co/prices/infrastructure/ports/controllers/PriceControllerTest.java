package com.co.prices.infrastructure.ports.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public MockHttpServletRequestBuilder buildRequest(String brandId, String productId, String dateApplication) {
        return MockMvcRequestBuilders
                .get("/prices/brand/{brandId}/product/{productId}/date-application/{dateApplication}", brandId, productId, dateApplication)
                .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    void test1() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"priceList\":1,\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"productId\":35455,\"price\":35.50}"));
    }

    @Test
    void test2() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"priceList\":2,\"brandId\":1,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\",\"productId\":35455,\"price\":25.45}"));
    }

    @Test
    void test3() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"priceList\":1,\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"productId\":35455,\"price\":35.50}"));
    }

    @Test
    void test4() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"priceList\":3,\"brandId\":1,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\",\"productId\":35455,\"price\":30.50}"));
    }

    @Test
    void test5() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"priceList\":4,\"brandId\":1,\"startDate\":\"2020-06-15T16:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"productId\":35455,\"price\":38.95}"));
    }

    @Test
    void notFoundInDate() throws Exception {

        mockMvc.perform(buildRequest("1", "35455", "2020-06-13T21:00:00"))
                .andExpect(status().isNoContent());
    }

}
