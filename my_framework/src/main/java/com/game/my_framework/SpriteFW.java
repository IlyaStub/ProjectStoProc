package com.game.my_framework;

import android.graphics.Rect;

public abstract class SpriteFW {
    protected int maxScreenX;
    protected int minScreenX;
    protected int maxScreenY;
    protected int minScreenY;
    protected int x;
    protected int y;
    protected double speed;

    protected Rect hitBox;
    protected double radius;

    public int getMaxScreenX() {
        return maxScreenX;
    }

    public void setMaxScreenX(int maxScreenX) {
        this.maxScreenX = maxScreenX;
    }

    public int getMixScreenX() {
        return minScreenX;
    }

    public void setMixScreenX(int mixScreenX) {
        this.minScreenX = mixScreenX;
    }

    public int getMaxScreenY() {
        return maxScreenY;
    }

    public void setMaxScreenY(int maxScreenY) {
        this.maxScreenY = maxScreenY;
    }

    public int getMixScreenY() {
        return minScreenY;
    }

    public void setMixScreenY(int mixScreenY) {
        this.minScreenY = mixScreenY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Rect getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rect hitBox) {
        this.hitBox = hitBox;
    }

    public double getRadius() {
        return radius;
    }
}
