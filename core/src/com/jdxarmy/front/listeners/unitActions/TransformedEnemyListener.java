package com.jdxarmy.front.listeners.unitActions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class TransformedEnemyListener extends ClickListener {
    GameManager manager;
    CellImage attacker, attacked;

    public TransformedEnemyListener(GameManager manager, CellImage attacker, CellImage attacked) {
        this.manager = manager;
        this.attacker = attacker;
        this.attacked = attacked;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        try {
            attacker.getOccupier().transformEnemySpecialAbility(attacked.getOccupier());
            manager.getScreenComponentsManager().getInfoTab().removeActionCancelButton();
            attacked.setDrawable(attacker.getDrawable());
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            manager.changeMoveTurn();
        } catch(Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
