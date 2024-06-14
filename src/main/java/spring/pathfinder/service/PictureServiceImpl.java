package spring.pathfinder.service;

import org.springframework.stereotype.Service;
import spring.pathfinder.model.entity.Picture;
import spring.pathfinder.repository.PictureRepository;
@Service
public class PictureServiceImpl {
    private PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Picture findById() {
        return this.pictureRepository.findFirstById(1L);
    }
}
