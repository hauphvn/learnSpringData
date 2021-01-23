package com.coderzero.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne
    private Address address;

}
