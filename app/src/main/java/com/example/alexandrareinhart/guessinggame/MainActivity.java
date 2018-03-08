package com.example.alexandrareinhart.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //every class that is accessed by a user has an onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
