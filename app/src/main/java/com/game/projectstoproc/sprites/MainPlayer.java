package com.game.projectstoproc.sprites;

import android.graphics.Rect;

import com.game.my_framework.CoreFW;
import com.game.my_framework.GraphicsFW;
import com.game.my_framework.SpriteFW;
import com.game.my_framework.TimerFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.GameManager;
import com.game.projectstoproc.Animation;

public class MainPlayer extends SpriteFW {

    Animation animationDown;
    Animation animationTouch;

    Animation animationDeath;
    CoreFW coreFW;
    TimerFW timerTextureDamage;
    TimerFW timerGameOver;

    final int USCARENIE_SVOBODNOGO_PADENIYA = -7;
    final int MAX_SPEED = 20;
    final int MIN_SPEED = 2;

    private boolean death;

    private int health;
    private int balance;
    public boolean hitBool;//переменная для того, чтобы знать, какая будет анимация
    boolean touchOrNot;//переменная для того, чтобы знать, какая будет анимация


    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        x = minScreenX+60;
        y = maxScreenY/2;
        speed = 2;
        hitBool = false;
        touchOrNot = false;
        death = false;
        health = 3;
        balance = 0;

        radius = UtilResoursHelper.spritePlayerIfTouch.get(0).getWidth()/10;

        timerTextureDamage = new TimerFW();
        timerGameOver = new TimerFW();

        this.coreFW = coreFW;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResoursHelper.spritePlayer.getHeight();//получаем высоту плеера и вычитаем ее из высоты экрана, чтобы герой не вылетал за карту
        this.minScreenY = minScreenY;
        coreFW.getGraphicsFW().drawTexture(UtilResoursHelper.spritePlayer, x, y);

        animationDown = new Animation(1, UtilResoursHelper.spritePlayerDown.get(0),
                UtilResoursHelper.spritePlayerDown.get(1),
                UtilResoursHelper.spritePlayerDown.get(2),
                UtilResoursHelper.spritePlayerDown.get(3));

        animationTouch = new Animation(1, UtilResoursHelper.spritePlayerIfTouch.get(0),
                UtilResoursHelper.spritePlayerIfTouch.get(1),
                UtilResoursHelper.spritePlayerIfTouch.get(2),
                UtilResoursHelper.spritePlayerIfTouch.get(3));

        animationDeath = new Animation(1, UtilResoursHelper.spritePlayerDeath.get(0),
                UtilResoursHelper.spritePlayerDeath.get(1),
                UtilResoursHelper.spritePlayerDeath.get(2),
                UtilResoursHelper.spritePlayerDeath.get(3));

    }

    public void update(){

        if(!death){
            if(coreFW.getTouchListenerFW().getTouchDown(0, maxScreenY, maxScreenX, maxScreenY-45)){
                startTouching();
            }
            if(coreFW.getTouchListenerFW().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)){
                endTouching();
            }
            if(touchOrNot){
                speed+=0.5;
            }else{
                speed-=2;
            }
        }else{
            speed-=2;
        }


        if(speed > MAX_SPEED){
            speed=MAX_SPEED;
        }
        if(speed<MIN_SPEED){
            speed=MIN_SPEED;
        }

        y-=speed+USCARENIE_SVOBODNOGO_PADENIYA;

        if(y<minScreenY){
            y=minScreenY;
        }
        if(y>maxScreenY){
            y=maxScreenY;
        }

        if (touchOrNot){
            animationTouch.runAnimation();
        }else{
            if(y==maxScreenY && !hitBool){
                animationDown.runAnimation();
            }
        }
        if(death){
            animationDeath.runAnimation();
        }


        hitBox = new Rect(x, y, UtilResoursHelper.spritePlayer.getWidth(), UtilResoursHelper.spritePlayer.getHeight());

    }

    private void endTouching() {
        touchOrNot = false;
    }

    private void startTouching() {
        touchOrNot = true;
    }

    public void drawing(GraphicsFW graphicsFW){
        if(!death){
            if(!hitBool){
                if(touchOrNot){
                    animationTouch.driwingAnimation(graphicsFW, x, y);
                }else{
                    if(y==maxScreenY){
                        animationDown.driwingAnimation(graphicsFW, x, y);
                    } else{
                        graphicsFW.drawTexture(UtilResoursHelper.spritePlayer, x, y);
                    }
                }
            }else{
                if(touchOrNot){
                    graphicsFW.drawTexture(UtilResoursHelper.spritePlayerDamageIfTouch, x, y);
                }else{
                    if(y==maxScreenY){
                        graphicsFW.drawTexture(UtilResoursHelper.spritePlayerDamageDown, x, y);
                    } else{
                        graphicsFW.drawTexture(UtilResoursHelper.spritePlayerDamage, x, y);
                    }
                }
                if(timerTextureDamage.timerDelay(0.3)){
                    hitBool = false;
                }else hitBool=true;
            }
        }else {
            if(y==maxScreenY){
                graphicsFW.drawTexture(UtilResoursHelper.spritePlayerDeathDown, x, y);
                if(timerGameOver.timerDelay(1)){
                    GameManager.gameOver = true;
                }
            }else{
                animationDeath.driwingAnimation(graphicsFW, x, y);
            }
        }

    }

    public int getHealth(){
        return health;
    }

    public int getBalance(){
        return balance;
    }


    public void hitEnemy() {
        health--;
        if(health==0){
            death=true;
            timerGameOver.startTime();
        }
        hitBool = true;
        timerTextureDamage.startTime();
    }

    public void hitCoin() {
        balance++;
    }
}

