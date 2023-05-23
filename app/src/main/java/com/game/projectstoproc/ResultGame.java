package com.game.projectstoproc;

import android.content.SharedPreferences;

import com.game.my_framework.CoreFW;

public class ResultGame {

    public static int bestDistance;
    public static int balance;

    public static boolean hasSkin;
    public static boolean buySkinOrNot;



    public static void loadDistance(CoreFW coreFW){
        bestDistance = coreFW.getSharedPreferences().getInt("RESULT", bestDistance);
    }

    public static void loadBalance(CoreFW coreFW){
        balance = coreFW.getSharedPreferences().getInt("BALANCE", balance);
    }

    public static void loadSkin(CoreFW coreFW){
        hasSkin = coreFW.getSharedPreferences().getBoolean("SKIN", hasSkin);
    }

    public static void loadSkinBuy(CoreFW coreFW){
        buySkinOrNot = coreFW.getSharedPreferences().getBoolean("SKINBUY", buySkinOrNot);
    }



    //сохраняем дистанцию
    public static void saveAll(CoreFW coreFW){
        SharedPreferences.Editor editor = coreFW.getSharedPreferences().edit();
        editor.clear();
        editor.putInt("RESULT", bestDistance);
        editor.putInt("BALANCE", balance);
        editor.putBoolean("SKIN", hasSkin);
        editor.putBoolean("SKINBUY", buySkinOrNot);
        editor.commit();
    }
    public static void addNewBestDistance(int distanceNow, CoreFW coreFW){
        if(bestDistance<distanceNow){
            bestDistance = distanceNow;
        }
        saveAll(coreFW);
    }

    public static void popolnityBalance(int balanceNow, CoreFW coreFW){
        balance+=balanceNow;
        saveAll(coreFW);
    }

    public static void changeSkin(boolean hasSkinNow, CoreFW coreFW){
        hasSkin = !hasSkinNow;
        saveAll(coreFW);
    }

    public static void snyatyBalance(int price, CoreFW coreFW){
        balance-=price;
        buySkinOrNot = true;
        saveAll(coreFW);
    }
}
