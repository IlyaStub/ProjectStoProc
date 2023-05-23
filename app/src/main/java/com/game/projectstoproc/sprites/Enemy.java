package com.game.projectstoproc.sprites;

import android.graphics.Rect;

import com.game.my_framework.GraphicsFW;
import com.game.my_framework.RandomchikFW;
import com.game.my_framework.SpriteFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.Animation;

public class Enemy extends SpriteFW {

    Animation animationEnemyRocet;

    public Enemy(int maxScreenX, int maxScreenY, int minScreenY, int enemyType){

        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResoursHelper.spriteEnemyRocket.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;

        radius = UtilResoursHelper.spriteEnemyRocket.get(0).getWidth()/4;

        x = maxScreenX;
        y = RandomchikFW.getRandom(minScreenY, maxScreenY- 50);

        switch (enemyType){
            case 1:
                speed = RandomchikFW.getRandom(5, 11);
                animationEnemyRocet = new Animation(1, UtilResoursHelper.spriteEnemyRocket.get(0),
                        UtilResoursHelper.spriteEnemyRocket.get(1),
                        UtilResoursHelper.spriteEnemyRocket.get(2),
                        UtilResoursHelper.spriteEnemyRocket.get(3));
                break;
            case 2:
                speed = 20;
                break;
        }

    }
    public void update(){
        x-=speed;

        if(x<minScreenX){
            x=maxScreenX;
            y = RandomchikFW.getRandom(minScreenY, maxScreenY-50);
            speed = RandomchikFW.getRandom(4, 10);
        }
        animationEnemyRocet.runAnimation();

        hitBox = new Rect(x, y, UtilResoursHelper.spriteEnemyRocket.get(0).getWidth(), UtilResoursHelper.spriteEnemyRocket.get(0).getHeight());
    }


    public void drawing(GraphicsFW graphicsFW){
        animationEnemyRocet.driwingAnimation(graphicsFW, x, y);
    }

}
