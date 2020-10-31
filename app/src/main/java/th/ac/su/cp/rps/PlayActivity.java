package th.ac.su.cp.rps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{
    int round = 1;
    int countRight = 0;
    int countNone = 0;

    private String[] challengeTexts  = {"You try", "Cool?", "What your turn?", "Guess what?"};
    private String[] result = {"rock", "paper", "scissor"};
    private String test;
    private Button[] mButtons = new Button[3];
    private List<String> mItemList;
    int indexResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mItemList = new ArrayList<>(Arrays.asList(result));


        TextView challenge = (TextView) findViewById(R.id.challenge_text);
        final int indexChall = new Random().nextInt(challengeTexts.length);
        challenge.setText(challengeTexts[indexChall]);

        mButtons[0] = findViewById(R.id.rock_btn);
        mButtons[1] = findViewById(R.id.paper_btn);
        mButtons[2] = findViewById(R.id.scissors_btn);

        mButtons[0].setOnClickListener(this);
        mButtons[1].setOnClickListener(this);
        mButtons[2].setOnClickListener(this);

        final TextView roundText = (TextView) findViewById(R.id.round_text);
        roundText.setText("Round : " + round);
        R_challenge();
    }

    private void R_challenge(){
        List<String> mItemList = new ArrayList<>(Arrays.asList(result));
        indexResult = new Random().nextInt(mItemList.size());
        TextView challenge = (TextView) findViewById(R.id.challenge_text);
        final int indexChall = new Random().nextInt(challengeTexts.length);
        challenge.setText(challengeTexts[indexChall]);
    }

    public void onClick(View view) {
        final TextView roundText = (TextView) findViewById(R.id.round_text);
        if(indexResult == 0){
            if(view.getId() == R.id.rock_btn){
                countNone = 0;
            }
            else if(view.getId() == R.id.paper_btn){
                countRight++;
            }
            else if(view.getId() == R.id.scissors_btn){
                countNone = 0;
            }
        }
        else if(indexResult == 1){
            if(view.getId() == R.id.rock_btn){
                countNone = 0;
            }
            else if(view.getId() == R.id.paper_btn){
                countNone = 0;
            }
            else if(view.getId() == R.id.scissors_btn){
                countRight++;
            }
        }
        else if(indexResult == 2){
            if(view.getId() == R.id.rock_btn){
                countRight++;
            }
            else if(view.getId() == R.id.paper_btn){
                countNone = 0;
            }
            else if(view.getId() == R.id.scissors_btn){
                countNone = 0;
            }
        }

        round++;
        if(round <= 5) {
            roundText.setText("Round : " + round);
            R_challenge();
        }
        else{

            final Intent i = new Intent(PlayActivity.this, SummaryActivity.class);
            startActivity(i);
                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage(countRight+" คะแนน\n\nต้องดารเล่นเหมใหม่หรือไม่");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        R_challenge();
                        countRight=0;
                        round=1;
                    }
                });
                dialog.setNegativeButton("No",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        R_challenge();
                        countRight=0;
                        round=1;
                    }
                });
                dialog.show();*/
        }
    }



}