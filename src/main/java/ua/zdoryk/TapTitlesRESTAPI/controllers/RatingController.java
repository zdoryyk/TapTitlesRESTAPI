package ua.zdoryk.TapTitlesRESTAPI.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.zdoryk.TapTitlesRESTAPI.models.Rating;
import ua.zdoryk.TapTitlesRESTAPI.services.RatingService;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @GetMapping()
    public List<Rating> findAll(){
        return ratingService.findAll();
    }

    @GetMapping("/rating")
    public Rating findUserByName(@RequestBody String name){
        return ratingService.findByName(name);
    }

    @PostMapping("/add")
    public void addRating(Rating rating){
        ratingService.addRating(rating);
    }

}
