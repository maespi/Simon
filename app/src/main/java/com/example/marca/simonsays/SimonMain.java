package com.example.marca.simonsays;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by marca on 26/02/2018.
 */

public class SimonMain extends AppCompatActivity {

    public LinearLayout mLinearLayout;
    public Game myGame;
    private int Coounter,nTorns;
    private ImageView canvas;
    private int[] bJugades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarCanvas);
        setSupportActionBar(myToolbar);

        nTorns = 5;
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x;
        int height = size.y-(size.y/7)+((size.y/7)/8);
        Figures.setSimonVariables(width,height);
        configLayoutStart();
        canvas = (ImageView)findViewById(R.id.imageCanvas);
        myGame = new Game(nTorns,0,canvas, width, height);
        bJugades = new int[nTorns];
        Coounter=1;

        canvas.setOnTouchListener(Touchable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                finish();
                break;
            case R.id.action_settings:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnTouchListener nonTouchable = new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    };

    View.OnTouchListener Touchable = new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    if (Figures.getRlGreen().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=0;
                        Figures.selectFigure(canvas,Color.GREEN,Figures.getlGreen());
                    }else if (Figures.getRsGreen().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=1;
                        Figures.selectFigure(canvas,Color.GREEN,Figures.getsGreen());
                    }else if (Figures.getRlRed().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=2;
                        Figures.selectFigure(canvas,Color.RED,Figures.getlRed());
                    }else if (Figures.getRsRed().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        //Toast.makeText(getApplicationContext(), "Red Short Area", Toast.LENGTH_SHORT).show();
                        bJugades[Coounter-1]=3;
                        Figures.selectFigure(canvas,Color.RED,Figures.getsRed());
                    }else if (Figures.getRlBlue().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=4;
                        Figures.selectFigure(canvas,Color.BLUE,Figures.getlBlue());
                    }else if (Figures.getRsBlue().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=5;
                        Figures.selectFigure(canvas,Color.BLUE,Figures.getsBlue());
                    }else if (Figures.getRlGray().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=6;
                        Figures.selectFigure(canvas,Color.GRAY,Figures.getlGray());
                    }else if (Figures.getRsGray().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                        bJugades[Coounter-1]=7;
                        Figures.selectFigure(canvas,Color.GRAY,Figures.getsGray());
                    }else {Coounter--;}
                    Coounter++;
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    configLayoutStart();
                    if (Coounter>myGame.getnTorn()) {
                        int[] solutions = myGame.getaJugades();
                        int count = 0;
                        for (int a :
                                bJugades) {
                            System.out.print(a);
                            System.out.println(solutions[count]);
                            if (a != solutions[count])
                                return false; //Falta implementar la funcio per a guardar les dades!!
                            count++;
                        }
                        canvas.setOnTouchListener(nonTouchable);

                        Coounter = 1;
                        myGame.setnTorn(myGame.getnTorn() + 1);
                        Game.simonTurnCanvasAnimation a = myGame.new simonTurnCanvasAnimation();
                        a.execute();
                        try {
                            System.out.println("Sleep");
                            Thread.sleep(2000*(myGame.getnTorn())+1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Hii");
                        canvas.setOnTouchListener(Touchable);

                    }
                    view.performClick();
                    break;

                case MotionEvent.ACTION_CANCEL:
                    break;
                default:
                    break;
            }
            return true;
        }
    };



    public void configLayoutStart(){
        Point size = new Point();
        mLinearLayout = new LinearLayout(this);
        Display display = getWindowManager().getDefaultDisplay();
        ImageView i = (ImageView)findViewById(R.id.imageCanvas);
        display.getSize(size);
        int width = size.x;
        int height = size.y-(size.y/7)+((size.y/7)/8);
        Figures.drawCleanLayout(width,height,i);
    }
}
