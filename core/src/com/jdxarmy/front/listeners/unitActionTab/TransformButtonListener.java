package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class TransformButtonListener extends ClickListener {
    GameManager manager;
    CellImage unitImg;
    String transformImgPath;

    public TransformButtonListener(GameManager manager, CellImage unitImg, String transformImgPath) {
        this.manager = manager;
        this.unitImg = unitImg;
        this.transformImgPath = transformImgPath;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        try {
            unitImg.getOccupier().selfTransformSpecialAbility();
            unitImg.setDrawable(new Image(new Texture(transformImgPath)).getDrawable());
            manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(unitImg);
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            manager.changeMoveTurn();
        } catch(Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
