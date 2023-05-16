package com.example.my_framework;

public class ColisionFW {

    static double object1X;
    static double object1Y;

    static double object2X;
    static double object2Y;

    static double radiusO1X;
    static double radiusO1Y;

    static double radiusO2X;
    static double radiusO2Y;

    static double dx;
    static double dy;

    static double distanceOb;

    public static boolean colisionDt(SpriteFW sprite1, SpriteFW sprite2){
        object1X = sprite1.getHitBox().centerX(); //получаем центр по x у первого спрайта
        object1Y = sprite1.getHitBox().centerY(); //получаем центр по y у первого спрайта

        object2X = sprite2.getHitBox().centerX();
        object2Y = sprite2.getHitBox().centerY();

        radiusO1X = sprite1.getRadiusX();
        radiusO1Y = sprite1.getRadiusY();
        radiusO2X = sprite2.getRadiusX();
        radiusO2Y = sprite2.getRadiusY();

        dx = object1X-object2X;
        dy = object1Y-object2Y;

        distanceOb = Math.sqrt(Math.pow(dx,2)+Math.pow(dy, 2));// восьмой класс

        if(distanceOb<radiusO1X+radiusO2X && distanceOb<radiusO1Y+radiusO2Y){
            return true;
        }else return false;
    }
}
