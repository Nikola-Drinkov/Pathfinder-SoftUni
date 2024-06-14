package spring.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.pathfinder.model.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
    Picture findFirstById(Long id);
}
