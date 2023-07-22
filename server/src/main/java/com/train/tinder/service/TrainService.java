package com.train.tinder.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.tinder.model.SaveTrainDTO;
import com.train.tinder.model.Train;
import com.train.tinder.model.TrainDetail;
import com.train.tinder.repository.TrainDetailRepository;
import com.train.tinder.repository.TrainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainService {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    private final TrainDetailRepository trainDetailRepository;
    private final TrainRepository trainRepository;

    public List<TrainDetail> findAllTrainDetails() {
        return trainDetailRepository.findAll();
    }

    public SaveTrainDTO saveUserLikedTrain(SaveTrainDTO userLikedTrain) {
        Train train = trainRepository.save(new Train(userLikedTrain.getImageUrl(), userLikedTrain.getTrainDetailsId()));
        // Need to populate the user_trains table to reflect a user did like a train.
        return modelMapper.map(train, SaveTrainDTO.class);
    }
}
