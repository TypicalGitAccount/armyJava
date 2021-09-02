package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class TransformEnemyButtonListener extends ClickListener {
    GameManager manager;
    CellImage attacker;

    public TransformEnemyButtonListener(GameManager manager, CellImage attacker) {
        this.manager = manager;
        this.attacker = attacker;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().getGameFieldImg().addTransformedEnemyListener(manager, attacker);
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();
    }
}
