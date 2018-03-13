package com.example.alexandrareinhart.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //every class that is accessed by a user has an onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startGame();
    }

    private void startGame(){
        Intent playGame = new Intent(this, GameActivity.class); //this class needs to change from what it is to the game class. it still
        //doesn't know what it needs to do until I tell it what my intent to do is.
        startActivity(playGame);
    }
}
