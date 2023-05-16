package com.example.projectstoproc;

import com.example.my_framework.ColisionFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
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

        zadergka++;
        if(zadergka>50){
            zadergka =0;
            distance+=2;//пока 2, потом появятся усилялки
            money+=1;
        }
        health = mainPlayer.getHealth();

        panel.update(distance,money, health);

        //проверяем у каждого enemy колисию с плеером
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if(ColisionFW.colisionDt(mainPlayer, generatorEnemy.enemyArrayList.get(i))){
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
            }
        }
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
        panel.drawing(graphicsFW);
    }
}
