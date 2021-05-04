package com.example.teamelephant.server.warehouse;

import com.example.teamelephant.server.company.Company;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class WarehouseDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Warehouse add(Warehouse clientw){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(clientw.getName());
        warehouse.setAddress(clientw.getAddress());
        warehouse.setCompanyid(clientw.getCompanyid());
        warehouse.setCity(clientw.getCity());
        warehouse.setProvince(clientw.getProvince());
        warehouse.setCountry(clientw.getCountry());
        entityManager.persist(warehouse);
        for(Rate rate : clientw.getRates()){
            Rate realRate = new Rate();
            realRate.setWarehouseid(warehouse.getId());
            realRate.setToWarehouseid(rate.getToWarehouseid());
            realRate.setRatePerCubicFeet(rate.getRatePerCubicFeet());
            realRate.setRatePerKg(rate.getRatePerKg());
            entityManager.persist(realRate);
        }
        return warehouse;
    }
    @Transactional
    public Long update(Warehouse clientw){
        Warehouse warehouse = entityManager.find(Warehouse.class, clientw.getId());
        warehouse.setName(clientw.getName());
        warehouse.setAddress(clientw.getAddress());
        warehouse.setCompanyid(clientw.getCompanyid());
        warehouse.setCity(clientw.getCity());
        warehouse.setProvince(clientw.getProvince());
        warehouse.setCountry(clientw.getCountry());
        entityManager.persist(warehouse);
        entityManager.createNativeQuery("delete from Rate where warehouseid = " + clientw.getId() + ";").executeUpdate();
        for(Rate rate : clientw.getRates()){
            Rate realRate = new Rate();
            realRate.setWarehouseid(warehouse.getId());
            realRate.setToWarehouseid(rate.getToWarehouseid());
            realRate.setRatePerCubicFeet(rate.getRatePerCubicFeet());
            realRate.setRatePerKg(rate.getRatePerKg());
            entityManager.persist(realRate);
        }
        return warehouse.getId();
    }
    @Transactional
    public Long delete(Long id){
        Warehouse warehouse = entityManager.find(Warehouse.class, id);
        if(warehouse.getId() > 0){
            entityManager.remove(warehouse);
            entityManager.createNativeQuery("delete from Rate where warehouseId = " + id + ";");
            return 1L;
        }
        else{
            return 0L;
        }

    }
    public List<Warehouse> getLinkedWarehouses(int id){
        List<Warehouse> linkedWarehouses = entityManager.createNativeQuery("SELECT * FROM Warehouse INNER JOIN Linked_Companies on Warehouse.companyid = Linked_Companies.linkedid where Linked_Companies.companyid = "+id+" or Warehouse.companyid = "+id, Warehouse.class).getResultList();
        if(linkedWarehouses.size() == 0){
            linkedWarehouses = entityManager.createNativeQuery("select * from Warehouse where companyid = "+id,Warehouse.class).getResultList();
        }
        //List<Warehouse> linkedWarehouses = queryLinkedCompanies.getResultList();
        return linkedWarehouses;
    }

    /*public List<Warehouse> getCompanyWarehouses(Long companyid){
        Query queryCompanyWarehouses = entityManager.createNativeQuery("SELECT * FROM Company WHERE companyid = ?1");
        queryCompanyWarehouses.setParameter(1,companyid);
        List<Warehouse> warehouses = queryCompanyWarehouses.getResultList();
        return warehouses;
    }*/
}
