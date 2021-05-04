package com.example.teamelephant.server.shipment;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.MapKeyType;
import org.hibernate.id.IdentifierGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@RequiredArgsConstructor
public class TrackEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Time time;
    private Date date;
    private String currentWarehouse;
    private Long currentWarehouseid;
    private String shipmentid;
    private Boolean reached;
}
