package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class ObserveAbilityButtonListener extends ClickListener {
    GameManager manager;
    CellImage observer;

    public ObserveAbilityButtonListener(GameManager manager, CellImage observer) {
        this.manager = manager;
        this.observer = observer;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().getGameFieldImg().addObservedUnitListener(manager, observer);
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();
    }
}
