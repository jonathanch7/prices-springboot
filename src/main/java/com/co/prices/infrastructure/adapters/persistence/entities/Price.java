package com.co.prices.infrastructure.adapters.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="PRICES")
public class Price {

    @Id
    @Column(name="PRICE_LIST")
    private Integer priceList;

    @Column(name="BRAND_ID")
    private Short brandId;

    @Column(name="START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(name="END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name="PRIORITY")
    private Short priority;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="CURR")
    private String currency;

    @Column(name="LAST_UPDATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdate;

    @Column(name="LAST_UPDATE_BY")
    private String lastUpdateBy;

    @PrePersist
    @PreUpdate
    public void beforePersist() {
        if(this.lastUpdate == null) {
            this.lastUpdate = LocalDateTime.now();
        }
    }

}
