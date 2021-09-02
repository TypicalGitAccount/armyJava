package com.jdxarmy.front.listeners.gameFieldImage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameScreenDragNDropManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;

public class UnitSpawnCancelListener extends ClickListener {
    CellImage listened;
    GameScreenDragNDropManager manager;

    public UnitSpawnCancelListener(CellImage listened, GameScreenDragNDropManager manager) {
        super(Input.Buttons.RIGHT);
        this.listened = listened;
        this.manager = manager;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        listened.deOccupy();
        listened.setDrawable(new Image(new Texture(Gdx.files.internal("sprites/cell.png"))).getDrawable());
        if ( listened.getCellX() < listened.getField().getSideSize()/2 ) {
            manager.addBlueTeamDragNDropTargets();
        } else {
            manager.addRedTeamDragNDropTargets();
        }
    }
}
