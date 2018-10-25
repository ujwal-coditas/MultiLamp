package com.coderfolk.multilamp.customView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coderfolk.multilamp.R;
import com.coderfolk.multilamp.model.Target;

import java.util.ArrayList;

public class MultiLamp extends RelativeLayout {

    private Paint mBackgroundPaint;
    private float mCx = -1;
    private float mCy = -1;
    private int overlayColor = Color.parseColor("#D20E0F02");
    private ArrayList<Target> list;
    private Activity activity;
    public static final char LEFT = 'l';
    public static final char RIGHT = 'r';
    public static final char TOP = 't';
    public static final char BOTTOM = 'b';
    private Context context;
    private float density;
    private Callback callback;

    public interface Callback {
        void onTutorialFinished();
    }

    public MultiLamp(Context context, Activity activity) {
        super(context);
        this.activity = activity;
        this.context = context;

        init();
    }

    public MultiLamp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MultiLamp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MultiLamp(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        density = context.getResources().getDisplayMetrics().density;
        list = new ArrayList<>();
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mBackgroundPaint.setTextSize(118f);
        mBackgroundPaint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    @SuppressLint("ClickableViewAccessibility")
    public void build(ArrayList<Target> list) {
        this.list = list;
//        bringToFront();
        setWillNotDraw(false);
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

//        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams()
//        this.setLayoutParams();
        this.setClickable(false);
        if (null != this.getParent()) {
            ((ViewGroup) ((Activity) activity).getWindow().getDecorView()).removeView(this);
        }
//        WindowManager.LayoutParams params5 = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
//                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
//                PixelFormat.TRANSLUCENT);

        ((ViewGroup) activity.getWindow().getDecorView()).addView(this);

//        Button button = new Button(this.getContext());
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        button.setLayoutParams(params);
//        button.setText("Got it");
//        button.setTextColor(Color.WHITE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            button.setBackground(getResources().getDrawable(R.drawable.bg_button));
//        } else {
//            button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//        }
//        final View view3 = this;
//
//        this.addView(button);
//        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) button.getLayoutParams();
//        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        params2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        params2.setMargins(0, 0, 10 * ((int) density), 10 * ((int) density));
//        button.setLayoutParams(params2);
//
////        button.setOnClickListener(new OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(context, "REMOVING", Toast.LENGTH_SHORT).show();
////                view3.setVisibility(View.GONE);
////            }
////        });
////        final Callback callback = (Callback) this;
//        button.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
////                view3.setVisibility(View.GONE);
//                ((ViewGroup) ((Activity) activity).getWindow().getDecorView()).removeView(view3);
//                if (null != callback)
//                    callback.onTutorialFinished();
//                return false;
//            }
//        });
//        button.setOnClickListener(this);
        if (null != list && list.size() > 0) {
            invalidate();
//            Toast.makeText(context, "Inside OVERLAY", Toast.LENGTH_SHORT).show();
//            Log.d("INSIDE", String.valueOf(this.get))
        }
    }

    public void addCallback(Callback callback) {
        this.callback = callback;
    }

    //
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (null != activity && null != this.getParent()) {
            ((ViewGroup) ((Activity) activity).getWindow().getDecorView()).removeView(this);
            if (null != callback)
                callback.onTutorialFinished();
        }
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint;
        canvas.drawColor(overlayColor);
        if (null != list && list.size() > 0) {
            for (Target target : list) {
                View view = target.getView();
                paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                paint.setTextSize(60f);
                paint.setTypeface(Typeface.create("Arial", Typeface.NORMAL));
                int location[] = new int[2];
                view.getLocationInWindow(location);
                float x = view.getX() + view.getWidth() / 2f;
                float y = view.getY() + view.getHeight() / 2f;
                target.getShape().draw(canvas, new PointF(view.getX(), view.getY()), 0, target, paint);
            }
        }

//        canvas.drawCircle(mCx, mCy, 100f, mBackgroundPaint);
    }
//
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
//        if (null != activity && null != this.getParent()) {
////            ((ViewGroup) ((Activity) activity).getWindow().getDecorView()).removeView(this);
//            this.setVisibility(View.GONE);
//        }
//    }
}
