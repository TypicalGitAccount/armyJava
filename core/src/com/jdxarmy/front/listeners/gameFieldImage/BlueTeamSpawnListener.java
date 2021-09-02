package com.jdxarmy.front.listeners.gameFieldImage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.managers.GameManager;

public class BlueTeamSpawnListener extends ClickListener {
    Stage screenStage;
    GameManager manager;
    ImageTextButton spawnNextTeamButton;

    public BlueTeamSpawnListener(Stage screenStage, GameManager manager) {
        super();
        this.manager = manager;
        this.screenStage = screenStage;
        manager.getDragNDropManager().addTeamBlueDragNDropSources();
        manager.getDragNDropManager().addBlueTeamDragNDropTargets();
        manager.getListenersManager().addBlueTeamSpawnCancelListener();
        spawnNextTeamButton = new ImageTextButton("Spawn next team!", new Skin(Gdx.files.internal("skins/number-cruncher/skin/number-cruncher-ui.json")));
    }

    @Override
    public boolean mouseMoved(InputEvent event, float x, float y) {
        if (manager.getScreenComponentsManager().getGameFieldImg().getGameField().getUnitsAmount() == Defaults.UNITS_IN_TEAM) {
            manager.getDragNDropManager().removeDragNDropTargets();
            spawnNextTeamButton.setPosition(Gdx.graphics.getWidth() * 0.55f, Gdx.graphics.getHeight() * 0.07f);
            screenStage.addActor(spawnNextTeamButton);
            spawnNextTeamButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    spawnNextTeamButton.setChecked(true);
                }
            });
        } else {
            spawnNextTeamButton.remove();
        }

        return true;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        super.enter(event, x, y, pointer, fromActor);
        if ( screenStage.getActors().get(screenStage.getActors().size-1).equals(spawnNextTeamButton) && spawnNextTeamButton.isChecked() ) {
            spawnNextTeamButton.remove();
            manager.getListenersManager().removeBlueTeamSpawnCancelListener();
            manager.getScreenComponentsManager().getGameFieldImg().removeListener(this);
            manager.getDragNDropManager().removeDragNDropSources();
            manager.getScreenComponentsManager().getGameFieldImg().addListener(new RedTeamSpawnListener(screenStage, manager));
        }
    }

}
