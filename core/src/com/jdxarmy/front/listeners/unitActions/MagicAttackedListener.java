package com.jdxarmy.front.listeners.unitActions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class MagicAttackedListener extends ClickListener {
    CellImage attacked;
    SpellCaster attacker;
    GameManager manager;

    public MagicAttackedListener(GameManager manger, CellImage attacked, SpellCaster attacker) {
        this.attacked = attacked;
        this.attacker = attacker;
        this.manager = manger;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        try {
            attacker.magicAttack(attacked.getOccupier());
            manager.getScreenComponentsManager().getInfoTab().removeActionCancelButton();
            manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(attacked);
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            manager.changeMoveTurn();
        } catch(UnitIsDeadException ex) {
            manager.getScreenComponentsManager().getGameFieldImg().removeUnit(attacked);
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().enableButtons();
            manager.changeMoveTurn();
        } catch (Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
