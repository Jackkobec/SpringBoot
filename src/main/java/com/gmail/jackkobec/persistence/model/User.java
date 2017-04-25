package com.gmail.jackkobec.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jack on 25.04.2017.
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public User() {
    }
}
