package com.example.teamelephant.server.company;

import com.example.teamelephant.server.account.Account;
import com.example.teamelephant.server.notification.Notification;
import com.example.teamelephant.server.warehouse.Warehouse;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @OneToMany(mappedBy = "companyid", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "companyid", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Warehouse> warehouses = new ArrayList<>();
    @OneToMany(mappedBy = "companyid", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Notification> notifications = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "linked_companies", joinColumns = @JoinColumn(name="companyid"), inverseJoinColumns = @JoinColumn(name="linkedid"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Company> linkedCompanies = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="linked_companies", joinColumns = @JoinColumn(name="linkedid"), inverseJoinColumns = @JoinColumn(name="companyid"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Company> linkedTo = new ArrayList<>();
}
