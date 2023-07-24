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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_trains")
public class UserTrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_train_id")
    private Integer userTrainId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "train_id")
    private Integer trianId;

    @Column(name = "matched")
    private Boolean matched;

    public UserTrain(String userId, Integer trianId, Boolean matched) {
        this.userId = userId;
        this.trianId = trianId;
        this.matched = matched;
    }
}
