package com.jdxarmy.front.managers;

import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.listeners.gameFieldImage.BlueTeamSpawnListener;
import com.jdxarmy.front.listeners.gameFieldImage.UnitSpawnCancelListener;
import java.util.ArrayList;

public class GameScreenListenersManager {
    GameScreenComponentsManager componentsManager;
    GameScreenDragNDropManager dragNDropManager;
    ArrayList<UnitSpawnCancelListener> blueTeamSpawnCancelListeners;
    ArrayList<UnitSpawnCancelListener> redTeamSpawnCancelListeners;

    public GameScreenListenersManager(GameScreenComponentsManager componentsManager, GameScreenDragNDropManager dragNDropManager) {
        this.componentsManager = componentsManager;
        this.dragNDropManager = dragNDropManager;
        this.blueTeamSpawnCancelListeners = new ArrayList<>();
        this.redTeamSpawnCancelListeners = new ArrayList<>();
    }

    public void addBlueTeamToActionTabListeners() { componentsManager.fieldImg.addBlueTeamToActionTabListener(componentsManager.actionTab); }

    public void addRedTeamToActionTabListeners() {
        componentsManager.fieldImg.addRedTeamToActionTabListener(componentsManager.actionTab);
    }

    public void addSpawnUnitsListener(GameManager manager) {
        componentsManager.fieldImg.addListener(new BlueTeamSpawnListener(componentsManager.screenStage, manager));
    }

    public void addBlueTeamSpawnCancelListener() {
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE / 2; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                UnitSpawnCancelListener listener = new UnitSpawnCancelListener(componentsManager.fieldImg.getCellImage(rows, cols), dragNDropManager);
                blueTeamSpawnCancelListeners.add(listener);
                componentsManager.fieldImg.getCellImage(rows, cols).addListener(listener);
            }
        }
    }

    public void addRedTeamSpawnCancelListener() {
        for (int rows = Defaults.GAMEFIELD_CELLS_IN_SIDE / 2; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                UnitSpawnCancelListener listener = new UnitSpawnCancelListener(componentsManager.fieldImg.getCellImage(rows, cols), dragNDropManager);
                redTeamSpawnCancelListeners.add(listener);
                componentsManager.fieldImg.getCellImage(rows, cols).addListener(listener);
            }
        }
    }

    public void removeBlueTeamSpawnCancelListener() {
        int fieldCells = Defaults.GAMEFIELD_CELLS_IN_SIDE * Defaults.GAMEFIELD_CELLS_IN_SIDE / 2;
        for (int i = 0; i < fieldCells; i++) {
            componentsManager.fieldImg.removeListener(blueTeamSpawnCancelListeners.get(i));
        }
    }

    public void removeRedTeamUnitSpawnCancelListener() {
        int fieldCells = Defaults.GAMEFIELD_CELLS_IN_SIDE * Defaults.GAMEFIELD_CELLS_IN_SIDE / 2;
        for (int i = 0; i < fieldCells; i++) {
            componentsManager.fieldImg.removeListener(redTeamSpawnCancelListeners.get(i));
        }
    }

    public void addUnitInfoTabListeners() {
        componentsManager.fieldImg.addGameFieldToInfoTabClickListener(componentsManager, componentsManager.infoTab);
        componentsManager.choiceTab.addInfoTabClickListener(componentsManager.infoTab);
    }
}
