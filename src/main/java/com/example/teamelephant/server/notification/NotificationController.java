package com.example.teamelephant.server.notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationDAO notificationDAO;
    @PostMapping(value = "/linkcompanies")
    public ResponseEntity<Long> LinkCompanies(@RequestBody Notification notification){
        Long result = notificationDAO.link(notification);
        return new ResponseEntity<Long>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/unlinkcompanies", params = {"c","u"})
    public ResponseEntity<Long> UnlinkCompanies(@RequestParam("c") int companyid1, @RequestParam("u") int companyid2){
        Long result = notificationDAO.unlink(companyid1,companyid2);
        return new ResponseEntity<Long>(result, HttpStatus.OK);
    }
}
