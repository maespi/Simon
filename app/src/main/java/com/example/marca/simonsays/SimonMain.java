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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by marca on 26/02/2018.
 */

public class SimonMain extends AppCompatActivity {

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

    public boolean onTouchEvent(MotionEvent event) {
        System.out.println(event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                System.out.println("X:" + (int) event.getX() + "& Y:" + (int) event.getY());
            }
        }
        Toast.makeText(this, "View is clicked", Toast.LENGTH_LONG).show();
        return true;
    }


    public void configLayoutStart(){
        Point size = new Point();
        mLinearLayout = new LinearLayout(this);
        Display display = getWindowManager().getDefaultDisplay();
        ImageView i = (ImageView)findViewById(R.id.imageCanvas);

        display.getSize(size);
        int width = size.x;
        int height = size.y-(size.y/7)+((size.y/7)/8);
        Figures.setSimonPaths(width,height);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        Path lRed = Figures.getlRed();
        Path sRed = Figures.getsRed();
        Path lBlue = Figures.getlBlue();
        Path sBlue = Figures.getsBlue();
        Path lGreen = Figures.getlGreen();
        Path sGreen = Figures.getsGreen();
        Path lMagenta = Figures.getlGray();
        Path sGray = Figures.getsGray();

        canvas.drawPath(lRed,paint);
        canvas.drawPath(sRed,paint);
        paint.setColor(Color.BLUE);
        canvas.drawPath(lBlue,paint);
        canvas.drawPath(sBlue,paint);
        paint.setColor(Color.GREEN);
        canvas.drawPath(lGreen,paint);
        canvas.drawPath(sGreen,paint);
        paint.setColor(Color.LTGRAY);
        canvas.drawPath(lMagenta,paint);
        canvas.drawPath(sGray,paint);
        i.setImageBitmap(bitmap);

        //i.onTouchEvent();
    }
    public void drawCanvas(){

    }

}
