package spring.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.pathfinder.model.dto.RouteInfoDTO;
import spring.pathfinder.service.PictureServiceImpl;
import spring.pathfinder.service.RouteServiceImpl;

import java.util.List;

@Controller
public class RoutesController {
    private RouteServiceImpl routeService;

    public RoutesController(RouteServiceImpl routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ModelAndView showRoutes(ModelAndView modelAndView) {
        modelAndView.setViewName("routes");

        List<RouteInfoDTO> routes = routeService.getAllRandomRoutes();
        modelAndView.addObject("routes", routes);


        return modelAndView;
    }
}
