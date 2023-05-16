package com.example.projectstoproc.scene;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.projectstoproc.databinding.ActivityMainBinding;
import com.example.projectstoproc.louders.LouderAsset;
import com.example.projectstoproc.scene.MainMenuScene;

public class MainActivity extends CoreFW {

    public SceneFW getStartScene(){
        LouderAsset loaderAssets = new LouderAsset(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }
}