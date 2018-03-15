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
//            System.out.println("Entry outside the specified range of [1,100].");

                    clueTextview.setText("Enter a number between 1 - 100");
                    clueTextview.setVisibility(View.VISIBLE);
                }
                checkGuess(userGuess);
            }
        });
    }

    private void checkGuess(int userGuess) { //parameter prevents method from running without any input from user

        do{
        if ((userGuess < 0 || userGuess > 100) && (generatedNumber < 5)) {
//            System.out.println("Entry outside the specified range of [1,100].");
        }
        //too low
        if ((userGuess < generatedNumber) && (numberOfGuesses < 5)) {
//            System.out.println("Too low! Enter your guess: ");
        }
        //too high
        if ((userGuess > generatedNumber) && (numberOfGuesses < 5)) {
//            System.out.println("Too high! Enter your guess: ");
        }
        numberOfGuesses++; //add one to guess # count variable
    } while ((userGuess != generatedNumber) && (userGuess < 6));
    //guesses correctly. winner.


            if (userGuess == generatedNumber) {
//        System.out.println("CONGRATULATIONS! " + userGuess + " is the correct integer.");
    } else {
        //exceeds alloted # guesses. loses game.
//        System.out.println("\nSorry, you have exceeded five guesses without guessing correctly.");
//        System.out.println("The correct integer was " + generatedNumber + ".");
    }
    }

    /*
    private
     */
}
