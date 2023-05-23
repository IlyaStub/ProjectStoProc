package com.game.my_framework;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreFW extends AppCompatActivity {

    private final float FRAME_BUFFER_WIDTH = 800;
    private final float FRAME_BUFFER_HIGHT = 600;

    private СyclуFW loopFW;
    private GraphicsFW graphicsFW;
    private TouchListenerFW touchListenerFW;

    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneFW sceneFW;
    private float sceneWidth;
    private float sceneHeight;

    private AudioFW audioFW;

    private boolean stateOnPause;
    private boolean stateOnResume;

    private SharedPreferences sharedPreferences;//сохраниние и считывания

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private final String RESULT = "result";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//нельзя переходить в спящи режим

        sharedPreferences = getSharedPreferences(RESULT, MODE_PRIVATE);//создает фаил в папке, к которой доступ может получить только приложение

        audioFW = new AudioFW(this);

        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int)FRAME_BUFFER_WIDTH,(int)FRAME_BUFFER_HIGHT, Bitmap.Config.ARGB_8888);// присваем картинку фону
        sceneWidth = FRAME_BUFFER_WIDTH/sizeDisplay.x; // получаем ширину сцены
        sceneHeight = FRAME_BUFFER_HIGHT/sizeDisplay.y; // получаем высоту сцены

        loopFW = new СyclуFW(this, frameBuffer);
        graphicsFW = new GraphicsFW(getAssets(), frameBuffer);
        touchListenerFW = new TouchListenerFW(loopFW, sceneWidth, sceneHeight);

        sceneFW = getStartScene();
        stateOnPause = false;
        stateOnResume = false;

        setContentView(loopFW);
    }

    public CoreFW(){

    }

    public AudioFW getAudioFW() {
        return audioFW;
    }

    public void onResume(){
        super.onResume();
        sceneFW.resume();
        loopFW.startGame();
    }

    public void onPause(){
        super.onPause();
        sceneFW.pause();
        loopFW.stopGame();
        stateOnPause=true;
        //если закончена, то удаляем сцену паузы
        if(isFinishing()){
            sceneFW.dispose();
        }
    }

    public GraphicsFW getGraphicsFW(){
        return graphicsFW;
    }

    //установка сцены на экран
    public void setScene(SceneFW sceneFW) throws IllegalAccessException {
        if(sceneFW == null){
            throw new IllegalAccessException("Не возможно загрузить сцену");
        }else{
            this.sceneFW.pause();// ставим на паузу сцену
            this.sceneFW.dispose();// уничтожаем сцену
            sceneFW.resume();
            sceneFW.update();
            this.sceneFW=sceneFW;
        }
    }

    //возврощяет текущую сцену
    public SceneFW getCurrentScene(){
        return sceneFW;
    }

    //
    public TouchListenerFW getTouchListenerFW(){
        return touchListenerFW;
    }

    //возврощяет начальную сцену
    public SceneFW getStartScene(){
        return sceneFW;
    }
}
