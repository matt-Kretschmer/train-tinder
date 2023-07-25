package com.train.tinder.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.tinder.model.SaveTrainDTO;
import com.train.tinder.model.Train;
import com.train.tinder.model.TrainDetail;
import com.train.tinder.model.UserLikedTrain;
import com.train.tinder.model.UserTrain;
import com.train.tinder.repository.TrainDetailRepository;
import com.train.tinder.repository.TrainRepository;
import com.train.tinder.repository.UserTrainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainService {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    private final TrainDetailRepository trainDetailRepository;
    private final TrainRepository trainRepository;
    private final UserTrainRepository userTrainRepository;

    public SaveTrainDTO saveUserLikedTrain(String userId, SaveTrainDTO userLikedTrain) {
        Train train = trainRepository.save(new Train(userLikedTrain.getTrainDetailsId()));
        userTrainRepository.save(new UserTrain(userId, train.getTrianId(), userLikedTrain.getMatched()));
        return modelMapper.map(train, SaveTrainDTO.class);
    }

    public List<TrainDetail> findAllTrainDetails() {
        return trainDetailRepository.findAll();
    }

    public List<UserLikedTrain> findAllTrainsLikedByUser(String userId) {
        return userTrainRepository.findAllTrainsLikedByUser(userId);
    }

}
