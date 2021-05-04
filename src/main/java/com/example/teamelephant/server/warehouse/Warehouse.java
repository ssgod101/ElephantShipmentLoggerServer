package com.example.teamelephant.server.warehouse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name, address, companyid
    private Long Id;
    private Long companyid;
    private String name;
    private String address;
    private String city;
    private String province;
    private String country;
    @OneToMany(mappedBy = "warehouseid", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Rate> rates = new ArrayList<Rate>();
}
