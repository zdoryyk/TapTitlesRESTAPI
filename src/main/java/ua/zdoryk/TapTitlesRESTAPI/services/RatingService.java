package ua.zdoryk.TapTitlesRESTAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.zdoryk.TapTitlesRESTAPI.models.Rating;
import ua.zdoryk.TapTitlesRESTAPI.repositories.RatingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> findAll(){
        return ratingRepository.findAll();
    }

    public Rating findByName(String name){
        return ratingRepository.findByPlayerName(name);
    }
    public void addRating(Rating rating){
        rating.setPlayerName(rating.getPlayer().getName());
        rating.setRatedOn(LocalDateTime.now());
        rating.setGame("TapTitles");
        ratingRepository.save(rating);
    }

    public void updateRating(Rating rating){
        ratingRepository.save(rating);
    }



}
