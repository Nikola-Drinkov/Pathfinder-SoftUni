package spring.pathfinder.service;

import spring.pathfinder.model.dto.RouteInfoDTO;
import spring.pathfinder.model.entity.Route;


public interface RouteService {
    public RouteInfoDTO getRandomRoute();
}
