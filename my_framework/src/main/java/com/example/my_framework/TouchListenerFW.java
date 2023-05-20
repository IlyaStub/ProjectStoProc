package com.example.my_framework;

import android.view.MotionEvent;
import android.view.View;

//класс обработки нажатий
public class TouchListenerFW implements View.OnTouchListener {

    float touchX;
    float touchY;

    boolean isTouchDown;
    boolean isTouchUp;

    float sceneWidth;
    float sceneHight;

    SpriteFW spriteFW;


    public TouchListenerFW(View view, float sceneWidth, float sceneHight){
        view.setOnTouchListener(this);
        this.sceneHight = sceneHight;
        this.sceneWidth = sceneWidth;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        synchronized (this){
            isTouchDown = false;
            isTouchUp = false;
            switch (event.getAction()){//мы получили событие и проверяем, чем оно является
                case MotionEvent.ACTION_DOWN://пользаватель нажал
                    //записываем кординаты нажатия
                    touchX = event.getX() * sceneWidth;
                    touchY = event.getY() * sceneHight;
                    isTouchDown = true;
                    isTouchUp = false;
                    break;
                case MotionEvent.ACTION_UP://пользаватель отжал
                    //записываем кординаты отжатия
                    touchX = event.getX()*sceneWidth;
                    touchY = event.getY()*sceneHight;
                    isTouchDown = false;
                    isTouchUp = true;
                    break;
            }
        }
        return true;
    }
    //проверка, куда нажал пользователь
    public boolean getTouchUp(float x, float y, float touchWidth, float touchHeight){
        if(isTouchUp){
            if(touchX>=x && touchX<=x+touchWidth && touchY<y && touchY>y-(touchHeight)){
                isTouchUp = false;
                return true;
            }
        }
        return false;
    }

    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight){
        if(isTouchDown){
            if(touchX>=x && touchX<=x+touchWidth && touchY<=y && touchY>=y-(touchHeight)){
                isTouchDown = false;
                return true;
            }
        }
        return false;
    }
}
