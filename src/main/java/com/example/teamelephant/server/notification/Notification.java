package com.example.teamelephant.server.notification;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long companyid;
    private Long companyidFrom;
    private String companyFrom;
    private String message;
    private Boolean resolved;
    private Boolean accepted;
    private Date dateSent;
}
