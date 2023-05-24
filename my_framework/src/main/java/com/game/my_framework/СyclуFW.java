package com.game.my_framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class СyclуFW extends SurfaceView implements Runnable{

    private final float FPS = 35;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND/FPS; //обновление экрана в секунду

    private boolean running = false; // идёт игра или нет

    Thread gameThread = null; //поток игры
    CoreFW coreFW;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public СyclуFW(CoreFW coreFW, Bitmap frameBuffer) {
        super(coreFW);
        this.frameBuffer = frameBuffer;
        this.coreFW = coreFW;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    @Override
    public void run() {

        float lastTime = System.nanoTime(); // текущие время в наносекундах
        float delta = 0;

        while (running){
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime-lastTime;//сколько времени прошло за выполнение Loop
            lastTime = nowTime;
            delta += elapsedTime/UPDATE_TIME;
            if(delta>1){
                updateGame();
                drowingGame();
                delta--;
            }
        }
    }

    //запускается FPS раз в секунду
    private void updateGame(){
        coreFW.getCurrentScene().update();
    }

    //запускается FPS раз в секунду
    private void drowingGame(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            coreFW.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void startGame(){ // запуск игры
        if(running){
            return;
        }else{
            running = true;
            gameThread = new Thread(this); // иницилизация потока (метода run)
            gameThread.start();
        }
    }

    public void stopGame(){// пауза
        if(!running){
            return;
        }else{
            running = false;
            try {
                gameThread.join(); // Этот метод приостановит выполнение текущего потока до тех пор, пока другой поток не закончит свое выполнение.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
