package com.example.devinagro.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "grain")
public class Grain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "average_harvest")
    private int averageHarvest;

    @ManyToOne
    @JoinColumn(name = "enterprise")
    private Enterprise enterprise;
}
