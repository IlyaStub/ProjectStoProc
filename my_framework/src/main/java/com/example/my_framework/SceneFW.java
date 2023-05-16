package com.example.my_framework;

// все сцены будут имплеминтироваться от этого
public abstract class SceneFW {
    public CoreFW coreFW;
    public int sceneWidth;//ширина сцены
    public int sceneHeight;//высота сцены
    public GraphicsFW graphicsFW;// графика

    public SceneFW(CoreFW coreFW){
        this.coreFW = coreFW;
        sceneWidth = coreFW.getGraphicsFW().getWidthFrameBuffer();
        sceneHeight = coreFW.getGraphicsFW().getHeightFrameBuffer();
        graphicsFW = coreFW.getGraphicsFW();
    }


    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();//удаление сцены с экрана
}
