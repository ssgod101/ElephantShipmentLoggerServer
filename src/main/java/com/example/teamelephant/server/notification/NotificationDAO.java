package com.example.teamelephant.server.notification;

import com.example.teamelephant.server.company.Company;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class NotificationDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Long link(Notification not){
        Notification notification = entityManager.find(Notification.class, not.getId());
        //Company c1 = entityManager.find(Company.class, not.getCompanyid());
        //Company c2 = entityManager.find(Company.class, not.getCompanyidFrom());
        //c1.setLinkedTo(c1.getLinkedTo());
        if(notification.getId() > 0){
            entityManager.createNativeQuery("insert into Linked_Companies (linkedid, companyid) values ( "+not.getCompanyid()+","+not.getCompanyidFrom()+")").executeUpdate();
            entityManager.createNativeQuery("insert into Linked_Companies (linkedid, companyid) values ( "+not.getCompanyidFrom()+","+not.getCompanyid()+")").executeUpdate();
            entityManager.remove(notification);
            //entityManager.createNativeQuery("delete from Notification where companyid = " + not.getCompanyid() + " && companyid_from = " + not.getCompanyidFrom());
            return 1L;
        }else{
            return 0L;
        }
    }
    //maybe used later?
    @Transactional
    public Long unlink(int c1, int c2){
        int result1 = entityManager.createNativeQuery("delete from Linked_Companies where companyid = "+c1+" and linkedid = "+c2+";").executeUpdate();
        int result2 = entityManager.createNativeQuery("delete from Linked_Companies where companyid = "+c2+" and linkedid = "+c1+";").executeUpdate();
        if(result1 == 1 && result2 == 1){return 1L;}
        else{return 0L;}
    }
}
