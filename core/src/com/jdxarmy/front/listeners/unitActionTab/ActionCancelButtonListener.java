package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.front.managers.GameManager;

public class ActionCancelButtonListener extends ClickListener {
    GameManager manager;
    ImageTextButton actionCancelButton;

    public ActionCancelButtonListener(GameManager manager, ImageTextButton actionCancelButton) {
        this.manager = manager;
        this.actionCancelButton = actionCancelButton;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
        manager.getScreenComponentsManager().removeSpellChoiceBox();
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().getGameFieldImg().addGameFieldToInfoTabClickListener(manager.getScreenComponentsManager(), manager.getScreenComponentsManager().getInfoTab());
        manager.getScreenComponentsManager().getGameFieldImg().addListener(this);
        if ( manager.getTeamTurn().equals(Team.BLUE) ) {
            manager.getListenersManager().addBlueTeamToActionTabListeners();
        } else {
            manager.getListenersManager().addRedTeamToActionTabListeners();
        }
        actionCancelButton.remove();
    }


}
