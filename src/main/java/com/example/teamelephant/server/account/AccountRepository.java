package com.example.teamelephant.server.account;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@Repository
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends CrudRepository<Account, String>
{
    // Return number of rows deleted
    @Modifying
    @Transactional
    @Query("delete from Account where id = ?1")
    @DeleteMapping("/accounts/{id}")
    int deleteOne(String accountid);
}
