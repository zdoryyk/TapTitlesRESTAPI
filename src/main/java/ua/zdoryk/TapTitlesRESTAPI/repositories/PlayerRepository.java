package ua.zdoryk.TapTitlesRESTAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.zdoryk.TapTitlesRESTAPI.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    Player findByName(String name);
}
