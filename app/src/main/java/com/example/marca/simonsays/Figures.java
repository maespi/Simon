package com.example.marca.simonsays;

import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by marca on 28/02/2018.
 */

public class Figures {
   private static Path lRed = new Path();
   private static Path sRed = new Path();
   private static Path lBlue = new Path();
   private static Path sBlue = new Path();
   private static Path lGreen = new Path();
   private static Path sGreen = new Path();
   private static Path lGray = new Path();
   private static Path sGray = new Path();

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

    public static void setsGray(Path sGray) {
        Figures.sGray = sGray;
    }

    public static void setSimonPaths(int width, int height ){
        Path lRed = new Path();
        lRed.addRect(new RectF(width/5,0,(width/5)*4,(height/6)-50),Path.Direction.CW);
        setlRed(lRed);

        Path sRed = new Path();
        sRed.addRect(new RectF((width/5)*2,height/6,(width/5)*3,((height/6)*2)-50),Path.Direction.CW);
        setsRed(sRed);

        Path lBlue = new Path();
        lBlue.addRect(new RectF(0,height/6,((width/5)-50),(height/6)*5),Path.Direction.CW);
        setlBlue(lBlue);

        Path sBlue = new Path();
        sBlue.addRect(new RectF(width/5,(height/6)*2 ,((width/5)*2)-25,(height/6)*4),Path.Direction.CW);
        setsBlue(sBlue);

        Path lGreen = new Path();
        lGreen.addRect(new RectF(((width/5)*4)+50,height/6 ,width,(height/6)*5),Path.Direction.CW);
        setlGreen(lGreen);

        Path sGreen = new Path();
        sGreen.addRect(new RectF(((width/5)*3)+25,(height/6)*2 ,(width/5)*4,(height/6)*4),Path.Direction.CW);
        setsGreen(sGreen);

        Path lGray = new Path();
        lGray.addRect(new RectF(width/5,((height/6)*5)+50,(width/5)*4,height),Path.Direction.CW);
        setlGray(lGray);

        Path sGray = new Path();
        sGray.addRect(new RectF((width/5)*2,((height/6)*4)+50,(width/5)*3,(height/6)*5),Path.Direction.CW);
        setsGray(sGray);
    }
}
