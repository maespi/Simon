package com.example.marca.simonsays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by marca on 26/02/2018.
 */

public class SimonMain extends AppCompatActivity implements View.OnTouchListener {

    public LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarCanvas);
        setSupportActionBar(myToolbar);
        configLayoutStart();
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

    public void configLayoutStart(){
        Point size = new Point();
        mLinearLayout = new LinearLayout(this);
        Display display = getWindowManager().getDefaultDisplay();
        ImageView i = (ImageView)findViewById(R.id.imageCanvas);
        display.getSize(size);
        int width = size.x;
        int height = size.y-(size.y/7)+((size.y/7)/8);
        Figures.drawCleanLayout(width,height,i);

        i.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("X:" + (int) motionEvent.getX() + "& Y:" + (int) motionEvent.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                    default:
                        break;
                }
                if (Figures.getRlGreen().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                    Toast.makeText(getApplicationContext(), "Green Large Area", Toast.LENGTH_SHORT).show();
                }else if (Figures.getRsGreen().contains((int)motionEvent.getX(),(int)motionEvent.getY())){
                    Toast.makeText(getApplicationContext(), "Green Short Area", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(), "X:" + (int) motionEvent.getX() + "& Y:" + (int) motionEvent.getY(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    public void drawCanvas(){

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("X:" + (int) motionEvent.getX() + "& Y:" + (int) motionEvent.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        Toast.makeText(this, "View is clicked", Toast.LENGTH_LONG).show();
        return true;
    }
}
