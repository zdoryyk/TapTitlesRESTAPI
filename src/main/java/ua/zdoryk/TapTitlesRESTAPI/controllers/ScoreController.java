package ua.zdoryk.TapTitlesRESTAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.zdoryk.TapTitlesRESTAPI.models.Score;
import ua.zdoryk.TapTitlesRESTAPI.services.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;


    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<Score> findAll(){
        return scoreService.showAll();
    }

    @GetMapping("/score_user")
    public List<Score> findUserByName(String name){
        return scoreService.findByName(name);
    }

    @PostMapping("/add")
    public void addScore(Score score){
        scoreService.addScore(score);
    }

}
