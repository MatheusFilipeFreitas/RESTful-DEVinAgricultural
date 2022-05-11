package com.example.devinagro.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String cpf;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String gender;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "hiring_date")
    private LocalDate hiringDate;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
}
