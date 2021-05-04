package com.example.teamelephant.server.shipment;

import com.example.teamelephant.server.warehouse.Warehouse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "shipments", path = "shipments")
public interface ShipmentRepository extends CrudRepository<Shipment, String> {

    @Modifying
    @Transactional
    @Query("delete from Shipment where id = ?1")
    @DeleteMapping("shipment/{id}")
    int deleteOne(String shipmentId);
    @Query(value = "SELECT * FROM Shipment  where Shipment.warehouse_Fromid = ?1", nativeQuery = true)
    @GetMapping("shipments/{warehouseFromid}")
    List<Shipment> getShipmentByWarehouseFromid(Long warehouseFromid);
    @Query(value = "SELECT * FROM Shipment  where Shipment.companyid = ?1", nativeQuery = true)
    @GetMapping("shipments/{companyid}")
    List<Shipment> getShipmentByCompanyid(Long companyid);
    @Query(value = "SELECT * FROM Shipment  where Shipment.id = ?1", nativeQuery = true)
    @GetMapping("shipments/{id}")
    List<Shipment> getShipmentByid(String id);

}
