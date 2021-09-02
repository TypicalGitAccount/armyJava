package com.jdxarmy.front.listeners.unitActions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class PhysicalAttackedListener extends ClickListener {
    CellImage attacker, attacked;
    GameManager manager;

    public PhysicalAttackedListener(GameManager manager, CellImage attacker, CellImage attacked) {
        this.manager = manager;
        this.attacker = attacker;
        this.attacked = attacked;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        try {
            attacker.getOccupier().attack(attacked.getOccupier());
            manager.getScreenComponentsManager().getInfoTab().removeActionCancelButton();
            manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(attacked);
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            manager.changeMoveTurn();
        } catch(UnitIsDeadException ex) {
            if ( ex.getDeadUnitName().equals(attacked.getOccupier().getState().getName()) ) {
                manager.getScreenComponentsManager().getGameFieldImg().removeUnit(attacked);
            } else {
                manager.getScreenComponentsManager().getGameFieldImg().removeUnit(attacker);
            }
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().enableButtons();
            manager.changeMoveTurn();
        } catch(Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
