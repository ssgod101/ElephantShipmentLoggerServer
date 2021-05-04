package com.example.teamelephant.server.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WarehouseController {
    @Autowired
    private WarehouseDAO warehouseDAO;
    /*@PostMapping("/warehousesadd")
    public ResponseEntity<Long> addOne(@RequestBody Warehouse warehouse){
        Long warehouseId = warehouseDAO.add(warehouse);
        System.out.println(warehouseId);
        return new ResponseEntity<Long>(warehouseId, HttpStatus.OK);
    }*/
    @GetMapping(value = "/warehousesget", params = {"id"})
    public ResponseEntity<List<Warehouse>> getLinkedWarehouses(@RequestParam("id") int companyid){
        List<Warehouse> warehouses = warehouseDAO.getLinkedWarehouses(companyid);
        return new ResponseEntity<List<Warehouse>>(warehouses,HttpStatus.OK);
    }
    @PostMapping("/warehousesadd")
    public ResponseEntity<Warehouse> addOne(@RequestBody Warehouse warehouse){
        Warehouse warehouseId = warehouseDAO.add(warehouse);
        return new ResponseEntity<Warehouse>(warehouseId, HttpStatus.OK);
    }
    @DeleteMapping("/warehousesdelete")
    public ResponseEntity<Long> deleteOne(@RequestParam Long id){
        Long deleteId = warehouseDAO.delete(id);
        return new ResponseEntity<Long>(deleteId,HttpStatus.OK);
    }
    @PutMapping("/warehousesupdate")
    public ResponseEntity<Long> updateOne(@RequestBody Warehouse warehosue){
        Long warehouseid = warehouseDAO.update(warehosue);
        return new ResponseEntity<Long>(warehouseid,HttpStatus.OK);
    }
    /*@GetMapping(value = "/warehousesget", produces = "application/json")
    public ResponseEntity<List<Warehouse>> getWarehouses(@RequestBody Long companyid){
        List<Warehouse> warehouses = warehouseDAO.getCompanyWarehouses(companyid);
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }
    @GetMapping(value = "/linked", produces = "application/json")
    public ResponseEntity<List<Warehouse>> getLinkedWarehouses(@RequestBody Long companyid){
        List<Warehouse> warehouses = warehouseDAO.getLinkedWarehouses(companyid);
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }*/
}
