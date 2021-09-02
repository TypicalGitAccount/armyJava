package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class SpawnButtonListener extends ClickListener {
    GameManager manager;
    CellImage spawner;

    public SpawnButtonListener(GameManager manager, CellImage spawner) {
        this.manager = manager;
        this.spawner = spawner;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();

        try {
            int[] spawnedOn = spawner.getOccupier().spawnSpecialAbility(manager.getScreenComponentsManager().getGameFieldImg().getGameField());
            if ( spawner.getOccupier().getState().getTeam().equals(Team.BLUE) ) {
                manager.getScreenComponentsManager().getGameFieldImg().getCellImage(spawnedOn[0], spawnedOn[1]).setDrawable(new Image(new Texture("sprites/demon_blue.png")).getDrawable());
            } else {
                manager.getScreenComponentsManager().getGameFieldImg().getCellImage(spawnedOn[0], spawnedOn[1]).setDrawable(new Image(new Texture("sprites/demon_red.png")).getDrawable());
            }
            manager.getScreenComponentsManager().getInfoTab().drawFromCellImage(spawner);
            manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
            manager.getScreenComponentsManager().getActionTab().enableButtons();
            manager.changeMoveTurn();
        } catch (Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
