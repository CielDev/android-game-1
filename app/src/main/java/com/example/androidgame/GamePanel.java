package com.example.androidgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;


/// Main Game Panel
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private Paint redPaint = new Paint();
    private SurfaceHolder holder;

    public GamePanel(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        redPaint.setColor(Color.RED);
    }

    /// Checks if user touched the screen. For now, just prints to console.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("User Touch Event!");
        return true;
    }

    /// This is just a test to see if we can draw something on the screen. Red square.
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Canvas c = surfaceHolder.lockCanvas();

        c.drawRect(50,50,100,100,redPaint);

        surfaceHolder.unlockCanvasAndPost(c);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }


    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
