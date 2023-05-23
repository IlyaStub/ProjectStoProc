package com.game.projectstoproc;

import com.game.my_framework.GraphicsFW;
import com.game.my_framework.SpriteFW;
import com.game.my_framework.UtilResoursHelper;

public class BackgroundClass extends SpriteFW {

    Animation animBackground;

    public BackgroundClass(int sceneWidth, int sceneHight) {
        x = 0;
        y = 0;
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHight;

        animBackground = new Animation(100, UtilResoursHelper.textureBackground.get(0));
    }

    public void update(){
        animBackground.runAnimation();
    }

    public void drawing(GraphicsFW graphicsFW){
        animBackground.driwingAnimation(graphicsFW, x, y);
    }
}
