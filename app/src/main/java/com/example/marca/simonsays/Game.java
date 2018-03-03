package com.example.marca.simonsays;

import android.graphics.Color;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;
import java.util.logging.LogRecord;

/**
 * Created by Marc Espinosa on 03/03/2018.
 */

public class Game {
    private int nTorns;
    private int nTorn;
    private int[] aJugades;
    private ImageView ivBoard;
    private final Handler handler;

    public Game(int nTorns, int nTorn, ImageView i) {
        this.nTorns = nTorns;
        this.nTorn = nTorn;
        aJugades = new int[nTorns];
        ivBoard = i;
        handler = new Handler();
    }

    public void startPlay(){
        aJugades[nTorn]=randomSelectPatterns();
        selections();
    }

    private int randomSelectPatterns(){

        Random rand = new Random();
        int n = rand.nextInt(7)+1;

        return n;
    }

    private void selections(){
        for (int n = 0; n<nTorn+1;n++){
            handler.postDelayed(new Runnable() {
                public void run() {
                    Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getlRed());
                }
            }, 2000);
        }
    }

      

}
