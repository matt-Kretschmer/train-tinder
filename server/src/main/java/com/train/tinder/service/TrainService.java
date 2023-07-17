package com.train.tinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.train.tinder.model.Train;
import com.train.tinder.repository.TrainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;

    public List<Train> findAll(){
        return trainRepository.findAll();
    }
}
