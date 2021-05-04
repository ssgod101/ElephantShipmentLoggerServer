package com.example.teamelephant.server.account;

import com.example.teamelephant.server.company.Company;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Account
{
    @Id
    private String Id;
    private Long companyid;
    private Long warehouseid;
    private String password;
    private String type;
    private String name;
    private String email;
    private String phonenumber;
    private BigDecimal wage;
    private String wageunit;
    private Boolean resetpassword;
}
