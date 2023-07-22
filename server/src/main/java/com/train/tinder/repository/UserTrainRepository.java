package com.train.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.tinder.model.UserTrain;

public interface UserTrainRepository extends JpaRepository<UserTrain, Integer> {

}
