package com.jdxarmy.front.dragNdrop;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class UnitMoveSource extends Source {
    final DragAndDrop.Payload payload = new DragAndDrop.Payload();

    public UnitMoveSource(CellImage actor) {
        super(actor);
    }

    @Override
    public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
        Image dragActor = new Image(((CellImage) getActor()).getDrawable());
        dragActor.setSize(Defaults.GAMEFIELD_CELL_WIDTH, Defaults.GAMEFIELD_CELL_HEIGHT);
        payload.setDragActor(dragActor);
        payload.setObject(((CellImage)getActor()).getOccupier());

        return payload;
    }
}
