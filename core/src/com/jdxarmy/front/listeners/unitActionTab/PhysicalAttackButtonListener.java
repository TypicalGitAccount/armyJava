package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class PhysicalAttackButtonListener extends ClickListener {
    GameManager manager;
    CellImage attacker;

    public PhysicalAttackButtonListener(GameManager manager, CellImage attacker) {
        this.manager = manager;
        this.attacker = attacker;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().getGameFieldImg().addPhysicalAttackedUnitListener(manager, attacker);
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();
    }
}
