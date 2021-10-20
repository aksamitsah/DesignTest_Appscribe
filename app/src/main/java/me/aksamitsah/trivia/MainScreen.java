package me.aksamitsah.trivia;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import me.aksamitsah.trivia.fragment.NameFragment;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main_screen);
        fragmentLoad();

    }

    private void fragmentLoad() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new NameFragment()).commit();
    }

    public void btnHistory(View view) {
        Function.intentActivity(MainScreen.this, PlayHistory.class);

    }
}