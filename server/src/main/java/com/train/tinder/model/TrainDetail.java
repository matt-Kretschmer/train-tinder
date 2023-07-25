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

    @Column(name = "image_url")
    private String imageUrl;

    public TrainDetail(String about, String likes, String dislikes, String name, String imageUrl) {
        this.about = about;
        this.likes = likes;
        this.dislikes = dislikes;
        this.name = name;
        this.imageUrl = imageUrl;
    }

}
