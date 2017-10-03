package com.example.aquib.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.aquib.tictactoe.R.id.player1;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    boolean gameActive = true;

    int count = 0;

    int p1 = 0, p2 = 0;

    int Tap[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int Win[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void drop(View view) {

        // yellow=0 red=1

        String P1, P2;

        ImageView image = (ImageView) view;

        ImageView img1 = (ImageView) findViewById(R.id.img1);

        ImageView img2 = (ImageView) findViewById(R.id.img2);

        TextView Txt = (TextView) findViewById(R.id.winnerMessage);

        TextView play1 = (TextView) findViewById(R.id.player1);

        TextView play2 = (TextView) findViewById(R.id.player2);

        //ImageView img1=(ImageView)view;

        int Tapped = Integer.parseInt(image.getTag().toString());

        // System.out.println(image.getTag().toString());

        if (Tap[Tapped] == 2 && gameActive) {

           //image.setTranslationY(-1000f);

            Tap[Tapped] = activePlayer;

            if (activePlayer == 0) {

                image.setImageResource(R.drawable.yellow);

                activePlayer = 1;

                count++;

            } else {

                image.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            if (count == 5) {

                Txt.setText("Draw");

                LinearLayout layout1 = (LinearLayout) findViewById(R.id.playAgainLayout);

                layout1.setVisibility(View.VISIBLE);

            }

           // image.animate().translationYBy(1000f).setDuration(700);

          //  image.animate().setDuration(800);

        }

        for (int wining[] : Win) {

            if (Tap[wining[0]] == Tap[wining[1]] && Tap[wining[1]] == Tap[wining[2]] && Tap[wining[0]] != 2 && gameActive) {

                if (Tap[wining[0]] == 0) {

                    Txt.setText("Yellow Has Won");

                    p1++;

                    P1 = String.valueOf(p1);

                    System.out.println(Tap[wining[0]]);

                    img1.setVisibility(View.VISIBLE);

                    play1.setText(P1);

                    MediaPlayer media = MediaPlayer.create(this, R.raw.clap);

                    media.start();

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                    TextView l1 = (TextView) findViewById(R.id.player1);

                    l1.setVisibility(View.VISIBLE);

                    gameActive = false;
                } else if (Tap[wining[0]] == 1) {

                    Txt.setText("Red Has Won");

                    p2++;

                    P2 = String.valueOf(p2);

                    img2.setVisibility(View.VISIBLE);

                    play2.setText(P2);

                    MediaPlayer media = MediaPlayer.create(this, R.raw.clap);

                    media.start();

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                    TextView l2 = (TextView) findViewById(R.id.player2);

                    l2.setVisibility(View.VISIBLE);

                    gameActive = false;

                }

            }

        }

    }

    public void playAgain(View view) {

        gameActive = true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        count = 0;

        for (int i = 0; i < Tap.length; i++) {

            Tap[i] = 2;

        }

        GridLayout grid = (GridLayout) findViewById(R.id.gridLay);

        for (int i = 0; i < grid.getChildCount(); i++) {

            ((ImageView) grid.getChildAt(i)).setImageResource(0);

        }

    }

    public void Retry_1(View view) {

        playAgain(view);

    }

    public void reSet(View view) {

        TextView l1 = (TextView) findViewById(R.id.player1);

        TextView l2 = (TextView) findViewById(R.id.player2);

        p1 = 0;
        p2 = 0;

        l1.setVisibility(View.INVISIBLE);
        l2.setVisibility(View.INVISIBLE);

        ImageView img1 = (ImageView) findViewById(R.id.img1);

        ImageView img2 = (ImageView) findViewById(R.id.img2);

        img1.setVisibility(View.INVISIBLE);

        img2.setVisibility(View.INVISIBLE);

        playAgain(view);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         }

    }


