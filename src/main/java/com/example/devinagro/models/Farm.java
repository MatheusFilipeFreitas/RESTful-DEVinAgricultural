package com.example.devinagro.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private LocalDate lastHarvest;
    private Double stock = 0.00;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
    @OneToOne
    @JoinColumn(name = "grain_id")
    private Grain grain;
}
