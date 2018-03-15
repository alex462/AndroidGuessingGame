package com.example.alexandrareinhart.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

//    private TextView guessHint;

    private TextView clueTextview;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextview = findViewById(R.id.clue_textview);
        guessButton = findViewById(R.id.submit_guess_button);
        guess = findViewById(R.id.user_guess_editText);


        setListener();

//        guessHint = findViewByID(R.id.clue_textview); //doesn't need a listener. is built into screen layout
    }

    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) (Math.ceil(Math.random() * 100));


    }

    @Override
    public void onBackPressed() {

    }

    private void setListener(){
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guess.getText().toString()); //we have to parse everything to integer from string input
                if ((userGuess < 0 || userGuess > 100) && (generatedNumber < 5)) {
                    clueTextview.setText(R.string.outside_range_message);
                    clueTextview.setVisibility(View.VISIBLE);
                    guess.setText("");
                }
                checkGuess(userGuess);
            }
        });
    }

    private void checkGuess(int userGuess) { //parameter prevents method from running without any input from user

        do{

        //too low
        if ((userGuess < generatedNumber) && (numberOfGuesses < 5)) {
            clueTextview.setText(R.string.too_low_message);
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
        }

        //too high
        if ((userGuess > generatedNumber) && (numberOfGuesses < 5)) {
            clueTextview.setText(R.string.too_high_message);
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
        }
        numberOfGuesses++; //add one to guess # count variable

    } while ((userGuess != generatedNumber) && (userGuess < 6));

    //guesses correctly. winner.
            if (userGuess == generatedNumber) {
                //TODO - Create intent to go to winning activity method; get rid of filler code
                clueTextview.setText("WINNER!");
                clueTextview.setVisibility(View.VISIBLE);
                guess.setText("");
    } else {
                clueTextview.setText("out of guesses");
                clueTextview.setVisibility(View.VISIBLE);
                guess.setText("");
                //exceeds alloted # guesses. loses game.
                //TODO - create intent to go to winning activity method - handle running out of chances; get rid of filler code

    }
    }

    /*
    private
     */
}
