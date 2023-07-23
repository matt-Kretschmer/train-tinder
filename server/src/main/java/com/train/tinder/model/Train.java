package com.train.tinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Integer trianId;

    @Column(name = "train_details_id")
    private Integer trainDetailsId;

    public Train(Integer trainDetailsId) {
        this.trainDetailsId = trainDetailsId;
    }
}
