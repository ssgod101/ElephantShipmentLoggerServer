package com.example.teamelephant.server.notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "notifications", path = "notifications")
public interface NotificationRepository extends CrudRepository<Notification, Long>{
    @Modifying
    @Transactional
    @Query("delete from Notification where id = ?1")
    @DeleteMapping("notifications/{id}")
    int deleteOne(Long id);
}
