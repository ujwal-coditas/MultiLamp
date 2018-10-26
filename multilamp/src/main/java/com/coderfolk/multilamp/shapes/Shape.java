package com.coderfolk.multilamp.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.coderfolk.multilamp.model.Target;

public interface Shape {


    void draw(Canvas canvas, Context context, PointF point, float value, Target target, Paint paint);

    int getHeight();

    int getWidth();
}
