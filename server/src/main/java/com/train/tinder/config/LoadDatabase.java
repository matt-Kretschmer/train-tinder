package com.train.tinder.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.train.tinder.model.Train;
import com.train.tinder.repository.TrainRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TrainRepository trainRepository){
        return args -> {
            log.info("Preloading " + trainRepository.save(new Train("Thomas")));
            log.info("Preloading " + trainRepository.save(new Train("Matthew")));
        };
    }
}
