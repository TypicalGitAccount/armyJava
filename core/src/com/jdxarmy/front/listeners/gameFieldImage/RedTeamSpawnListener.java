package com.jdxarmy.front.listeners.gameFieldImage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.managers.GameManager;

public class RedTeamSpawnListener extends ClickListener {
    Stage screenStage;
    GameManager manager;
    ImageTextButton finishSpawnButton;

    public RedTeamSpawnListener(Stage screenStage, GameManager manager) {
        this.manager = manager;
        this.screenStage = screenStage;
        this.finishSpawnButton = new ImageTextButton("Ready to fight!", new Skin(Gdx.files.internal("skins/number-cruncher/skin/number-cruncher-ui.json")));
        finishSpawnButton.setPosition(Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight() * 0.07f);
        finishSpawnButton.addListener(new FinishSpawnButtonListener(manager, finishSpawnButton));
        manager.getScreenComponentsManager().changeChoiceTabTeam(Team.RED);
        manager.getDragNDropManager().addTeamRedDragNDropSources();
        manager.getDragNDropManager().addRedTeamDragNDropTargets();
        manager.getListenersManager().addRedTeamSpawnCancelListener();
    }

    @Override
    public boolean mouseMoved(InputEvent event, float x, float y) {
        if (manager.getScreenComponentsManager().getGameFieldImg().getGameField().getUnitsAmount() == Defaults.UNITS_IN_TEAM*2) {
            manager.getDragNDropManager().removeDragNDropTargets();
            screenStage.addActor(finishSpawnButton);
        } else {
            finishSpawnButton.remove();
        }

        return true;
    }
}
