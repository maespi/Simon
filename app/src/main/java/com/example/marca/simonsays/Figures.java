package com.example.marca.simonsays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by marca on 28/02/2018.
 */

public class Figures extends AppCompatActivity{
   private static Path lRed = new Path();
   private static Path sRed = new Path();
   private static Path lBlue = new Path();
   private static Path sBlue = new Path();
   private static Path lGreen = new Path();
   private static Path sGreen = new Path();
   private static Path lGray = new Path();
   private static Path sGray = new Path();
   private static Region RlRed = new Region();
   private static Region RsRed = new Region();
   private static Region RlBlue = new Region();
   private static Region RsBlue = new Region();
   private static Region RlGreen = new Region();
   private static Region RsGreen = new Region();
   private static Region RlGray = new Region();
   private static Region RsGray = new Region();


    public static Path getlRed() {
        return lRed;
    }

    public static void setlRed(Path lRed) {
        Figures.lRed = lRed;
    }

    public static Path getsRed() {
        return sRed;
    }

    public static void setsRed(Path sRed) {
        Figures.sRed = sRed;
    }

    public static Path getlBlue() {
        return lBlue;
    }

    public static void setlBlue(Path lBlue) {
        Figures.lBlue = lBlue;
    }

    public static Path getsBlue() {
        return sBlue;
    }

    public static void setsBlue(Path sBlue) {
        Figures.sBlue = sBlue;
    }

    public static Path getlGreen() {
        return lGreen;
    }

    public static void setlGreen(Path lGreen) {
        Figures.lGreen = lGreen;
    }

    public static Path getsGreen() {
        return sGreen;
    }

    public static void setsGreen(Path sGreen) {
        Figures.sGreen = sGreen;
    }

    public static Path getlGray() {
        return lGray;
    }

    public static void setlGray(Path lGray) {
        Figures.lGray = lGray;
    }

    public static Path getsGray() {
        return sGray;
    }

    public static Region getRlRed() {
        return RlRed;
    }

    public static Region getRsRed() {
        return RsRed;
    }

    public static Region getRlBlue() {
        return RlBlue;
    }

    public static Region getRsBlue() {
        return RsBlue;
    }

    public static Region getRlGreen() {
        return RlGreen;
    }

    public static Region getRsGreen() {
        return RsGreen;
    }

    public static Region getRlGray() {
        return RlGray;
    }

    public static Region getRsGray() {
        return RsGray;
    }

    public static void setsGray(Path sGray) {
        Figures.sGray = sGray;
    }

    public static void setSimonVariables(int width, int height ){
        Path lRed = new Path();
        RectF rectF = new RectF(width/5,0,(width/5)*4,(height/6)-50);
        lRed.addRect(rectF,Path.Direction.CW);
        getRlRed().setPath(lRed,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setlRed(lRed);

        Path sRed = new Path();
        rectF = new RectF((width/5)*2,height/6,(width/5)*3,((height/6)*2)-50);
        sRed.addRect(rectF,Path.Direction.CW);
        getRsRed().setPath(sRed,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setsRed(sRed);

        Path lBlue = new Path();
        rectF = new RectF(0,height/6,((width/5)-50),(height/6)*5);
        lBlue.addRect(rectF,Path.Direction.CW);
        getRlBlue().setPath(lBlue,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setlBlue(lBlue);

        Path sBlue = new Path();
        rectF = new RectF(width/5,(height/6)*2 ,((width/5)*2)-25,(height/6)*4);
        sBlue.addRect(rectF,Path.Direction.CW);
        getRsBlue().setPath(sBlue,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setsBlue(sBlue);

        Path lGreen = new Path();
        rectF = new RectF(((width/5)*4)+50,height/6 ,width,(height/6)*5);
        lGreen.addRect(rectF,Path.Direction.CW);
        getRlGreen().setPath(lGreen,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setlGreen(lGreen);

        Path sGreen = new Path();
        rectF = new RectF(((width/5)*3)+25,(height/6)*2 ,(width/5)*4,(height/6)*4);
        sGreen.addRect(rectF,Path.Direction.CW);
        getRsGreen().setPath(sGreen,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setsGreen(sGreen);

        Path lGray = new Path();
        rectF = new RectF(width/5,((height/6)*5)+50,(width/5)*4,height);
        lGray.addRect(rectF,Path.Direction.CW);
        getRlGray().setPath(lGray,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setlGray(lGray);

        Path sGray = new Path();
        rectF = new RectF((width/5)*2,((height/6)*4)+50,(width/5)*3,(height/6)*5);
        sGray.addRect(rectF,Path.Direction.CW);
        getRsGray().setPath(sGray,new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        setsGray(sGray);
    }

    public static void drawCleanLayout(int width, int height, ImageView i){

        Figures.setSimonVariables(width,height);
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
    }

    public static void selectFigure(ImageView img, int color, Path mPath){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);
        Bitmap btm = ((BitmapDrawable) img.getDrawable()).getBitmap();
        Canvas canvas = new Canvas(btm);
        canvas.drawPath(mPath,paint);
        img.setImageBitmap(btm);
    }
}
