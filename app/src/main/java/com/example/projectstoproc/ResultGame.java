package com.example.projectstoproc;

import android.content.SharedPreferences;

import com.example.my_framework.CoreFW;

public class ResultGame {

    public static int bestDistance;
    public static int balance;


    public static void loadDistance(CoreFW coreFW){
        bestDistance = coreFW.getSharedPreferences().getInt("RESULT", bestDistance);
    }

    public static void loadBalance(CoreFW coreFW){
        balance = coreFW.getSharedPreferences().getInt("BALANCE", balance);
    }

    //сохраняем дистанцию
    public static void saveDistance(CoreFW coreFW){
        SharedPreferences.Editor editor = coreFW.getSharedPreferences().edit();
        editor.clear();
        editor.putInt("RESULT", bestDistance);
        editor.putInt("BALANCE", balance);
        editor.commit();
    }
    public static void addNewBestDistance(int distanceNow, CoreFW coreFW){
        if(bestDistance<distanceNow){
            bestDistance = distanceNow;
        }
        saveDistance(coreFW);
    }

    public static void popolnityBalance(int balanceNow, CoreFW coreFW){
        balance+=balanceNow;
        saveDistance(coreFW);
    }

    public static void snyatyBalance(int price, CoreFW coreFW){
        balance-=price;
        saveDistance(coreFW);
    }
}
