package com.example.teamelephant.server.company;

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
@RepositoryRestResource(collectionResourceRel = "companies", path = "companies")
public interface CompanyRepository extends CrudRepository<Company, Long>
{
    // Return number of rows deleted
    @Modifying
    @Transactional
    @Query("delete from Company where id = ?1")
    @DeleteMapping("/companies/{id}")
    int deleteOne(Long companyid);
    @Query(value = "SELECT * FROM Company INNER JOIN Linked_Companies on company.id = Linked_Companies.linkedid where Linked_Companies.companyid = ?1", nativeQuery = true)
    @GetMapping("companies/{companyid}")
    List<Company> getLinkedCompanies(Long companyid);
}
