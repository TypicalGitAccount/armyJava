package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class MagicAttackButtonListener extends ClickListener {
    GameManager manager;
    CellImage unitImg;

    public MagicAttackButtonListener(GameManager manager, CellImage unitImg) {
        this.manager = manager;
        this.unitImg = unitImg;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().spawnSpellChoiceBox(unitImg);
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();
    }
}
