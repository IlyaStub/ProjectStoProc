package com.game.my_framework;

public class RandomchikFW {
    public static int getRandom(int minNum, int maxNum) {
        return (int) ((Math.random()*--maxNum)+minNum);
    }
}
