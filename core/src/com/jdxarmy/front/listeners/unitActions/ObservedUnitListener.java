package com.jdxarmy.front.listeners.unitActions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.interfaces.Observer;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class ObservedUnitListener extends ClickListener {
    GameManager manager;
    CellImage observed, observer;

    public ObservedUnitListener(GameManager manager, CellImage observed, CellImage observer) {
        this.manager = manager;
        this.observed = observed;
        this.observer = observer;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        try {
            observer.getOccupier().observeSpecialAbility((Observer) observer.getOccupier(), observed.getOccupier());
            if ( observed.getOccupier() != null ) {
                manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(observed);
            } else {
                manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(observer);
            }
            manager.getScreenComponentsManager().getInfoTab().removeActionCancelButton();
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            manager.changeMoveTurn();
        } catch (Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
