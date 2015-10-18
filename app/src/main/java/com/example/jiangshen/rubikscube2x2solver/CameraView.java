package com.example.jiangshen.rubikscube2x2solver;

/**
 * Created by jiangshen on 10/17/15.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.*;
import android.graphics.Rect;


/** A basic Camera preview class */
public class CameraView extends SurfaceView implements SurfaceHolder.Callback {

    private int count = 0;
    private final String[] lblText = {"LEFT", "RIGHT","FRONT","BACK","BOTTOM"};


    private static final String TAG ="CameraView";
    
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public CameraView(Context context) {
        super(context);
        init();
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CameraView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        try {
            mCamera = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Toast.makeText(getContext(), "Something went wrong, couldn't get the camera", Toast.LENGTH_SHORT).show();
        }

        mCamera.setDisplayOrientation(90);

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.

        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();

            //set camera to continually auto-focus
            Camera.Parameters params = mCamera.getParameters();
            //*EDIT*//params.setFocusMode("continuous-picture");
            //It is better to use defined constraints as opposed to String, thanks to AbdelHady
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            mCamera.setParameters(params);

        } catch (IOException e) {
            Log.d(TAG, "Error setting camera preview: " + e.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (mHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e){
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();

        } catch (Exception e){
            Log.d(TAG, "Error starting camera preview: " + e.getMessage());
        }
    }

    /**
     * When this function returns, mCamera will be null.
     */
    private void stopPreviewAndFreeCamera() {

        if (mCamera != null) {
            // Call stopPreview() to stop updating the preview surface.
            mCamera.stopPreview();

            // Important: Call release() to release the camera for use by other
            // applications. Applications should release the camera immediately
            // during onPause() and re-open() it during onResume()).
            mCamera.release();

            mCamera = null;
        }
    }

    public void takePhoto () {
        mCamera.takePicture(shutterCallback, rawCallback, jpegCallback);
    }

    ShutterCallback shutterCallback = new ShutterCallback() {
        public void onShutter() {
            //Log.d(TAG, "onShutter'd");
        }
    };

    PictureCallback rawCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            //Log.d(TAG, "onPictureTaken - raw");
        }
    };

    PictureCallback jpegCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            resetCam();

            //Toast.makeText(getContext(), "Photos taken, processing...", Toast.LENGTH_SHORT).show();

//            ImageProcessor ip = new ImageProcessor();
//            byte[] finalData = ip.processImage(data);

            boolean result = ImageProcessor.processImage(data);
            //
            if (count > 4) {
                Cube cb = new Cube(ImageProcessor.getMasterData());
                cb.solve();
                ImageProcessor.setLabelText(cb.cleanOutput());
                Toast.makeText(getContext(), ":(", Toast.LENGTH_SHORT).show();
                return;
            }

            if(result) {
                ImageProcessor.setLabelText("Please take the " + lblText[count] + " view");
                count++;
            } else {
                Toast.makeText(getContext(), "Did not get data, take again!", Toast.LENGTH_SHORT).show();
            };

            //ImageView iv = new ImageView(getContext());
            //iv.setImageDrawable(Drawable.createFromStream(new ByteArrayInputStream(ImageProcessor.returnImg()), "??"));
            //((FrameLayout)getParent()).addView(iv);
        }
    };

    private void resetCam() {
        mCamera.startPreview();
    }
}