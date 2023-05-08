package com.periferiag.xman.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "adn")
public class ADN implements Serializable {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    private String adn1;
    private String adn2;
    private String adn3;
    private String adn4;
    private String adn5;
    private String adn6;


}
