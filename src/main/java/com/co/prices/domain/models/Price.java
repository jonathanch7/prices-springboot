package com.co.prices.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Price {

    private Integer priceList;

    private Short brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long productId;

    private BigDecimal price;

}
