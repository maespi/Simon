package com.example.marca.simonsays;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Marc Espinosa on 03/03/2018.
 */

public class Game{
    private int nTorns,nTorn,width,height;
    private int[] aJugades;
    private ImageView ivBoard;
    private final Handler handler;

    public Game(int nTorns, int nTorn, ImageView i, int width, int height) {
        this.nTorn = nTorn>0?nTorn:1;
        this.nTorns = nTorns<=this.nTorn?this.nTorn+5:nTorns+1;
        this.width = width;
        this.height = height;
        aJugades = new int[this.nTorns];
        ivBoard = i;
        handler = new Handler();
        startPlay();
    }

    public int[] getaJugades() {
        return aJugades;
    }

    public int getnTorn() {
        return nTorn;
    }

    public void setnTorn(int nTorn) {
        this.nTorn = nTorn;
    }

    public void startPlay(){
        aJugades[nTorn-1]=randomSelectPatterns();
        començarRondaSimon();
    }

    private int randomSelectPatterns(){

        Random rand = new Random();

        return rand.nextInt(8);
    }

    private void començarRondaSimon(){

        for (int n = 0; n<nTorn;n++){
            System.out.println("n:"+n+" Rand:"+aJugades[n]);
            desxifraSeleccionats(n);
        }
    }

    private void desxifraSeleccionats(int a){

        System.out.println(" Confirm n-->"+a);

        switch (aJugades[a]){
            case 0 :
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getlGreen());
                    }
                }, 2000*a);
                break;
            case 1:
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getsGreen());
                    }
                }, 2000*a);
                break;
            case 2 :
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getlRed());
                    }
                }, 2000*a);
                break;
            case 3:
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getsRed());
                    }
                }, 2000*a);
                break;
            case 4 :
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getlBlue());
                    }
                }, 2000*a);
                break;
            case 5:
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getsBlue());
                    }
                }, 2000*a);
                break;
            case 6 :
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getlGray());
                    }
                }, 2000*a);
                break;
            case 7:
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Figures.selectFigure(ivBoard,Color.YELLOW,Figures.getsGray());
                    }
                }, 2000*a);
                break;
            default :
                break;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Figures.drawCleanLayout(width,height,ivBoard);
            }
        }, 2000*(a+1));
        return;
    }

    public class simonTurnCanvasAnimation extends AsyncTask<Void, Void, Void>{


        @Override
        protected void onPostExecute(Void aVoid) {
            startPlay();
            return;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }



}
