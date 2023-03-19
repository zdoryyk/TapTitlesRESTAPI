package ua.zdoryk.TapTitlesRESTAPI.dto;



import jakarta.validation.constraints.NotNull;
import ua.zdoryk.TapTitlesRESTAPI.models.Comment;
import ua.zdoryk.TapTitlesRESTAPI.models.Rating;
import ua.zdoryk.TapTitlesRESTAPI.models.Score;

import java.util.List;

public class PlayerDTO {

    private int id;
    @NotNull
    private String name;

    @NotNull
    private String password;

    private List<Score> scoreList;

    private List<Comment> commentList;

    private Rating rating;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
