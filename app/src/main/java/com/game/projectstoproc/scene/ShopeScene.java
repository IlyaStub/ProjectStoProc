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
    GameManager gameManager;

    public ShopeScene(CoreFW coreFW) {
        super(coreFW);
        balance = ResultGame.balance;
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

    }

    @Override
    public void drawing() {
        drawingBackground();
        graphicsFW.drawText(coreFW.getString(R.string.gameOver_exitInMainMenu), 10, 50, Color.BLUE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.shopeBalance) + " " + balance, sceneWidth-280, 50, Color.BLUE, 40, null);
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
