package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class MoveButtonClickListener extends ClickListener {
    GameManager manager;
    CellImage unitToMove;

    public MoveButtonClickListener(CellImage unitToMove, GameManager manager) {
        super();
        this.manager = manager;
        this.unitToMove = unitToMove;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getScreenComponentsManager().getActionTab().disableButtons();
        manager.getDragNDropManager().addUnitMoveDragNDrop(unitToMove);
        manager.getScreenComponentsManager().getInfoTab().addActionCancelButton();
    }
}
