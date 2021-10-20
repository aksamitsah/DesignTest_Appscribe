package me.aksamitsah.trivia.model;

public class Score {
    String id;
    String playerName;
    String ansOne;
    String ansTwo;
    String dateTime;

    public Score(String id, String playerName, String ansOne, String ansTwo, String dateTime) {
        this.id = id;
        this.playerName = playerName;
        this.ansOne = ansOne;
        this.ansTwo = ansTwo;
        this.dateTime = dateTime;
    }


    public String getId() {
        return id;
    }

    public String getPlayerName() {
        return "Name: " + playerName;
    }

    public String getAnsOne() {
        return "Answer: \" " + ansOne+" \"";
    }

    public String getAnsTwo() {
        return "Answer: \" " + ansTwo + " \"";
    }

    public String getGame() {
        return "GAME: " + id + " - " + dateTime;
    }
}
