package com.example.jiangshen.rubikscube2x2solver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by jiangshen on 10/18/15.
 */
public class ImageProcessor {

    private static TextView label;
    private static int currFace = 1;
    private static char[][] masterData = new char[8][6];
    private static int counter = 1;

    private static int iX, iY, iW, iH;


    private static Bitmap bmpTemp;

    public static boolean processImage(byte[] data) {
        //convert to bitmap
        Bitmap imgBMP = BitmapFactory.decodeByteArray(data, 0, data.length);

        imgBMP = RotateBitmap(imgBMP, 90.0f);
        //imgBMP = Bitmap.createBitmap(imgBMP, iX * 10, iY * 10, iW, iH);

        imgBMP = Bitmap.createBitmap(imgBMP, imgBMP.getWidth() / 2 - 625, imgBMP.getHeight() / 2 - 1000, 1250, 1250);

        bmpTemp = imgBMP;
        //setLabelText(iX + ", " + iY + ", " + iW + ", " + iH);

        return storeToArray(imgBMP);
    }

    public static void setDimension(int x, int y, int w, int h) {
        iX = x;
        iY = y;
        iW = w;
        iH = h;
    }

    public static byte[] returnImg(){
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bmpTemp.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, blob);
        return blob.toByteArray();
    }

    public static boolean storeToArray(Bitmap img) {

        int[] red = new int[4];
        int[] green = new int[4];
        int[] blue = new int[4];
        int[] avg = new int[4];


        int[][] allP = new int[4][5];

        int nCounter = 0;
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                int nCount = 1;
                allP[nCounter][0] = img.getPixel((2 * a + 1) * 1250 / 4, (2 * b + 1) * 1250 / 4);
                for (int i = -1; i < 1; i++) {
                    for (int j = -1; j < 1; j++) {
                        allP[nCounter][nCount++] = img.getPixel((2 * a + 1) * (1250 / 4) - 20 - 40 * i, (2 * b + 1) * (1250 / 4) - 20 - 40 * j);
                    }
                }
                nCounter++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int p : allP[i]) {
                red[i] += Color.red(p);
                green[i] += Color.green(p);
                blue[i] += Color.blue(p);
            }
            red[i] = red[i] / 5;
            green[i] = green[i] / 5;
            blue[i] = blue[i] / 5;
            avg[i] = (red[i] + green[i] + blue[i]) / 3;
        }




        //setLabelText(red + ", " + green + ", " + blue + " " + colorAnalyzer(red, green, blue, avg));
        //setLabelText(avg[0] + " | " + red + " " + green + " " + blue + " " + colorAnalyzer2(red[1], green[1], blue[1]) + colorAnalyzer(red[0], green[0], blue[0], avg[0]));

        String result = "";
        String result2 = "";
        for (int z = 0; z < 4; z++) {
            //check null here

            String s = colorAnalyzer2(red[z],green[z],blue[z]);
            if(s == null) {
                return false;
            }
            result += s;
            result2 += red[z]+""+green[z]+""+blue[z];
            //result2 += colorAnalyzer(red[z],green[z],blue[z],avg[z]);
        }

        //setLabelText(result + result2);
        //if(result.contains(null)) return false;

        addToMaster(result);
        counter++;

        return true;
    }

    public static void addToMaster(String input) {
        if (counter == 1) {
            masterData[2][2] = input.charAt(0);
            masterData[3][2] = input.charAt(1);
            masterData[2][3] = input.charAt(2);
            masterData[3][3] = input.charAt(3);
        } else if (counter == 2) {
            masterData[4][0] = input.charAt(0);
            masterData[5][0] = input.charAt(1);
            masterData[4][1] = input.charAt(2);
            masterData[5][1] = input.charAt(3);
        } else if (counter == 3) {
            masterData[4][4] = input.charAt(0);
            masterData[5][4] = input.charAt(1);
            masterData[4][5] = input.charAt(2);
            masterData[5][5] = input.charAt(3);
        } else if (counter == 4) {
            masterData[4][2] = input.charAt(0);
            masterData[5][2] = input.charAt(1);
            masterData[4][3] = input.charAt(2);
            masterData[5][3] = input.charAt(3);
        } else if (counter == 5) {
            masterData[0][2] = input.charAt(0);
            masterData[1][2] = input.charAt(1);
            masterData[0][3] = input.charAt(2);
            masterData[1][3] = input.charAt(3);
        } else if (counter == 6) {
            masterData[6][2] = input.charAt(0);
            masterData[7][2] = input.charAt(1);
            masterData[6][3] = input.charAt(2);
            masterData[7][3] = input.charAt(3);
        }
    }

    public static char[][] getMasterData() {
        return masterData;
    }

    public static String colorAnalyzer(int r, int g, int b, int avg) {
        if (avg > 170) {
            return "w";
        } else if (avg > 145 && avg < 171) {
            return "y";
        } else if (avg > 125 && avg < 146) {
            return "o";
        } else {
            if (r > g && r > b) {
                return "r";
            } else if (b > g && b > r) {
                return "b";
            } else if (g > b && g > r) {
                return "g";
            }
        }
        return "";
    }

    public static String colorAnalyzer2(int red, int green, int blue) {
        if(red > 150 && blue > 150 && green > 150) {
            //It's white
            return "w";
            //pass = true;
        } else if (red < 100 && green > 75 && green < 145 && blue > 100 && blue < 175) {
            //It's blue
            return "b";
            //pass = true;
        } else if(red > 150 && green > 150 && blue < 125) {
            // it's yellow
            return "y";
            //pass = true;
        } else if(red < 100 && green > 125 && blue > 75 && blue < 175) {
            // it's green
            return "g";
            //pass = true;
        } else if(red > 125 && green >= 97 && green < 200 && blue < 125) {
            // it's orange
            return "o";
            //pass = true;
        } else if (red > 75 && green < 97 && blue < 130) {
            //it's red
            return "r";
            //pass = true;
        }
        return null;
    }

    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

    public static void setLabel(TextView tv) {
        label = tv;
    }

    public static void setLabelText(String s) {
        label.setText(s);
    }
}
