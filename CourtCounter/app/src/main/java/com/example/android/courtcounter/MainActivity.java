package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    int scoreA = 0;

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA);
        scoreView.setText(String.valueOf(score));
    }

    public void twopointA(View view) {
        scoreA = (scoreA + 2);
        displayForTeamA(scoreA);
    }
    public void threepointA(View view) {
        scoreA = (scoreA + 3);
        displayForTeamA(scoreA);
    }
    public void onepointA(View view) {
        scoreA = (scoreA + 1);
        displayForTeamA(scoreA);
    }
    public void undoA(View view) {
        scoreA = (scoreA - 1);
        displayForTeamA(scoreA);
    }
    /**
     * Displays the given score for Team B.
     */

    int scoreB = 0;
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB);
        scoreView.setText(String.valueOf(score));
    }
    public void twopointB(View view) {
        scoreB = (scoreB + 2);
        displayForTeamB(scoreB);
    }
    public void threepointB(View view) {
        scoreB = (scoreB + 3);
        displayForTeamB(scoreB);
    }
    public void onepointB(View view) {
        scoreB = (scoreB + 1);
        displayForTeamB(scoreB);
    }
    public void undoB(View view) {
        scoreB = (scoreB - 1);
        displayForTeamB(scoreB);
    }
    public void RESET(View view) {
        scoreB = 0;
        scoreA = 0;
        displayForTeamB(scoreB);
        displayForTeamA(scoreA);
    }

}









