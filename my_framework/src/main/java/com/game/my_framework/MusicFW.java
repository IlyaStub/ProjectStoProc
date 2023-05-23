package com.game.my_framework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class MusicFW implements MediaPlayer.OnCompletionListener {

    MediaPlayer mediaPlayer;
    boolean prepared = false;//пказывает, готова ли музыка к воспроизведлению

    public MusicFW(AssetFileDescriptor assetFileDescriptor) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        prepared = true;

        mediaPlayer.setOnCompletionListener(this);
    }

    public void playMusic(boolean looping, float volume){
        if(mediaPlayer.isPlaying()){
            return;
        }
        synchronized (this){
            if(!prepared){
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            mediaPlayer.setLooping(looping);
            mediaPlayer.setVolume(volume, volume);//левая и правая
            mediaPlayer.start();
        }
    }

    public void stopMusic(){
        mediaPlayer.stop();
        synchronized (this){
            prepared = false;
        }
    }

    public void disposeMusic(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this){
            prepared = false;
        }
    }
}
