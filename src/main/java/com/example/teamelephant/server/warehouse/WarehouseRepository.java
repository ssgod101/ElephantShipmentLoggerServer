package com.example.teamelephant.server.warehouse;

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
import java.util.Set;

@Repository
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "warehouses", path = "warehouses")
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
    @Modifying
    @Transactional
    @Query("delete from Warehouse where id = ?1")
    @DeleteMapping("warehouses/{id}")
    int deleteOne(Long warehouseid);
    @Query(value = "select * from Warehouse where companyid = ?1", nativeQuery = true)
    @GetMapping("warehouses/{companyid}")
    List<Warehouse> getCompanyWarehouses(Long companyid);
    /*@Query(value = "SELECT * FROM Warehouse INNER JOIN Linked_Companies on Warehouse.companyid = Linked_Companies.linkedid where Linked_Companies.companyid = ?1 or Warehouse.companyid = ?1", nativeQuery = true)
    @GetMapping("warehouses/{companyid}")
    List<Warehouse> getLinkedWarehouses(Long companyid);*/
/*    @Query(value = "select name from Company where Id = ?1")
    @GetMapping("warehouses/{id}")
    String getCompanyName(Long id);*/
}
