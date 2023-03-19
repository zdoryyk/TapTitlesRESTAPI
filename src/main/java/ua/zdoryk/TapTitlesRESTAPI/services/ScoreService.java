package ua.zdoryk.TapTitlesRESTAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.zdoryk.TapTitlesRESTAPI.models.Score;
import ua.zdoryk.TapTitlesRESTAPI.repositories.ScoreRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> showAll(){
        return scoreRepository.findAll();
    }

    public List<Score> findByName(String playerName){
        return scoreRepository.findByPlayerName(playerName);
    }

    public void addScore(Score score){
        score.setPlayedOn(LocalDateTime.now());
        score.setPlayerName(score.getPlayer().getName());
        score.setGame("TapTitles");
        scoreRepository.save(score);
    }

}
