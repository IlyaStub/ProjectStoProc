package com.game.projectstoproc.sprites;

import android.graphics.Rect;

import com.game.my_framework.GraphicsFW;
import com.game.my_framework.RandomchikFW;
import com.game.my_framework.SpriteFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.Animation;
import com.game.projectstoproc.ResultGame;
import com.game.projectstoproc.scene.ShopeScene;

public class Enemy extends SpriteFW {

    Animation animationEnemyRocet;

    Animation animationEnemyRocetScin;

    public boolean elementarySkin;

    public Enemy(int maxScreenX, int maxScreenY, int minScreenY){

        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResoursHelper.spriteEnemyRocket.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;

        elementarySkin = !ResultGame.hasSkin;

        radius = UtilResoursHelper.spriteEnemyRocket.get(0).getWidth()/4;

        x = maxScreenX;
        y = RandomchikFW.getRandom(minScreenY, maxScreenY- 50);

        speed = RandomchikFW.getRandom(5, 11);
        animationEnemyRocet = new Animation(1, UtilResoursHelper.spriteEnemyRocket.get(0),
                UtilResoursHelper.spriteEnemyRocket.get(1),
                UtilResoursHelper.spriteEnemyRocket.get(2),
                UtilResoursHelper.spriteEnemyRocket.get(3));

        animationEnemyRocetScin = new Animation(1, UtilResoursHelper.spriteEnemyRocketSkinchik.get(0),
                UtilResoursHelper.spriteEnemyRocketSkinchik.get(1),
                UtilResoursHelper.spriteEnemyRocketSkinchik.get(2),
                UtilResoursHelper.spriteEnemyRocketSkinchik.get(3));

    }
    public void update(){
        x-=speed;

        if(x<minScreenX){
            x=maxScreenX;
            y = RandomchikFW.getRandom(minScreenY, maxScreenY-50);
            speed = RandomchikFW.getRandom(4, 10);
        }
        if(elementarySkin){
            animationEnemyRocet.runAnimation();
        }else animationEnemyRocetScin.runAnimation();


        hitBox = new Rect(x, y, UtilResoursHelper.spriteEnemyRocket.get(0).getWidth(), UtilResoursHelper.spriteEnemyRocket.get(0).getHeight());
    }


    public void drawing(GraphicsFW graphicsFW){
        if(elementarySkin){
            animationEnemyRocet.driwingAnimation(graphicsFW, x, y);
        }else animationEnemyRocetScin.driwingAnimation(graphicsFW, x, y);
    }

}
