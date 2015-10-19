package com.example.jiangshen.rubikscube2x2solver;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CameraMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_main);


        findViewById(R.id.cameraView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCapture();

                //to start camera
                //startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });

        ImageProcessor.setLabel((TextView) findViewById(R.id.textInstr));
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
    }
}