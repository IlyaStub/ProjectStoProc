package com.game.projectstoproc.scene;

import com.game.my_framework.CoreFW;
import com.game.my_framework.SceneFW;
import com.game.projectstoproc.louders.LouderAsset;

public class MainActivity extends CoreFW {

    public SceneFW getStartScene(){
        LouderAsset loaderAssets = new LouderAsset(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }
}