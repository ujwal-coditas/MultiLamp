package com.coderfolk.multilamp.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.util.Log;

import com.coderfolk.multilamp.customView.MultiLamp;
import com.coderfolk.multilamp.model.Target;

public class Rectangle implements Shape {


    @Override
    public void draw(Canvas canvas, Context context, PointF point, float value, Target target, Paint paint) {
        float density = context.getResources().getDisplayMetrics().density;
        int[] location = new int[2];
        target.getView().getLocationInWindow(location);
        point.x = location[0];
        point.y = location[1];
//        point.x = target.getView().getX();
//        point.y = target.getView().getY();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(point.x, point.y, point.x + target.getView().getWidth(), point.y + target.getView().getHeight(), 50, 50, paint);
        } else {
            canvas.drawRect(point.x, point.y, point.x + target.getView().getWidth(), point.y + target.getView().getHeight(), paint);
        }


        //copied from circle

//        canvas.drawCircle(point.x, point.y, radius * density, paint);
        paint.setTextSize(15 * density);
        String[] lines = target.getMessage().split("\n");
        paint.setColor(Color.WHITE);
        Paint txtPaint = new Paint();
        txtPaint.setColor(Color.WHITE);
        txtPaint.setTextSize(15 * density);
        Log.d("Lines ", String.valueOf(lines.length));
        switch (target.getDirection()) {
            //- (radius * density)
            /**
             * BOTTTOM DIRECTION SECTION
             *
             */
            case MultiLamp.BOTTOM:
                point.x = point.x + target.getView().getWidth() / 2;
//                point.y = point.y;// - target.getView().getHeight();// * density;
                txtPaint.setTextAlign(Paint.Align.CENTER);
//                 * density
                float texty = point.y + ((target.getView().getHeight()) + (68 * density));
                for (int lineb = 0; lineb < lines.length; lineb++) {
                    Log.d("texty", String.valueOf(texty));
                    canvas.drawText(lines[lineb], point.x, texty, txtPaint);  //bottom
                    texty = texty + 22 * density;
                }
// * density
                float startYB = point.y + (target.getView().getHeight());
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
                point.x = point.x + (target.getView().getWidth()) / 2;
//                point.y = point.y + target.getView().getHeight() * density;
                txtPaint.setTextAlign(Paint.Align.CENTER);
//                 * density
                float textty = point.y - 40 * density;//((target.getView().getHeight()) + (55 * density));
                if (lines.length > 0) {
                    textty = textty - ((22 * lines.length) * density);
                }

                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textty));
                    canvas.drawText(lines[line], point.x, textty, txtPaint);
                    textty = textty + 22 * density;
                }

//                 * density
                float startYT = point.y;// - (target.getView().getHeight());
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

                //+ target.getView().getWidth()
//                point.x = point.x;
                txtPaint.setTextAlign(Paint.Align.RIGHT);
                float textly = point.y + (target.getView().getHeight() / 2) + (6 * density);
                if (lines.length > 0) {
                    textly = textly - ((22 * ((int) lines.length / 2) * density));
                }
                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textly));
//                    (target.getView().getWidth() * density)
                    canvas.drawText(lines[line], point.x - (52 * density), textly, txtPaint);
                    textly = textly + 22 * density;
                }

                float startXL = point.x;//- (target.getView().getWidth() * density);
                float stopXL = (startXL) - (10 * density);

                for (int i = 0; i < 4; i++) {
                    canvas.drawLine(startXL, point.y + target.getView().getHeight() / 2, stopXL, point.y + target.getView().getHeight() / 2, txtPaint);
                    startXL = (stopXL) - (3 * density);
                    stopXL = (startXL) - (10 * density);
                }
                break;

            /**
             * RIGHT DIRECTION SECTION
             */
            case MultiLamp.RIGHT:


                float textry = point.y + (target.getView().getHeight() / 2) + (6 * density);
                if (lines.length > 0) {
                    textry = textry - ((22 * ((int) lines.length / 2) * density));
                }
                for (int line = 0; line < lines.length; line++) {
                    Log.d("texty", String.valueOf(textry));
                    canvas.drawText(lines[line], point.x + ((target.getView().getWidth()) + (60 * density)), textry, txtPaint);        //right
                    textry = textry + 22 * density;
                }


                float startXR = point.x + (target.getView().getWidth());
                float stopXR = (startXR) + (10 * density);
                for (int i = 0; i < 4; i++) {
                    canvas.drawLine(startXR, point.y + (target.getView().getHeight() / 2), stopXR, point.y + (target.getView().getHeight() / 2), txtPaint);
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
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }
}
