package com.coderfolk.multilamp.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;

import com.coderfolk.multilamp.customView.MultiLamp;
import com.coderfolk.multilamp.model.Target;


public class Circle implements Shape {


    private float radius;

    public Circle(float radius) {

        this.radius = radius;

    }


    @Override
    public void draw(Canvas canvas, Context context, PointF point, float value, Target target, Paint paint) {
        float density = context.getResources().getDisplayMetrics().density;
        int[] location = new int[2];
        target.getView().getLocationOnScreen(location);
        point.x = location[0] + target.getView().getWidth() / 2;
        point.y = location[1] + target.getView().getHeight() / 2;
//        point.x = target.getView().getX() + target.getView().getWidth() / 2;
//        point.y = target.getView().getY() + target.getView().getHeight() / 2;
        canvas.drawCircle(point.x, point.y, radius * density, paint);
        paint.setTextSize(15 * density);
        String[] lines = target.getMessage().split("\n");
        Log.d("Lines ", String.valueOf(lines.length));
        Paint txtPaint = new Paint();
        txtPaint.setColor(Color.WHITE);
        txtPaint.setTextSize(15 * density);
        switch (target.getDirection()) {
            //- (radius * density)

            /**
             * BOTTTOM DIRECTION SECTION
             *
             */
            case MultiLamp.BOTTOM:
                txtPaint.setTextAlign(Paint.Align.CENTER);
                float texty = point.y + ((radius * density) + (68 * density));
                for (int lineb = 0; lineb < lines.length; lineb++) {
                    Log.d("texty", String.valueOf(texty));
                    canvas.drawText(lines[lineb], point.x, texty, txtPaint);  //bottom
                    texty = texty + 22 * density;
                }

                float startYB = point.y + (radius * density);
                float stopYB = (startYB) + (10 * density);
                for (int i = 0; i < 4; i++) {
//                    Log.d("startX and Stopx", String.valueOf(startX) + " " + String.valueOf(stopX));
                    canvas.drawLine(point.x, startYB, point.x, stopYB, txtPaint);
                    startYB = (stopYB) + (3 * density);
                    stopYB = (startYB) + (10 * density);
                }
                break;


            /**
             *
             * TOP DIRECTION SECTION
             */

            case MultiLamp.TOP:

                txtPaint.setTextAlign(Paint.Align.CENTER);
                float textty = point.y - ((radius * density) + (55 * density));
                if (lines.length > 0) {
                    textty = textty - ((22 * lines.length) * density);
                }

                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textty));
                    canvas.drawText(lines[line], point.x, textty, txtPaint);
                    textty = textty + 22 * density;
                }

                float startYT = point.y - (radius * density);
                float stopYT = (startYT) - (10 * density);
                for (int i = 0; i < 4; i++) {
                    canvas.drawLine(point.x, startYT, point.x, stopYT, txtPaint);
                    startYT = (stopYT) - (3 * density);
                    stopYT = (startYT) - (10 * density);
                }

                break;


            /**
             * LEFT DIRECTION SECTION
             */
            case MultiLamp.LEFT:

                txtPaint.setTextAlign(Paint.Align.RIGHT);

                float textly = point.y + (6 * density);
                if (lines.length > 0) {
                    textly = textly - ((22 * ((int) lines.length / 2) * density));
                }
                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textly));
                    canvas.drawText(lines[line], point.x - ((radius * density) + (52 * density)), textly, txtPaint);
                    textly = textly + 22 * density;
                }

                float startXL = point.x - (radius * density);
                float stopXL = (startXL) - (10 * density);

                for (int i = 0; i < 4; i++) {
                    canvas.drawLine(startXL, point.y, stopXL, point.y, txtPaint);
                    startXL = (stopXL) - (3 * density);
                    stopXL = (startXL) - (10 * density);
                }
                break;

            /**
             * RIGHT DIRECTION SECTION
             */
            case MultiLamp.RIGHT:


                float textry = point.y + (6 * density);
                if (lines.length > 0) {
                    textry = textry - ((22 * ((int) lines.length / 2) * density));
                }
                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textry));
                    canvas.drawText(lines[line], point.x + ((radius * density) + (60 * density)), textry, txtPaint);        //right
                    textry = textry + 22 * density;
                }


                float startXR = point.x + (radius * density);
                float stopXR = (startXR) + (10 * density);
                for (int i = 0; i < 4; i++) {
                    canvas.drawLine(startXR, point.y, stopXR, point.y, txtPaint);
                    startXR = (stopXR) + (3 * density);
                    stopXR = (startXR) + (10 * density);
                }
                break;

            default:
                break;
        }


    }

    @Override
    public int getHeight() {
        return (int) radius;
    }

    @Override
    public int getWidth() {
        return (int) radius;
    }
}


//        int scaledSize = context.getResources().getDimensionPixelSize(R.dimen.fontSizeCanvas);
//        paint.setTextScaleX(density);
//        paint.setTextSize(scaledSize);
