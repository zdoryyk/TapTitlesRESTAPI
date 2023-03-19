package ua.zdoryk.TapTitlesRESTAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private int id;

    @Column(name = "player_name")
    @NotNull
    private String playerName;

    @Column(name = "game")
    @NotNull
    private String game;

    @Column(name = "points")
    @NotNull
    private Integer points;

    @Column(name = "played_on")
    @NotNull
    private LocalDateTime playedOn;

    @ManyToOne()
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;

    public Score(String playerName, String game, Integer points, LocalDateTime playedOn) {
        this.playerName = playerName;
        this.game = game;
        this.points = points;
        this.playedOn = playedOn;
    }

    public Score() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String player) {
        this.playerName = player;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDateTime getPlayedOn() {
        return playedOn;
    }

    public void setPlayedOn(LocalDateTime playedOn) {
        this.playedOn = playedOn;
    }


    @Override
    public String toString() {
        return "Game: " + game + "; " + "your points: " + points + "; " + "played: " + playedOn.getDayOfMonth() + " " + playedOn.getMonth() + ";";
    }
}
