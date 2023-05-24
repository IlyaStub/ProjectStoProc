package com.game.projectstoproc.scene;

import android.graphics.Color;

import com.game.my_framework.CoreFW;
import com.game.my_framework.SceneFW;
import com.game.my_framework.UtilResoursHelper;
import com.game.projectstoproc.GameManager;
import com.game.projectstoproc.R;
import com.game.projectstoproc.ResultGame;

public class GameScene extends SceneFW {

    //состояния игры
    enum GameState{
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;
    GameManager gameManager;

    boolean flag = true;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);

    }

    @Override
    public void update() {
        //проверем состояние
        if(gameState == GameState.READY){
            updateStateReady();
        }
        if(gameState == GameState.RUNNING){
            updateStateRunning();
        }
        if(gameState == GameState.PAUSE){
            updateStatePause();
        }
        if(gameState == GameState.GAMEOVER){
            updateStateGameOver();
        }

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        //проверем состояние
        if(gameState == GameState.READY){
            drawingStateReady();
        }
        if(gameState == GameState.RUNNING){
            drawingStateRunning();
        }
        if(gameState == GameState.PAUSE){
            drawingStatePause();
        }
        if(gameState == GameState.GAMEOVER){
            drawingStateGameOver();
        }
    }



    //методы готовности
    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        gameManager.drawing(coreFW, graphicsFW);
        graphicsFW.drawText(coreFW.getString(R.string.stateReadyTXT), sceneWidth/2-130, sceneHeight/2, Color.BLUE, 40, null);

    }
    private void updateStateReady() {
        flag = true;
        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState = GameState.RUNNING;
        }
    }

    //методы действии
    private void drawingStateRunning() {
        gameManager.drawing(coreFW, graphicsFW);
    }
    private void updateStateRunning() {
        flag = true;

        if(coreFW.getTouchListenerFW().getTouchUp(0, 45, sceneWidth, 45)){
            UtilResoursHelper.soundClick.playSound(1);
            gameState = GameState.PAUSE;
        }

        gameManager.update();

        if(GameManager.gameOver){
            UtilResoursHelper.gameMusic.stopMusic();
            gameState = GameState.GAMEOVER;
        }else UtilResoursHelper.gameMusic.playMusic(true, 1);


    }

    //методы конца игры
    private void drawingStateGameOver() {
        gameManager.drawBackGround(graphicsFW);
        graphicsFW.drawText(coreFW.getString(R.string.gameOver), 250, 290, Color.BLUE, 70, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameOver_distance) + gameManager.getDistance(), 250, 360, Color.BLUE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameOver_restartGame), 250, 420, Color.BLUE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameOver_exitInMainMenu), 250, 480, Color.BLUE, 40, null);
    }
    private void updateStateGameOver() {

        ResultGame.addNewBestDistance(gameManager.getDistance(), coreFW);

        if(flag){
            ResultGame.popolnityBalance(gameManager.getMoney(), coreFW);
            flag = false;
        }

        if(coreFW.getTouchListenerFW().getTouchUp(250, 372, 185, 32)){
            UtilResoursHelper.soundClick.playSound(1);
            try {
                coreFW.setScene(new GameScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if(coreFW.getTouchListenerFW().getTouchUp(250, 422, 242, 30)){
            UtilResoursHelper.soundClick.playSound(1);
            try {
                coreFW.setScene(new MainMenuScene(coreFW));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // методы паузы
    private void drawingStatePause() {
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.statePauseTXT), sceneWidth/2-60,sceneHeight/2-40, Color.GREEN,50,null);
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.panel_distance) + gameManager.getDistance(), sceneWidth/2-110,sceneHeight/2+30, Color.GREEN,50,null);
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.panel_money) + gameManager.getMoney(), sceneWidth/2-80,sceneHeight/2+90, Color.GREEN,50,null);
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.panel_health) + gameManager.getHealth(), sceneWidth/2-80,sceneHeight/2+150, Color.GREEN,50,null);
    }
    private void updateStatePause() {
        UtilResoursHelper.gameMusic.stopMusic();
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    @Override
    public void pause() {
        UtilResoursHelper.gameMusic.stopMusic();

    }

    @Override
    public void resume() {
        UtilResoursHelper.gameMusic.playMusic(true, 2);
    }

    @Override
    public void dispose() {
        UtilResoursHelper.gameMusic.stopMusic();
    }
}
