package com.example.projectstoproc.scene;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.projectstoproc.GameManager;
import com.example.projectstoproc.R;

public class GameScene extends SceneFW {

    //состояния игры
    enum GameState{
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;
    GameManager gameManager;

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
        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState = GameState.RUNNING;
        }
    }

    //методы действии
    private void drawingStateRunning() {
        gameManager.drawing(coreFW, graphicsFW);
    }
    private void updateStateRunning() {
        gameManager.update();
        if(GameManager.gameOver){
            gameState = GameState.GAMEOVER;
        }

    }

    //методы конца игры
    private void drawingStateGameOver() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("Game Over", sceneWidth/2-130, sceneHeight/2, Color.BLUE, 40, null);

    }
    private void updateStateGameOver() {

    }

    // методы паузы
    private void drawingStatePause() {

    }
    private void updateStatePause() {

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
