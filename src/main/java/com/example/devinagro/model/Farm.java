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
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 100)
    private String location;

    @Column
    private double startInventory;

    @Column(nullable = false, length = 10)
    private String lastHarvest;

    @Column(nullable = false, length = 10)
    private String nextHarvest;

    @OneToOne
    @JoinColumn(name = "grain_id")
    Grain grain;

    @OneToOne
    @JoinColumn(name = "enterprise_id")
    Enterprise enterprise;

}
