package com.jdxarmy.front.dragNdrop;

import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class UnitMoveTarget extends Target {
    CellImage movedFrom;
    GameManager manager;

    public UnitMoveTarget(CellImage movedTo, CellImage movedFrom, GameManager manager) {
        super(movedTo);
        this.movedFrom = movedFrom;
        this.manager = manager;
    }

    @Override
    public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        return true;
    }

    @Override
    public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        try {
            manager.getScreenComponentsManager().getInfoTab().removeActionCancelButton();
            manager.getDragNDropManager().clearUnitMoveDragNDrop();
            manager.getScreenComponentsManager().getActionTab().disableButtons();
            CellImage movedTo = (CellImage)getActor();
            movedFrom.moveOccupier(movedTo);
            manager.changeMoveTurn();
        } catch(Exception ex) {
            manager.getScreenComponentsManager().spawnPopUpWindow(ex.getMessage());
        }
    }
}
