package com.example.marca.simonsays;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by marca on 26/02/2018.
 */

public class SimonMain extends AppCompatActivity {

    public LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gam_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarCanvas);
        setSupportActionBar(myToolbar);
        drawEmptyLayout();
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

    public void drawEmptyLayout(){
        Point size = new Point();
        mLinearLayout = new LinearLayout(this);
        Display display = getWindowManager().getDefaultDisplay();
        ImageView i = (ImageView)findViewById(R.id.imageCanvas);

        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width/2, height/2, width/2, paint);
        paint.setColor(Color.RED);
        Path lRed = new Path();
        float x = width/2, y = height/2, r = width/4, angle = 50;
        //lRed.moveTo((width/8)*3,(height/8)*5);
        lRed.arcTo(new RectF(x, y-r, x+2*r, y+r),180,angle);
        lRed.lineTo((float) (x - r * (1 - Math.cos(Math.toRadians(angle)))), (float) (y - r * Math.sin(Math.toRadians(angle))));
        lRed.arcTo(new RectF(x - 2 * r, y - r, x, y + r), -angle, angle);
        lRed.close();
        /*Path mPath = new Path();
        mPath.moveTo((width/8)*3,(height/3)*2);
        mPath.addArc((width/8)*3,(height/3)*2,(width/8)*3+50,(height/3)*2+50,0,360);
        canvas.drawPath(mPath,paint);*/
        canvas.drawPath(lRed,paint);
        i.setImageBitmap(bitmap);
    }
    public void drawCanvas(){

    }

}
