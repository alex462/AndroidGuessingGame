package com.example.alexandrareinhart.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private TextView directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //every class that is accessed by a user has an onCreate
        super.onCreate(savedInstanceState); //these 2 lines should ALWAYS be the first 2 lines ever.
        setContentView(R.layout.activity_main); //NEVER mess with these 2 lines

        startButton = findViewById(R.id.start_button); //R stands for resource.
        directions = findViewById(R.id.directions_textview);

        startListener();
        //set a listener. at all times, device needs to be listening for input, i.e. tap, touch, tilt, etc. must set listener/s AS SOON AS app has started.

    }

    private void startListener(){

        startButton.setOnClickListener(new View.OnClickListener() { //OnClickListener is a class built in to Android
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        //directions.SOMETHING
    }

    private void startGame(){
        Intent playGame = new Intent(this, GameActivity.class); //this class needs to change from what it is to the game class. it still
        //doesn't know what it needs to do until I tell it what my intent to do is.
        startActivity(playGame);
    }
}
