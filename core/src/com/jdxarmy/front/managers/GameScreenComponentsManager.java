package com.jdxarmy.front.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.screenComponents.gameScreen.*;

public class GameScreenComponentsManager {
    Stage screenStage;
    SpriteBatch screenBatch;
    GameFieldImage fieldImg;
    UnitInfoTab infoTab;
    UnitChoosingTab choiceTab;
    UnitActionChoiceTab actionTab;
    SpellChoiceMenu spellMenu;
    GameManager manager;

    public GameScreenComponentsManager(GameManager manager, Stage screenStage, SpriteBatch screenBatch) {
        this.manager = manager;
        this.screenStage = screenStage;
        this.screenBatch = screenBatch;
        this.fieldImg = new GameFieldImage(Defaults.SPRITES_GAMEFIELD_CELL, screenStage);
        this.infoTab = new UnitInfoTab(manager, screenStage, screenBatch);
        this.choiceTab = new UnitChoosingTab(screenStage);
    }

    public GameFieldImage getGameFieldImg() { return fieldImg; }

    public UnitActionChoiceTab getActionTab() { return actionTab; }

    public UnitInfoTab getInfoTab() { return infoTab; }

    public void placeTeams() {
        manager.getListenersManager().addUnitInfoTabListeners();
        spawnPopUpWindow("Spawn blue team units by dragging and dropping\n" +
                "them from units tab to left field side. Remove unit from field\n " +
                "by right clicking on it. Only 8 units per team allowed!");
        manager.getListenersManager().addSpawnUnitsListener(manager);
    }

    public void changeChoiceTabTeam(String team) {
        choiceTab.setTeamToSpawn(team);
    }

    public void removeUnitChoiceTab() {
        this.choiceTab.remove();
    }

    public void placeUnitActionChoiceTab() {
        actionTab = new UnitActionChoiceTab(screenStage, manager);
        actionTab.draw();
        manager.getListenersManager().addBlueTeamToActionTabListeners();
    }

    public void spawnSpellChoiceBox(CellImage unitImg) {
        this.spellMenu =  new SpellChoiceMenu(manager, unitImg, "spells", new Skin(Gdx.files.internal(Defaults.SKINS_UISKIN_PATH)));
        spellMenu.show(screenStage);
    }

    public void removeSpellChoiceBox() {
        if ( spellMenu != null ) {
            spellMenu.remove();
        }
    }

    public void spawnPopUpWindow(String windowText) {
        Dialog dialog = new Dialog("", new Skin(Gdx.files.internal(Defaults.SKINS_NUMBER_CRUNCHER_PATH)));
        dialog.text(windowText);
        dialog.button("OK", true);
        dialog.key(Input.Keys.ENTER, true);
        dialog.show(screenStage);
    }
}
