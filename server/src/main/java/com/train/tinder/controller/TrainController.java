package com.train.tinder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.tinder.model.Train;
import com.train.tinder.service.TrainService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trains")
public class TrainController {
    private final TrainService trainService;

    @GetMapping
    @Operation(summary = "Get all trains.", description = "A list of all single trains.")
    public ResponseEntity<List<Train>> all() {
        return new ResponseEntity<>(trainService.findAll(), HttpStatus.OK);
    }
}
