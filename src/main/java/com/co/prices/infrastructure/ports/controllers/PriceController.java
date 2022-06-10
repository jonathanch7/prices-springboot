package com.co.prices.infrastructure.ports.controllers;

import com.co.prices.application.QueryPricesByApplicationDate;
import com.co.prices.domain.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private QueryPricesByApplicationDate queryPrices;

    @GetMapping("/brand/{brandId}/product/{productId}/date-application/{dateApplication}")
    public ResponseEntity<Price> getPriceByDate(@PathVariable("brandId") Short brandId,
                                                @PathVariable("productId") Long productId,
                                                @PathVariable("dateApplication")
                                                @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateApplication) {
        return this.queryPrices.handle(dateApplication, productId, brandId)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
