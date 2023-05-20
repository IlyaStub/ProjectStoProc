package com.example.projectstoproc.sprites;

import android.graphics.Rect;

import com.example.my_framework.GraphicsFW;
import com.example.my_framework.RandomchikFW;
import com.example.my_framework.SpriteFW;
import com.example.my_framework.UtilResoursHelper;
import com.example.projectstoproc.Animation;

public class Coin extends SpriteFW {

    Animation animationCoin;

    public Coin(int maxScreenX, int maxScreenY, int minScreenY){
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResoursHelper.spriteCoin.get(0).getHeight();
        this.minScreenX = 0;
        this.minScreenY = minScreenY;

        radius = UtilResoursHelper.spriteEnemyRocket.get(0).getWidth()/4;

        x = maxScreenX;
        y = RandomchikFW.getRandom(minScreenY, maxScreenY- 60);

        speed = RandomchikFW.getRandom(3, 8);
        animationCoin = new Animation(3, UtilResoursHelper.spriteCoin.get(0),
                UtilResoursHelper.spriteCoin.get(1),
                UtilResoursHelper.spriteCoin.get(2),
                UtilResoursHelper.spriteCoin.get(1));
    }

    public void update(){
        x-=speed;

        if(x<minScreenX){
            x=maxScreenX;
            y = RandomchikFW.getRandom(minScreenY, maxScreenY-60);
            speed = RandomchikFW.getRandom(3, 8);
        }
        animationCoin.runAnimation();

        hitBox = new Rect(x, y, UtilResoursHelper.spriteCoin.get(0).getWidth(), UtilResoursHelper.spriteCoin.get(0).getHeight());
    }


    public void drawing(GraphicsFW graphicsFW){
        animationCoin.driwingAnimation(graphicsFW, x, y);
    }
}
