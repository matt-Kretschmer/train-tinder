package com.train.tinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.train.tinder.model.UserLikedTrain;
import com.train.tinder.model.UserTrain;

public interface UserTrainRepository extends JpaRepository<UserTrain, Integer> {
    @Query(value = "select about, likes, dislikes, name, image_url as imageUrl from train_tinder.train_details "
            + "inner join train_tinder.trains on train_tinder.train_details.train_details_id = train_tinder.trains.train_details_id "
            + "inner join train_tinder.user_trains on train_tinder.trains.train_id =  train_tinder.user_trains.train_id "
            + "where train_tinder.user_trains.user_id = :userId and train_tinder.user_trains.matched = 1 ", nativeQuery = true)
    List<UserLikedTrain> findAllTrainsLikedByUser(String userId);
}
