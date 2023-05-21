package com.example.projectstoproc;

import com.example.my_framework.ColisionFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.UtilResoursHelper;
import com.example.projectstoproc.generodtor.GeneratorCoin;
import com.example.projectstoproc.generodtor.GeneratorEnemy;
import com.example.projectstoproc.sprites.MainPlayer;

public class GameManager {
    private int maxSreenX;
    private int maxSreenY;
    private int minSreenY;
    private int minSreenX;

    int zadergka = 0;

    private int distance;
    private int money;
    private int health;

    MainPlayer mainPlayer;
    BackgroundClass backgroundClass;
    public static boolean gameOver;

    GeneratorEnemy generatorEnemy;
    GeneratorCoin generatorCoin;
    Panel panel;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight){
        panel = new Panel(coreFW);
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        minSreenX = 0;
        minSreenY = panel.getHEIGHT_PANEL();
        backgroundClass = new BackgroundClass(sceneWidth, sceneHeight);
        mainPlayer = new MainPlayer(coreFW, maxSreenX, maxSreenY, minSreenY);
        generatorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, minSreenY);
        generatorCoin = new GeneratorCoin(sceneWidth, sceneHeight, minSreenY);
        gameOver = false;

    }

    public GameManager(int sceneWidth, int sceneHeight){
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        minSreenX = 0;
        minSreenY = 0;
        backgroundClass = new BackgroundClass(sceneWidth, sceneHeight);
    }

    public void update(){
        backgroundClass.update();
        mainPlayer.update();
        generatorEnemy.update();
        generatorCoin.update();

        zadergka++;
        if(zadergka>50 && health>0){
            zadergka =0;
            distance+=2;//пока 2, потом появятся усилялки
        }
        health = mainPlayer.getHealth();
        money = mainPlayer.getBalance();

        panel.update(distance,money, health);


        if(health>0){
            //проверяем у каждого enemy колизию с плеером
            for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
                if(ColisionFW.colisionDt(mainPlayer, generatorEnemy.enemyArrayList.get(i))){
                    UtilResoursHelper.soundKrick.playSound(1);
                    mainPlayer.hitEnemy();
                    generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
                }
            }
            //проверяем у каждого coin колизию с плеером
            for (int i = 0; i < generatorCoin.coinArrayList.size(); i++) {
                if(ColisionFW.colisionDt(mainPlayer, generatorCoin.coinArrayList.get(i))){
                    mainPlayer.hitCoin();
                    UtilResoursHelper.soundMoney.playSound(1);
                    generatorCoin.hitPlayer(generatorCoin.coinArrayList.get(i));
                }
            }
        }
    }

    public int getDistance(){
        return distance;
    }
    public int getMoney(){
        return money;
    }

    public int getHealth(){
        return health;
    }

    public void upBackground(){
        backgroundClass.update();
    }

    public void drawBackGround(GraphicsFW graphicsFW){
        backgroundClass.drawing(graphicsFW);
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        backgroundClass.drawing(graphicsFW);
        mainPlayer.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        generatorCoin.drawing(graphicsFW);
        panel.drawing(graphicsFW);
    }
}
