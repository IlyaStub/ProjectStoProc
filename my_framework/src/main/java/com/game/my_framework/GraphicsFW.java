package com.game.my_framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

//класс работы с графикой
public class GraphicsFW {

    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame; //содержит картинку, которая накладывается на конвас (размер зависит от размера устройства)
    private Canvas canvasGame; //На нем рисовать
    private Paint paintGame;
    private Bitmap textureGame; // текстура игрока, фона и тд

    //конструктор
    public GraphicsFW(AssetManager assetManagerGame, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    //метод очищающий сцену от всего
    public void clearScene(int colorRGB){
        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB); // все нарисованные пиксели на экрани станут одним цветом (colorRGB)
    }

    //метод рисует пиксели
    public void drawPixel(int x, int y, int color){
        paintGame.setColor(color); // для paint устанавливаем цвет
        canvasGame.drawPoint(x, y, paintGame); // рисуем точку
    }

    //метод рисует линии
    public void drawLine(int startX, int startY, int stopX, int stopY, int color){
        paintGame.setColor(color); // для paint устанавливаем цвет
        canvasGame.drawLine(startX, startY, stopX, stopY, paintGame); // рисуем линию
    }

    //метод выводит текст
    public void drawText(String text, int x, int y, int collor, int sizeText, Typeface font){
        paintGame.setColor(collor);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }

    //метод рисует текстуры
    public void drawTexture(Bitmap textureGame, int x, int y){
        canvasGame.drawBitmap(textureGame, x, y, null);
    }

    //метод возврощает ширину фрейма
    public int getWidthFrameBuffer(){
        return frameBufferGame.getWidth();
    }

    //метод возврощает высоту фрейма
    public int getHeightFrameBuffer(){
        return frameBufferGame.getHeight();
    }

    //загружает и возвращает текстуру
    public Bitmap newTexture(String fileName){
        InputStream inputStream = null; // иницилизируем поток
        try {
            inputStream = assetManagerGame.open(fileName); //открываем поток, который позволяет открывать фаилы на файловой системе
            textureGame = BitmapFactory.decodeStream(inputStream); //в текстуру, с помощью метода BitmapFactory, передаём наш поток
            if(textureGame == null){ //если он пустой, то выводим исключение
                throw new RuntimeException("Невозможно загрузить фаил (битмап) " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Невозможно загрузить фаил (битмап) " + fileName);
        }
        if(inputStream!=null){
            try {
                inputStream.close();// закрываем поток
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return textureGame;
    }

    //
    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite){
        Bitmap newSprite = Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
        return newSprite;
    }
}
