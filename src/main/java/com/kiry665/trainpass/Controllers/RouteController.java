package com.kiry665.trainpass.Controllers;

import com.kiry665.trainpass.Models.Route;
import com.kiry665.trainpass.Models.RouteDetails;
import com.kiry665.trainpass.ModelsRequest.RouteDetailsRequest;
import com.kiry665.trainpass.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/all")
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @PostMapping("/details")
    public ResponseEntity<List<RouteDetails>> getRouteDetails(@RequestBody RouteDetailsRequest request) {
        return ResponseEntity.ok(routeService.getRouteDetails(request.getDepartureStationId(), request.getArrivalStationId()));
    }
}
