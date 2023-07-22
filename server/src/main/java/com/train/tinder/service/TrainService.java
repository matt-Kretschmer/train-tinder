package com.train.tinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.train.tinder.model.TrainDetail;
import com.train.tinder.repository.TrainDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainDetailRepository trainDetailRepository;

    public List<TrainDetail> findAllTrainDetails() {
        return trainDetailRepository.findAll();
    }
}
