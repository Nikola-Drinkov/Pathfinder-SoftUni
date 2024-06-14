package spring.pathfinder.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pathfinder.model.dto.RouteInfoDTO;
import spring.pathfinder.model.entity.Picture;
import spring.pathfinder.model.entity.Route;
import spring.pathfinder.repository.RouteRepository;

import java.util.*;

@Service
public class RouteServiceImpl implements RouteService{
    private RouteRepository routeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public RouteInfoDTO getRandomRoute() {
        Random random = new Random();
        long randomRouteId = random.nextLong(1,6);

        List<Route> routes = this.routeRepository.findAll();
        Route route = routeRepository.findFirstById(randomRouteId);
        Set<Picture> routePictures = route.getPictures();
        List<Picture> routePicturesList = new ArrayList<>(routePictures);

        int picturesCount = routePicturesList.size();
        String randomPictureUrl = routePicturesList.get(random.nextInt(0,picturesCount)).getUrl();

        RouteInfoDTO routeInfoDTO = modelMapper.map(route, RouteInfoDTO.class);
        routeInfoDTO.setImgUrl(randomPictureUrl);

        return routeInfoDTO;
    }
    @Transactional
    public List<RouteInfoDTO> getAllRandomRoutes() {
        List<RouteInfoDTO> randoms = new ArrayList<>();
        for(int i=0; i<routeRepository.count(); i++) {
            randoms.add(getRandomRoute());
        }
        return randoms;
    }
}
