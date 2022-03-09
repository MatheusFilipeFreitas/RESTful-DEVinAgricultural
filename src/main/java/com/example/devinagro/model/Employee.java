package com.example.devinagro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false,unique = true, length = 11)
    private String cpf;

    @Column(nullable = false,unique = true, length = 11)
    private String address;

    @Column(nullable = false, length = 11)
    private String phoneNumber;

    @Column(nullable = false, length = 10)
    private String birthDate;

    @Column(nullable = false, length = 10)
    private String hiringDate;

    @OneToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
}
