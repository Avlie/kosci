package com.example.kosci;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView[] diceViews;
    private TextView rollResultView, totalScoreView, rollCountView;
    private Button rollButton, resetButton;
    private int totalScore = 0;
    private int rollCount = 0;
    private Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        diceViews = new TextView[5];
        diceViews[0] = findViewById(R.id.dice1);
        diceViews[1] = findViewById(R.id.dice2);
        diceViews[2] = findViewById(R.id.dice3);
        diceViews[3] = findViewById(R.id.dice4);
        diceViews[4] = findViewById(R.id.dice5);

        rollResultView = findViewById(R.id.rollResult);
        totalScoreView = findViewById(R.id.totalScore);
        rollCountView = findViewById(R.id.rollCount);
        rollButton = findViewById(R.id.rollButton);
        resetButton = findViewById(R.id.resetButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }
        private void rollDice () {
            int[] diceValues = new int[5];
            int currentRollScore = 0;


            for (int i = 0; i < 5; i++) {
                diceValues[i] = random.nextInt(6) + 1;
                diceViews[i].setText(String.valueOf(diceValues[i]));
            }


            currentRollScore = calculateRollScore(diceValues);
            rollResultView.setText("Wynik tego losowania: " + currentRollScore);

            updateScore(currentRollScore);
            updateRollCount();
        }
        private int calculateRollScore ( int[] diceResults){
            int rollscore = 0;
            int[] dicecounts = new int[6];

            for (int value : diceResults) {
                dicecounts[value - 1]++;
            }

            for (int i = 0; i < dicecounts.length; i++) {
                if (dicecounts[i] > 1) {
                    rollscore += (i + 1) * dicecounts[i];
                }
            }
            return rollscore;
        }


        private void updateScore ( int currentRollScore){
            totalScore += currentRollScore;
            totalScoreView.setText("Wynik gry: " + totalScore);

        }
        private void updateRollCount () {
            rollCount++;
            rollCountView.setText("Liczba rzutów: " + rollCount);
        }

        private void resetGame () {
            totalScore = 0;
            rollCount = 0;

            for (TextView diceView : diceViews) {
                diceView.setText("?");
            }

            rollResultView.setText("Wynik tego losowania: 0");
            totalScoreView.setText("Wynik gry: 0");
            rollCountView.setText("Liczba rzutów: 0");
        }
}