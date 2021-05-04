package com.example.teamelephant.server.shipment;

import com.example.teamelephant.server.warehouse.Warehouse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Shipment entity
 */
@Entity
@Data
@RequiredArgsConstructor
public class Shipment {

    @Id
    private String Id;
    private Long companyid;
    private String senderName;
    private String receiverName;
    private String senderPhone;
    private String receiverPhone;
    private String cityStart;
    private String cityEnd;
    @OneToMany(mappedBy = "shipmentid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Products> products;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal weight;
    private String description;
    private String hazardLevel;
    private Date  dateSent;
    private Date  dateArrived;
    private String vehicleNumber;
    @OneToMany(mappedBy = "shipmentid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TrackEvents> trackEvents;
    private long warehouseFromid;
    private long warehouseToid;
    private Boolean Paid;
    private String beginAddress;
    private String afterAddress;
    private String gst;
    private BigDecimal amount;
    private String qrcode;
    private String qrcodetxt;
}
