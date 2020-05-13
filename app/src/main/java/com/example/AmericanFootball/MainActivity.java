package com.example.AmericanFootball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private int scoreA=0;
    private int scoreB=0;
    private Map<Integer,Integer> buttonToScoreId = new HashMap<Integer,Integer>(){{
        put(R.id.touchdownTeamA,R.id.scoreForTeamA);
        put(R.id.fieldGoalTeamA,R.id.scoreForTeamA);
        put(R.id.extraPointTeamA,R.id.scoreForTeamA);
        put(R.id.safetyTeamA,R.id.scoreForTeamA);
        put(R.id.touchdownTeamB,R.id.scoreForTeamB);
        put(R.id.fieldGoalTeamB,R.id.scoreForTeamB);
        put(R.id.extraPointTeamB,R.id.scoreForTeamB);
        put(R.id.safetyTeamB,R.id.scoreForTeamB);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * add 6 points to given team
     * @param view
     */
    public void touchdown(View view){
        int scoreId = getScoreId(view);
        updateScore(scoreId,6);
        display(scoreId);
    }

    /**
     * add 3 points to given team
     * @param view
     */
    public void fieldGoal(View view){
        int scoreId = getScoreId(view);
        updateScore(scoreId,3);
        display(scoreId);
    }

    /**
     * add 2 points to given team
     * @param view
     */
    public void safety(View view){
        int scoreId = getScoreId(view);
        updateScore(scoreId,2);
        display(scoreId);
    }

    /**
     * add 1 point to given team
     * @param view
     */
    public void extraPoint(View view){
        int scoreId = getScoreId(view);
        updateScore(scoreId,1);
        display(scoreId);
    }

    /**
     * reset all the scores
     * @param view
     */
    public void reset(View view){
        scoreA=0;
        scoreB=0;
        display(R.id.scoreForTeamA);
        display(R.id.scoreForTeamB);
    }

    private int getScoreId(View view){
        return buttonToScoreId.get(view.getId());
    }

    private void updateScore(int scoreId, int plus){
        if (scoreId==R.id.scoreForTeamA){
            scoreA+=plus;
        }
        else{
            scoreB+=plus;
        }
    }
    /**
     * Displays the given score for given team
     */
    private void display(int scoreId){
        int score = scoreId==R.id.scoreForTeamA ? scoreA:scoreB;
        TextView scoreView = (TextView) findViewById(scoreId);
        scoreView.setText(String.valueOf(score));
    }
}
