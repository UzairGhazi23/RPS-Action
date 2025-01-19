package com.rpsaction.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock,b_paper,b_scissors;
    TextView tv_score,onlyscore;
    ImageView iv_ComputerChoice,iv_HumanChoice;
    int HumanScore,ComputerScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_rock=(Button) findViewById(R.id.b_rock);
        b_paper=(Button) findViewById(R.id.b_paper);
        b_scissors=(Button) findViewById(R.id.b_scissors);

        iv_ComputerChoice=(ImageView)findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice=(ImageView)findViewById(R.id.iv_humanChoice);

        tv_score=(TextView)findViewById(R.id.tv_score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.hand);
               String message= play_turn("Paper");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText(Integer.toString(HumanScore)+" : "
                +Integer.toString(ComputerScore));
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message= play_turn("Rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText(Integer.toString(HumanScore)+" : "
                        +Integer.toString(ComputerScore));

            }
            }); 
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.scissor);
                String message= play_turn("Scissors");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText(Integer.toString(HumanScore)+" : "
                        +Integer.toString(ComputerScore));
            }
        });

    }
    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;
        if(computer_choice_number == 1) {
            computer_choice = "Rock";
        }else if (computer_choice_number == 2){
            computer_choice = "Scissors";
        }else if (computer_choice_number == 3){
            computer_choice = "Paper";
        }

        if(computer_choice == "Rock") {
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        } else if(computer_choice == "Scissors") {
            iv_ComputerChoice.setImageResource(R.drawable.scissor);
        } else if(computer_choice == "Paper") {
            iv_ComputerChoice.setImageResource(R.drawable.hand);
        }

        if(computer_choice == player_choice) {
            return "DRAW. Nobody wins!";
        }else if(player_choice == "Rock" && computer_choice == "Scissors") {
            HumanScore++;
            return "Rock crushes the Scissors. You Win!";
        }else if(player_choice == "Rock" && computer_choice == "Paper") {
            ComputerScore++;
            return "Paper covers rock. Computer Wins!";
        }else if(player_choice == "Scissors" && computer_choice == "Rock") {
            ComputerScore++;
            return "Rock Crushes Scissors. Computer Wins!";
        }else if(player_choice == "Scissors" && computer_choice == "Paper") {
            HumanScore++;
            return "Scissors cut paper. Computer Wins!";
        }else if(player_choice == "Paper" && computer_choice == "Rock") {
            HumanScore++;
            return "Paper covers rock. Computer Wins!";
        }else if(player_choice == "Paper" && computer_choice == "Scissors") {
            ComputerScore++;
            return "Scissors cuts paper. Computer Wins!";
        }else return"GOOD GAME";


    }
}
