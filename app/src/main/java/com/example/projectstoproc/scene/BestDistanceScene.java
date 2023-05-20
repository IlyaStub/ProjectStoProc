package com.example.projectstoproc.scene;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.projectstoproc.GameManager;
import com.example.projectstoproc.R;
import com.example.projectstoproc.ResultGame;

public class BestDistanceScene extends SceneFW {


    GameManager gameManager;

    int dist;

    public BestDistanceScene(CoreFW coreFW) {
        super(coreFW);
        dist = ResultGame.bestDistance;
        gameManager = new GameManager(sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            try {
                coreFW.setScene(new MainMenuScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void drawing() {
        drawingBackground();
        graphicsFW.drawText(coreFW.getString(R.string.theBestResult) + " " + dist, sceneWidth/2-160, sceneHeight/2, Color.BLUE, 40, null);
    }
    private void drawingBackground() {
        gameManager.drawBackGround(graphicsFW);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {

    }
}
