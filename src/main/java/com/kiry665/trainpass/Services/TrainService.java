package com.kiry665.trainpass.Services;

import com.kiry665.trainpass.Models.Train;
import com.kiry665.trainpass.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainByTrainNumber(int trainNumber) {
        return trainRepository.getTrainByTrainNumber(trainNumber);
    }
}
