package ua.zdoryk.TapTitlesRESTAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.zdoryk.TapTitlesRESTAPI.models.Score;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {

    List<Score> findByPlayerName(String player);
}
