package com.example.jiangshen.rubikscube2x2solver;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.content.Context;

/**
 * Created by jiangshen on 10/17/15.
 */
public class DrawView extends CameraView {
    private Paint textPaint = new Paint();

    public DrawView(Context context) {
        super(context);
        // Create out paint to use for drawing
        textPaint.setARGB(255, 200, 0, 0);
        textPaint.setTextSize(60);
        // This call is necessary, or else the
        // draw method will not be called.
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas){
        // A Simple Text Render to test the display
        canvas.drawText("Hello World!", 50, 50, textPaint);
    }
}
