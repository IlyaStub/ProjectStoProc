package com.example.projectstoproc;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.projectstoproc.generodtor.GeneratorEnemy;

public class Panel {
    private int distance;
    private int money;
    private int health;

    CoreFW coreFW;

    private final int HEIGHT_PANEL = 50;

    public Panel(CoreFW coreFW){
        this.coreFW = coreFW;
    }

    public void update(int distance, int money, int health){
        this.distance = distance;
        this.money = money;
        this.health = health;
    }

    public void drawing(GraphicsFW graphicsFW){
        graphicsFW.drawLine(0, HEIGHT_PANEL, graphicsFW.getWidthFrameBuffer(), HEIGHT_PANEL, Color.BLUE);
        graphicsFW.drawText(coreFW.getString(R.string.panel_distance) + distance, 10, 30, Color.BLACK, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.panel_money) + money, graphicsFW.getWidthFrameBuffer()/2-80, 30, Color.BLACK, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.panel_health) + health, graphicsFW.getWidthFrameBuffer()-110, 30, Color.BLACK, 25, null);
    }

    public int getHEIGHT_PANEL() {
        return HEIGHT_PANEL;
    }
}
