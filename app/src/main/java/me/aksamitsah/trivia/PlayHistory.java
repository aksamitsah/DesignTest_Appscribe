package me.aksamitsah.trivia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.aksamitsah.trivia.adapter.ScoreAdapter;
import me.aksamitsah.trivia.database.DBHandler;
import me.aksamitsah.trivia.model.Score;

public class PlayHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_history);

        ArrayList<Score> scoreModal = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(PlayHistory.this);

        scoreModal = dbHandler.readCourses();


        ScoreAdapter scoreAdapter = new ScoreAdapter(scoreModal, PlayHistory.this);
        RecyclerView displayHistory = findViewById(R.id.displayHistory);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PlayHistory.this, RecyclerView.VERTICAL, false);
        displayHistory.setLayoutManager(linearLayoutManager);

        displayHistory.setAdapter(scoreAdapter);
    }
}