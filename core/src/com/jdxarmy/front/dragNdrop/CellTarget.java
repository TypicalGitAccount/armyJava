package com.jdxarmy.front.dragNdrop;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class CellTarget extends Target {
    public CellTarget(CellImage actor) {
        super(actor);
    }

    @Override
    public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        return true;
    }

    @Override
    public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        try {
            Unit toSpawn = ((Unit)payload.getObject()).getCopy();
            ((CellImage)getActor()).occupy(toSpawn);
            ((CellImage)getActor()).setDrawable(((Image)payload.getDragActor()).getDrawable());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
