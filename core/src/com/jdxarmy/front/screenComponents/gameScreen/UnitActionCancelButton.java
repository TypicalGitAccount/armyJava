package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdxarmy.front.listeners.unitActionTab.ActionCancelButtonListener;
import com.jdxarmy.front.managers.GameManager;

public class UnitActionCancelButton extends ImageTextButton {
    public UnitActionCancelButton(GameManager manager) {
        super("Cancel action", new Skin(Gdx.files.internal("skins/number-cruncher/skin/number-cruncher-ui.json")));
        this.setPosition(Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight() * 0.07f);
        this.addListener(new ActionCancelButtonListener(manager, this));
    }
}
