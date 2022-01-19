package com.egen.Weather.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class Wind {

    @Id
    private String id;
    private double speed;
    private double degree;

    public Wind(){
        this.id = UUID.randomUUID().toString();
    }
}
