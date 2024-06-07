package com.kiry665.trainpass.Repositories;

import com.kiry665.trainpass.Models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

    Train getTrainById(int id);

    Train getTrainByTrainNumber(int train_number);

}
