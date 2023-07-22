package com.train.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.tinder.model.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {

}
