package com.jdxarmy.front.dragNdrop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.front.constants.Defaults;

public class CellSource extends Source {
    final DragAndDrop.Payload payload = new DragAndDrop.Payload();
    Unit unit;

    public CellSource(Actor actor, Unit unit) {
        super(actor);
        this.unit = unit;
    }

    @Override
    public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
        Image dragActor = new Image(((Image)getActor()).getDrawable());
        dragActor.setSize(Defaults.GAMEFIELD_CELL_WIDTH, Defaults.GAMEFIELD_CELL_HEIGHT);
        payload.setObject(unit);
        payload.setDragActor(dragActor);

        return payload;
    }
}
