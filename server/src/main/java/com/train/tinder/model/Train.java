package com.train.tinder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Train {
    private @Id @GeneratedValue Long id;
    private String name;

    public Train(String name){
        this.name = name;
    }
}
