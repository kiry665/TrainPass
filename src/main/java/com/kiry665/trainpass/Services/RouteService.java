package com.kiry665.trainpass.Services;

import com.kiry665.trainpass.Models.Route;
import com.kiry665.trainpass.Models.RouteDetails;
import com.kiry665.trainpass.Repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<RouteDetails> getRouteDetails(int departureStationId, int arrivalStationId) {
        return routeRepository.findRouteDetails(departureStationId, arrivalStationId);
    }
}
