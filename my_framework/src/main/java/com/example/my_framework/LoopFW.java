package com.example.my_framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopFW extends SurfaceView implements Runnable{

    private final float FPS = 40;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND/FPS; //обновление экрана в секунду

    private boolean running = false; // идёт игра или нет

    Thread gameThread = null; //поток игры
    CoreFW coreFW;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    //TEMP
    float updates = 0;
    float drawing = 0;
    long timer = 0;

    public LoopFW(CoreFW coreFW, Bitmap frameBuffer) {
        super(coreFW);
        this.frameBuffer = frameBuffer;
        this.coreFW = coreFW;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }
    //TEMP


    @Override
    public void run() {

        float lastTime = System.nanoTime(); // текущие время в наносекундах
        float delta = 0;
        timer = System.currentTimeMillis();

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

            if(System.currentTimeMillis()-timer>1000){
                Date date = new Date();
                System.out.println("UPDATES = " + updates +" DROWING " + drawing + " " +date.toString());
                updates=0;
                drawing=0;
                timer+=1000;
            }
        }
    }

    //запускается 60 раз в секунду
    private void updateGame(){
        updates += 1;
        coreFW.getCurrentScene().update();
    }

    //запускается 60 раз в секунду
    private void drowingGame(){
        drawing+= 1;
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
