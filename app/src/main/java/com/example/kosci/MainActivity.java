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
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }

}
        private void rollDice() {
            int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) {
            diceValues[i] = random.nextInt(6) + 1;

        }