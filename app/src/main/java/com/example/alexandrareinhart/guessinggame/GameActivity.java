package com.example.alexandrareinhart.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    //private TextView guessHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //guessHint = findViewByID(R.id.clue_textview); //doesn't need a listener. is built into screen layout
    }

    /*
    private
     */
}
