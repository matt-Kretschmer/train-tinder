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
@Table(name = "train_details")
public class TrainDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_details_id")
    private Integer trianDetailsId;

    @Column(name = "about")
    private String about;

    @Column(name = "likes")
    private String likes;

    @Column(name = "dislikes")
    private String dislikes;

    @Column(name = "name")
    private String name;

    public TrainDetail(String about, String likes, String dislikes, String name) {
        this.about = about;
        this.likes = likes;
        this.dislikes = dislikes;
        this.name = name;
    }

}
