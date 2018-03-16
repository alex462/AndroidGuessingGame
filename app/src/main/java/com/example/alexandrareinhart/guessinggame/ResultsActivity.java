package com.example.alexandrareinhart.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumber;
    private TextView winOrLoseResultTextview;
    private ImageView winOrLoseResultImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        playAgainButton = findViewById(R.id.play_again_button);
        correctNumber = findViewById(R.id.generated_number_textview);
        winOrLoseResultTextview = findViewById(R.id.results_output_textview);
        winOrLoseResultImageview = findViewById(R.id.winner_imageview);

        setListener();
    }

    private void setListener() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
