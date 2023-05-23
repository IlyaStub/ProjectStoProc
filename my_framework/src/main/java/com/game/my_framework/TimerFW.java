package com.game.my_framework;

public class TimerFW {
    double startTime;
    double nowTime;
    double elapsedTime;
    final double SECOND = 1000000000;

    public void startTime(){
        startTime = System.nanoTime()/SECOND;
    }

    public boolean timerDelay(double second){
        nowTime = System.nanoTime()/SECOND;
        elapsedTime = nowTime - startTime;

        if(elapsedTime>second){
            return true;
        }
        return false;
    }
}
