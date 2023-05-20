package com.example.projectstoproc.scene;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.projectstoproc.GameManager;
import com.example.projectstoproc.R;
import com.example.projectstoproc.ResultGame;

public class MainMenuScene extends SceneFW {

    GameManager gameManager;
    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
        ResultGame.loadDistance(coreFW);
        ResultGame.loadBalance(coreFW);
        gameManager = new GameManager(sceneWidth, sceneHeight);
    }


    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2f - 59, graphicsFW.getHeightFrameBuffer()/2f-graphicsFW.getHeightFrameBuffer()/17f, 120, graphicsFW.getHeightFrameBuffer()/17f)){
            try {
                coreFW.setScene(new GameScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2 - 86, graphicsFW.getHeightFrameBuffer()/2f+35, 172, 35)){
            try {
                coreFW.setScene(new BestDistanceScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2 - 65, graphicsFW.getHeightFrameBuffer()/2f+105, 130, 36)){
            try {
                coreFW.setScene(new ShopeScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void drawing() {
        drawingBackground();
        graphicsFW.drawText(coreFW.getString(R.string.nameGameTXT), sceneWidth/2 - 210, sceneHeight/2-100, Color.BLUE, 100, null);
        graphicsFW.drawText(coreFW.getString(R.string.playGameTXT), sceneWidth/2 - 60, graphicsFW.getHeightFrameBuffer()/2, Color.BLUE, 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.resultGameTXT), sceneWidth/2 - 86, sceneHeight/2+ 80, Color.BLUE, 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.shopGameTXT), sceneWidth/2 - 65, sceneHeight/2 +160, Color.BLUE, 50, null);
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
