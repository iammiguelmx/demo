package com.mx.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShip implements Serializable {

    @Id @Setter @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter @Getter
    private String model;

    @Setter @Getter
    private String captain;

    @Setter @Getter
    private Integer fuel;

}
