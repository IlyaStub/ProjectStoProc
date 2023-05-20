package com.example.projectstoproc.generodtor;

import com.example.my_framework.GraphicsFW;
import com.example.my_framework.UtilResoursHelper;
import com.example.projectstoproc.sprites.Coin;
import com.example.projectstoproc.sprites.Enemy;

import java.util.ArrayList;

public class GeneratorCoin {

    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    public ArrayList<Coin> coinArrayList;


    public GeneratorCoin(int sceneWidth, int sceneHeight, int minScreenY){
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight - UtilResoursHelper.spriteCoin.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;

        coinArrayList = new ArrayList<>();
    }

    public void update(){
        if(coinArrayList.size() < 4){
            addCoin(4);
        }

        for (int i = 0; i < coinArrayList.size(); i++) {
            coinArrayList.get(i).update();
        }
    }

    private void addCoin(int countCoin) {
        for (int i = 0; i < countCoin; i++) {
            coinArrayList.add(new Coin(maxScreenX, maxScreenY, minScreenY));
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < coinArrayList.size(); i++) {
            coinArrayList.get(i).drawing(graphicsFW);
        }
    }


    public void hitPlayer(Coin coin) {
        for (int i = 0; i < coinArrayList.size(); i++) {
            coinArrayList.remove(coin);
        }
    }
}
