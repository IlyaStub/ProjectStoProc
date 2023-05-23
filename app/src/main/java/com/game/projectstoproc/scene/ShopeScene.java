package com.game.projectstoproc.scene;

import android.graphics.Color;

import com.game.my_framework.CoreFW;
import com.game.my_framework.SceneFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.GameManager;
import com.game.projectstoproc.R;
import com.game.projectstoproc.ResultGame;

public class ShopeScene extends SceneFW {

    private int balance;
    private boolean buyOrNotSkin;
    private boolean hasOrNot;
    GameManager gameManager;

    public ShopeScene(CoreFW coreFW) {
        super(coreFW);
        balance = ResultGame.balance;
        buyOrNotSkin = ResultGame.buySkinOrNot;
        hasOrNot = ResultGame.hasSkin;
        gameManager = new GameManager(sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(10, 43, 240, 44)){
            UtilResoursHelper.soundClick.playSound(1);
            try {
                coreFW.setScene(new MainMenuScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }


        if(!buyOrNotSkin){
            if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2-120, sceneHeight/2-32, 300, 25)){
                UtilResoursHelper.soundClick.playSound(1);
                if(balance<2){

                }else{
                    ResultGame.snyatyBalance(2, coreFW);
                    buyOrNotSkin = true;
                    balance = ResultGame.balance;
                }
            }
        }else {
            if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2-130, sceneHeight/2-32, 300, 25)){
                UtilResoursHelper.soundClick.playSound(1);
                ResultGame.changeSkin(hasOrNot, coreFW);
                hasOrNot = ResultGame.hasSkin;
            }

        }

    }

    @Override
    public void drawing() {
        drawingBackground();
        graphicsFW.drawText(coreFW.getString(R.string.gameOver_exitInMainMenu), 10, 50, Color.BLUE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.shopeBalance) + " " + balance, sceneWidth-280, 50, Color.BLUE, 40, null);
        if(!buyOrNotSkin){
            graphicsFW.drawText("Buy rocket skin for 50", sceneWidth/2-120, sceneHeight/2, Color.BLUE, 30, null);
        }else{
            if(!hasOrNot){
                graphicsFW.drawText("Install a skin on a rocket", sceneWidth/2-130, sceneHeight/2, Color.BLUE, 30, null);
            }else graphicsFW.drawText("Install a usually rocket", sceneWidth/2-130, sceneHeight/2, Color.BLUE, 30, null);

        }
    }

    private void drawingBackground() {
        gameManager.drawBackGround(graphicsFW);
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
