package com.example.projectstoproc.louders;

import android.graphics.Bitmap;

import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.UtilResoursHelper;
import com.example.projectstoproc.ResultGame;

import java.util.ArrayList;

//загрузчик картинок
public class LouderAsset {
    CoreFW coreFW;
    public LouderAsset(CoreFW coreFW, GraphicsFW graphicsFW){
        loadTexture(graphicsFW);//подгрузка текстуры
        loadSpritePlayer(graphicsFW);
        loadBackGround(graphicsFW);
        loadSpriteEnemy(graphicsFW);
        loadSpriteCoins(graphicsFW);
        loadAudio(coreFW);
    }

    private void loadAudio(CoreFW coreFW) {
        UtilResoursHelper.gameMusic = coreFW.getAudioFW().newMusic("gameMusicVersionFirst.mp3");
        UtilResoursHelper.soundMoney = coreFW.getAudioFW().newSound("soundMoney.ogg");
        UtilResoursHelper.soundKrick = coreFW.getAudioFW().newSound("soundKric.mp3");
        UtilResoursHelper.soundClick = coreFW.getAudioFW().newSound("soundClick.ogg");
    }

    private void loadSpriteCoins(GraphicsFW graphicsFW) {
        UtilResoursHelper.spriteCoin = new ArrayList<>();
        UtilResoursHelper.spriteCoin.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 511, 0, 26, 26));
        UtilResoursHelper.spriteCoin.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 541, 0, 26, 26));
        UtilResoursHelper.spriteCoin.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 566, 0, 26, 26));
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
        UtilResoursHelper.textureBackground.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 1034, 162, 800, 600));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        //добавляем картинки в эрей лист, для анимации
        //анимация, когда нажат
        UtilResoursHelper.spritePlayerIfTouch = new ArrayList<>();
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 3, 86, 64, 64));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 95, 85, 64, 64));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 173, 86, 64, 64));
        UtilResoursHelper.spritePlayerIfTouch.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 257, 86, 64, 64));

        //картинка, когда отжата
        UtilResoursHelper.spritePlayer = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 10, 7, 64, 64);

        //анимация, когда на полу
        UtilResoursHelper.spritePlayerDown = new ArrayList<>();
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 343, 85, 64, 64));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 415, 85, 64, 64));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 343, 85, 64, 64));
        UtilResoursHelper.spritePlayerDown.add(graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 483, 82, 64, 64));

        //картинка получения урона в полете при нажатой
        UtilResoursHelper.spritePlayerDamageIfTouch = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 650, 84, 64, 64);

        //картинка получения урона в полете не нажата
        UtilResoursHelper.spritePlayerDamage = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 736, 84, 64, 64);

        //картинка получения урона на полу не нажата
        UtilResoursHelper.spritePlayerDamageDown = graphicsFW.newSprite(UtilResoursHelper.textureAtlas, 568, 84, 64, 64);

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

        /*ResultGame.loadDistance(coreFW);*/
    }
}
