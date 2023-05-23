package com.game.my_framework;

public class ColisionFW {

    static double object1X;
    static double object1Y;

    static double object2X;
    static double object2Y;

    static double radiusO1;
    static double radiusO2;

    static double dx;
    static double dy;

    static double distanceOb;

    public static boolean colisionDt(SpriteFW sprite1, SpriteFW sprite2){

        object1X = sprite1.getHitBox().centerX(); //получаем центр по x у первого спрайта
        object1Y = sprite1.getHitBox().centerY(); //получаем центр по y у первого спрайта

        object2X = sprite2.getHitBox().centerX();
        object2Y = sprite2.getHitBox().centerY();

        radiusO1 = sprite1.getRadius();
        radiusO2 = sprite2.getRadius();

        dx = object1X-object2X;
        dy = object1Y-object2Y;

        distanceOb = Math.sqrt(Math.pow(dx,2)+Math.pow(dy, 2));// восьмой класс

        if(distanceOb<radiusO1+radiusO2){
            return true;
        }else return false;
    }
}
