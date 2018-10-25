package com.coderfolk.multilamp.model;

import android.view.View;

import com.coderfolk.multilamp.shapes.Shape;

public class Target {

    private View view;
    private String message;
    private Shape shape;

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    private char direction;

    public Target() {

    }

    public Target(View view, String message, char direction, Shape shape) {
        this.view = view;
        this.message = message;
        this.shape = shape;
        this.direction = direction;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}

