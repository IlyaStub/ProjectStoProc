package com.example.projectstoproc.louders;

import android.graphics.Bitmap;

import com.example.my_framework.GraphicsFW;

public class Animation {

    double speedAnimation;//чем больше число, тем медленнее будет анимация
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;
    Bitmap sprite1;
    Bitmap sprite2;
    Bitmap sprite3;
    Bitmap sprite4;

    public Animation(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4) {
        sprite = sprite1;
        this.speedAnimation = speedAnimation;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        this.sprite4 = sprite4;
        frames = 4;
    }

    public Animation(int speedAnimation, Bitmap sprite1) {
        sprite = sprite1;
        this.speedAnimation = speedAnimation;
        this.sprite1 = sprite1;
        frames = 1;
    }

    public void runAnimation(){
        if(frames ==1){
            sprite=sprite1;
        }else{
            delayIndex++;
            if(delayIndex>speedAnimation){//меняем текстуру когда пройдёт определённое количестов итераций
                delayIndex=0;
                switch (countFrames){
                    case 0:
                        sprite = sprite1;
                        break;
                    case 1:
                        sprite = sprite2;
                        break;
                    case 2:
                        sprite = sprite3;
                        break;
                    case 3:
                        sprite = sprite4;
                        break;
                }
                countFrames++;
                if(countFrames>frames){
                    countFrames = 0;
                }
            }
        }
    }

    public void driwingAnimation(GraphicsFW graphicsFW, int x, int y){
        graphicsFW.drawTexture(sprite, x, y);
    }
}
