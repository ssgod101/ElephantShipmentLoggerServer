package com.example.teamelephant.server.warehouse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long warehouseid;
    private Long toWarehouseid;
    private BigDecimal ratePerCubicFeet;
    private BigDecimal ratePerKg;

}
