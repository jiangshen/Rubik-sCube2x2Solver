package com.example.jiangshen.rubikscube2x2solver;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CameraMain extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        rootView = findViewById(R.id.root_view);

        findViewById(R.id.cameraView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCapture();
                //to start camera
                //startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });
        ImageProcessor.setLabel((TextView) findViewById(R.id.textInstr));

        //TESTING!!!
        int w1 = getWindowManager().getDefaultDisplay().getWidth();
        int h1 = getWindowManager().getDefaultDisplay().getHeight();
        String a = String.format("w: %d h: %d", w1, h1);
        Log.d("CameraMain", a);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View verticalLine = findViewById(R.id.vertical_line);
        View horizontalLine = findViewById(R.id.horizontal_line);
        View box = findViewById(R.id.box);
        View squareFrameLayout = findViewById(R.id.square_framelayout);

        float boxX = box.getX();
        float boxY = box.getY();
        int left = verticalLine.getLeft();
        ImageProcessor.setDimension((int) (box.getX() - squareFrameLayout.getX()), (int) (box.getY() - squareFrameLayout.getY()),
                horizontalLine.getWidth(), verticalLine.getHeight());
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    protected void onCapture() {
        CameraView cv = (CameraView) findViewById(R.id.cameraView);
        cv.takePhoto();
        cv.setParentView(rootView);
    }
}