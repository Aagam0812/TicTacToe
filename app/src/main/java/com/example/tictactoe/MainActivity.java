package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

 int activeplayer=0;
 boolean gameactive=true;
  int[] gamestate={2,2,2,2,2,2,2,2,2};
   int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
   Button playButton;
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());
        int tappcounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappcounter] == 2 && gameactive) {
            gamestate[tappcounter] = activeplayer;
            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.o);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activeplayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for (int[] winpostion : winpos) {
                if (gamestate[winpostion[0]] == gamestate[winpostion[1]] && gamestate[winpostion[1]] == gamestate[winpostion[2]] && gamestate[winpostion[0]] != 2) {
                    String winner = "Player Two";
                    if (gamestate[winpostion[0]] == 0) {

                        winner = "Player One";
                    }
                    gameactive = false;
                    TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                    winnermessage.setText(winner + " has won!!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
                    layout.setVisibility(View.VISIBLE);


                } else {
                    boolean gameOver = true;
                    for (int count : gamestate) {
                        if (count == 2)
                            gameOver = false;
                    }

                    if (gameOver) {
                        gameactive = false;
                        TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                        winnermessage.setText("It,s a Draw ");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);
                        layout.setVisibility(View.VISIBLE);

                    }


                }
            }

        }
    }

    public void playAgain(View view)
    {

        LinearLayout layout = (LinearLayout)findViewById(R.id.playagainlayout);
        layout.setVisibility(View.INVISIBLE);
         activeplayer=0;
           gameactive=true;
         for(int i=0;i<gamestate.length;i++)
         {
             gamestate[i]=2;
         }

        ImageView i1 = findViewById(R.id.imageView00);
         i1.setImageResource(0);
        i1 = findViewById(R.id.imageView02);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView03);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView10);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView11);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView12);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView20);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView21);
        i1.setImageResource(0);
        i1 = findViewById(R.id.imageView22);
        i1.setImageResource(0);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
