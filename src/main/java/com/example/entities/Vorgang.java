package com.example.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Vorgang extends PanacheEntity {
    public String name;
    public String Abteilung;
}
