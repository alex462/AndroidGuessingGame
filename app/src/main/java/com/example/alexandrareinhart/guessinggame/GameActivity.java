package com.example.alexandrareinhart.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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
    Intent resultsActivity;

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
        numberOfGuesses = 0;
        clueTextview.setVisibility(View.INVISIBLE);
        guess.setText("");

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


//                guessButton.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                    @Override
//                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                        if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//
//                        }
//                        return true;
//                    }
//                });



        });
    }

    private void checkGuess(int userGuess) { //parameter prevents method from running without any input from user

        if (userGuess == generatedNumber) {
            Intent winner = new Intent(this, ResultsActivity.class);
            startActivity(winner);
        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            Intent loser = new Intent(this, ResultsActivity.class);
            loser.putExtra("ACTUAL_NUMBER", generatedNumber);
            startActivity(loser);
        } else if (userGuess < generatedNumber) {
            clueTextview.setText(R.string.too_low_message);
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        } else if (userGuess > generatedNumber) {
            clueTextview.setText(R.string.too_high_message);
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        }
//
//        do{
//
//        //too low
//        if ((userGuess < generatedNumber) && (numberOfGuesses < 5)) {
//            clueTextview.setText(R.string.too_low_message);
//            clueTextview.setVisibility(View.VISIBLE);
//            guess.setText("");
//        }
//
//        //too high
//        if ((userGuess > generatedNumber) && (numberOfGuesses < 5)) {
//            clueTextview.setText(R.string.too_high_message);
//            clueTextview.setVisibility(View.VISIBLE);
//            guess.setText("");
//        }
//        numberOfGuesses++; //add one to guess # count variable
//
//    } while ((userGuess != generatedNumber) && (userGuess < 6));
//
//    //guesses correctly. winner.
//            if (userGuess == generatedNumber) {
//
//                Intent intentBundle = new Intent(GameActivity.this, ResultsActivity.class);
//
//                startActivity(intentBundle);
//    } else {
//                startActivity(resultsActivity);
//                //exceeds alloted # guesses. loses game.
//                //TODO - create intent to go to winning activity method - handle running out of chances; get rid of filler code
//
//    }
    }

    /*
    private
     */
}
