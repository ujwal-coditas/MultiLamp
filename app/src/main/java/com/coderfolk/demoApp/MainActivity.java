package com.coderfolk.demoApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.coderfolk.multilamp.customView.MultiLamp;
import com.coderfolk.multilamp.model.Target;
import com.coderfolk.multilamp.shapes.Circle;
import com.coderfolk.multilamp.shapes.Rectangle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        TextView textView = findViewById(R.id.textView);
        MultiLamp multiLamp = new MultiLamp(getApplicationContext(), this);
        ArrayList<Target> targets = new ArrayList<>();
        targets.add(new Target(btn1, "This is button 1", MultiLamp.RIGHT, new Circle(40, getApplicationContext())));
        targets.add(new Target(btn2, "This is button 2", MultiLamp.LEFT, new Circle(40, getApplicationContext())));
        targets.add(new Target(textView, "This is textview", MultiLamp.TOP, new Rectangle(getApplicationContext())));
        multiLamp.build(targets);
    }
}
