package com.train.tinder.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.tinder.model.SaveTrainDTO;
import com.train.tinder.model.TrainDetail;
import com.train.tinder.model.UserLikedTrain;
import com.train.tinder.service.TrainService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trains")
@SecurityRequirement(name = "bearerAuth")
public class TrainController {
    private final TrainService trainService;

    @PostMapping
    @Operation(summary = "Save a user liked train", description = "Save train liked by a user (matched)")
    public ResponseEntity<SaveTrainDTO> saveUserLikedTrain(Principal principal,
            @RequestBody SaveTrainDTO userLikedTrain) {
        return new ResponseEntity<>(trainService.saveUserLikedTrain(principal.getName(), userLikedTrain),
                HttpStatus.CREATED);
    }

    @GetMapping("/details")
    @Operation(summary = "Get all trains detials.", description = "A list of all train details.")
    public ResponseEntity<List<TrainDetail>> all() {
        return new ResponseEntity<>(trainService.findAllTrainDetails(), HttpStatus.OK);
    }

    @GetMapping("/likes")
    @Operation(summary = "Get a user's liked trains", description = "A list of a user's liked trains")
    public ResponseEntity<List<UserLikedTrain>> allLikedTrainsByUser(Principal principal) {
        return new ResponseEntity<>(trainService.findAllTrainsLikedByUser(principal.getName()), HttpStatus.OK);
    }

}
