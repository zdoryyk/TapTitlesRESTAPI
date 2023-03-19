package ua.zdoryk.TapTitlesRESTAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.zdoryk.TapTitlesRESTAPI.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    Rating findByPlayerName(String name);
}
