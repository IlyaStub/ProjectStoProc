package com.game.projectstoproc.generodtor;

import com.game.my_framework.GraphicsFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.sprites.Enemy;

import java.util.ArrayList;

public class GeneratorEnemy {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    public ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemy(int sceneWidth, int sceneHeight, int minScreenY){
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight - UtilResoursHelper.spriteEnemyRocket.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;

        enemyArrayList = new ArrayList<>();
    }

    public void update(){
        if(enemyArrayList.size() < 4){
            addEnemy(4);
        }

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update();
        }
    }

    private void addEnemy(int countEnemy) {
        for (int i = 0; i < countEnemy; i++) {
            enemyArrayList.add(new Enemy(maxScreenX, maxScreenY, minScreenY));
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }


    public void hitPlayer(Enemy enemy) {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.remove(enemy);
        }
    }
}
