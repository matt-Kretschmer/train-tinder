package com.train.tinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
