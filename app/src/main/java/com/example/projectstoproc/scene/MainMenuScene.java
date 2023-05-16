package com.example.projectstoproc.scene;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.projectstoproc.GameManager;
import com.example.projectstoproc.R;

public class MainMenuScene extends SceneFW {

    GameManager gameManager;
    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
        gameManager = new GameManager(sceneWidth, sceneHeight);
    }


    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(sceneWidth/2f - 59, sceneHeight/2f-10, 120, 36)){
            try {
                coreFW.setScene(new GameScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        drawingBackground();
        graphicsFW.drawLine(sceneWidth/2, 0, sceneWidth/2, sceneHeight, Color.RED);
        graphicsFW.drawLine(sceneWidth/2-60, 0, sceneWidth/2-60, sceneHeight, Color.RED);
        graphicsFW.drawLine(sceneWidth/2+60, 0, sceneWidth/2+60, sceneHeight, Color.RED);
        graphicsFW.drawLine(0, sceneHeight/2, sceneWidth, sceneHeight/2, Color.RED);
        graphicsFW.drawLine(0, sceneHeight/2-36, sceneWidth, sceneHeight/2-36, Color.RED);
        graphicsFW.drawLine(0, sceneHeight/2+36, sceneWidth, sceneHeight/2+36, Color.RED);
        graphicsFW.drawText(coreFW.getString(R.string.nameGameTXT), sceneWidth/2 - 185, sceneHeight/2-100, Color.BLUE, 100, null);
        graphicsFW.drawText(coreFW.getString(R.string.playGameTXT), sceneWidth/2 - 60, sceneHeight/2, Color.BLUE, 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.resultGameTXT), sceneWidth/2 - 86, sceneHeight/2+ 80, Color.BLUE, 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.sattingsGameTXT), sceneWidth/2 - 120, sceneHeight/2 +160, Color.BLUE, 50, null);
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
