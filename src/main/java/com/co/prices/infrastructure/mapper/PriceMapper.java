package com.co.prices.infrastructure.mapper;

import com.co.prices.domain.models.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    public Price toPriceDomain(com.co.prices.infrastructure.adapters.persistence.entities.Price price);

}
