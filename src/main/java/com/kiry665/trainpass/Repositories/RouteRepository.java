package com.kiry665.trainpass.Repositories;

import com.kiry665.trainpass.Models.Route;
import com.kiry665.trainpass.Models.RouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

    @Query("SELECT NEW com.kiry665.trainpass.Models.RouteDetails(s1.name, s2.name, t.trainNumber, t.type, r1.departure_time, r2.arrival_time) " +
            "FROM Route r1 " +
            "JOIN Route r2 ON r1.train.id = r2.train.id " +
            "JOIN Train t ON r1.train.id = t.id " +
            "JOIN Station s1 ON r1.station.id = s1.id " +
            "JOIN Station s2 ON r2.station.id = s2.id " +
            "WHERE r1.station.id = :departureStationId " +
            "AND r2.station.id = :arrivalStationId " +
            "AND r1.sequence_number < r2.sequence_number")
    List<RouteDetails> findRouteDetails(@Param("departureStationId") int departureStationId,
                                        @Param("arrivalStationId") int arrivalStationId);

}
