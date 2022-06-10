package com.co.prices.infrastructure.adapters.persistence.crud;

import com.co.prices.infrastructure.adapters.persistence.entities.Price;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceCrudRepository extends CrudRepository<Price, Integer> {

    public List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Short brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);

}
