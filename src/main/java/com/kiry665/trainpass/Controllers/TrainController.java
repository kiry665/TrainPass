package com.kiry665.trainpass.Controllers;

import com.kiry665.trainpass.Models.Train;
import com.kiry665.trainpass.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("/api/v1/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @GetMapping("/number")
    public ResponseEntity<Train> getTrainByNumber(@RequestParam int trainNumber) {
        return ResponseEntity.ok(trainService.getTrainByTrainNumber(trainNumber));
    }

}
