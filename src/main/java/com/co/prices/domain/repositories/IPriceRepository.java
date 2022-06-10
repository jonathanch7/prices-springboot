package com.co.prices.domain.repositories;

import com.co.prices.domain.models.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IPriceRepository {

    public Optional<Price> getProductByDate(LocalDateTime applicationDate, Long idProduct, Short brandId);
}
