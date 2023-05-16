package com.example.projectstoproc.louders;

import android.graphics.Bitmap;

import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.UtilResoursHelper;

import java.util.ArrayList;

//загрузчик картинок
public class LouderAsset {
    public LouderAsset(CoreFW coreFW, GraphicsFW graphicsFW){
        loadTexture(graphicsFW);//подгрузка текстуры
        loadSpritePlayer(graphicsFW);
        loadBackGround(graphicsFW);
        loadSpriteEnemy(graphicsFW);
    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResoursHelper.spriteEnemyRocket = new ArrayList<>();
        UtilResoursHelper.spriteEnemyRocket.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 105, 0, 83, 28));
        UtilResoursHelper.spriteEnemyRocket.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 193, 0, 83, 28));
        UtilResoursHelper.spriteEnemyRocket.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 281, 0, 83, 28));
        UtilResoursHelper.spriteEnemyRocket.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 369, 0, 83, 28));

    }

    private void loadBackGround(GraphicsFW graphicsFW) {
        UtilResoursHelper.textureBackground = new ArrayList<>();
        UtilResoursHelper.textureBackground.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 0, 162, 890, 600));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        //добавляем картинки в эрей лист, для анимации
        //анимация, когда нажат
        UtilResoursHelper.spritePlayerIfTouch = new ArrayList<>();
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 0, 82, 80, 68));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 87, 82, 80, 68));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 172, 82, 80, 68));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 255, 82, 80, 68));

        //картинка, когда отжата
        UtilResoursHelper.spritePlayer = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 0, 3, 66, 70);

        //анимация, когда на полу
        UtilResoursHelper.spritePlayerDown = new ArrayList<>();
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 356, 82, 58, 68));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 421, 82, 58, 68));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 356, 82, 58, 68));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 483, 82, 58, 68));

        //картинка получения урона в полете при нажатой
        UtilResoursHelper.spritePlayerDamageIfTouch = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 642, 82, 80, 68);

        //картинка получения урона в полете не нажата
        UtilResoursHelper.spritePlayerDamage = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 734, 82, 66, 70);

        //картинка получения урона в полете не нажата
        UtilResoursHelper.spritePlayerDamageDown = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 568, 82, 66, 70);

        //смерть игрока
        UtilResoursHelper.spritePlayerDeath = new ArrayList<>();
        UtilResoursHelper.spritePlayerDeath.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 858, 85, 58, 68));
        UtilResoursHelper.spritePlayerDeath.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 939, 80, 59, 64));
        UtilResoursHelper.spritePlayerDeath.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 1020, 83, 65, 60));
        UtilResoursHelper.spritePlayerDeath.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 1102, 81, 68, 60));

        //смерть игрока на полу
        UtilResoursHelper.spritePlayerDeathDown = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 1102, 81, 68, 60);
    }

    private void loadTexture(GraphicsFW graphicsFW) {
        UtilResoursHelper.textureAtlas = graphicsFW.newTexture("texture_atlasSecond.png");
    }
}
