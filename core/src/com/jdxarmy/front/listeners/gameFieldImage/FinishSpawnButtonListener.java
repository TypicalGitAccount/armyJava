package com.jdxarmy.front.listeners.gameFieldImage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameManager;

public class FinishSpawnButtonListener extends ClickListener {
    GameManager manager;
    Button finishSpawnButton;

    public FinishSpawnButtonListener(GameManager manager, Button finishSpawnButton) {
        this.manager = manager;
        this.finishSpawnButton = finishSpawnButton;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        finishSpawnButton.remove();
        manager.getListenersManager().removeRedTeamUnitSpawnCancelListener();
        manager.getDragNDropManager().clearUnitMoveDragNDrop();
        manager.getScreenComponentsManager().getGameFieldImg().clearListeners();
        manager.getListenersManager().addUnitInfoTabListeners();
        manager.startGame();
    }
}
