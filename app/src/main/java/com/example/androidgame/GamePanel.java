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
    private float x,y;

    public GamePanel(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        redPaint.setColor(Color.RED);
    }

    /// Renders the red square at the current X and Y coordinates.
    private void render(){
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.BLACK);
        c.drawRect(x,y,x+50,y+50,redPaint);

        holder.unlockCanvasAndPost(c);
    }

    /// Updates X and Y coordinates of the red square to where the user touched the screen.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        render();
        return true;
    }

    /// This is just a test to see if we can draw something on the screen. Red square.
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        render();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }


    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
