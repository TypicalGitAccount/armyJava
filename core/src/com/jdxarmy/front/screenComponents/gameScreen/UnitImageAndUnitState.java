package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdxarmy.back.classes.states.State;

public class UnitImageAndUnitState extends Image {
    State unitInfo;

    public UnitImageAndUnitState(String filepath, State unitInfo) {
        super(new Texture(filepath));
        this.unitInfo = unitInfo;
    }

    public State getState() { return unitInfo; }
}
