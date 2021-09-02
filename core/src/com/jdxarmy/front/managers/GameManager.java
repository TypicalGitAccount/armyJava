package com.jdxarmy.front.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jdxarmy.back.classes.constants.Team;

public class GameManager {
    GameScreenComponentsManager componentsManager;
    GameScreenListenersManager listenersManager;
    GameScreenDragNDropManager dragNDropManager;
    String teamTurn;

    public GameManager(Stage screenStage, SpriteBatch screenBatch) {
        this.componentsManager = new GameScreenComponentsManager(this, screenStage, screenBatch);
        this.dragNDropManager = new GameScreenDragNDropManager(this, componentsManager);
        this.listenersManager = new GameScreenListenersManager(componentsManager, dragNDropManager);
        this.teamTurn = Team.BLUE;
    }

    public String getTeamTurn() { return teamTurn; }

    public GameScreenComponentsManager getScreenComponentsManager() { return componentsManager; }

    public GameScreenListenersManager getListenersManager() { return listenersManager; }

    public GameScreenDragNDropManager getDragNDropManager() { return dragNDropManager; }

    private void gameOverCheck() {
        if ( componentsManager.getGameFieldImg().getGameField().isGameOver() ) {
            componentsManager.spawnPopUpWindow("Game over!");
            Gdx.app.exit();
        }
    }

    public void startGame() {
        componentsManager.removeUnitChoiceTab();
        componentsManager.placeUnitActionChoiceTab();
    }

    public void run() { componentsManager.placeTeams(); }

    public void changeMoveTurn() {
        gameOverCheck();
        componentsManager.fieldImg.clearListeners();
        componentsManager.fieldImg.addGameFieldToInfoTabClickListener(componentsManager, componentsManager.infoTab);

        if ( teamTurn.equals(Team.BLUE) ) {
            teamTurn = Team.RED;
            listenersManager.addRedTeamToActionTabListeners();
        } else {
            teamTurn = Team.BLUE;
            listenersManager.addBlueTeamToActionTabListeners();
        }
    }
}
