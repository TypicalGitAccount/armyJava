package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.listeners.unitActions.MagicAttackedListener;
import com.jdxarmy.front.listeners.unitActions.ObservedUnitListener;
import com.jdxarmy.front.listeners.unitActions.PhysicalAttackedListener;
import com.jdxarmy.front.listeners.unitActions.TransformedEnemyListener;
import com.jdxarmy.front.listeners.unitInfoTab.CellImgToInfoTabClickListener;
import com.jdxarmy.front.listeners.unitActionTab.GameFieldToActionTabListener;
import com.jdxarmy.front.managers.GameManager;
import com.jdxarmy.front.managers.GameScreenComponentsManager;

import java.util.ArrayList;

public class GameFieldImage {
    GameField field;
    CellImage[][] cellImages;
    ArrayList<EventListener> blueTeamToActionTabListeners;
    ArrayList<EventListener> redTeamToActionTabListeners;

    private void draw(Stage screenStage) {
        float cellWidth = Defaults.GAMEFIELD_CELL_WIDTH;
        float cellHeight = Defaults.GAMEFIELD_CELL_HEIGHT;
        int rows = 0;
        for (int drawWidth = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; drawWidth += cellWidth, rows++) {
            int cols = 0;
            for (float drawHeight = Gdx.graphics.getHeight() - cellHeight; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; drawHeight -= cellHeight, cols++) {
                screenStage.addActor(cellImages[rows][cols]);
                cellImages[rows][cols].setBounds(cellWidth * rows, drawHeight, cellWidth, cellHeight);
            }
        }
    }

    public GameFieldImage(String cellImagePath, Stage screenStage) {
        this.field = new GameField(Defaults.GAMEFIELD_CELLS_IN_SIDE);
        this.cellImages = new CellImage[Defaults.GAMEFIELD_CELLS_IN_SIDE][Defaults.GAMEFIELD_CELLS_IN_SIDE];
        this.blueTeamToActionTabListeners = new ArrayList<>();
        this.redTeamToActionTabListeners = new ArrayList<>();

        for (int x = 0; x < Defaults.GAMEFIELD_CELLS_IN_SIDE; x++) {
            for (int y = 0; y < Defaults.GAMEFIELD_CELLS_IN_SIDE; y++) {
                this.cellImages[x][y] = new CellImage(cellImagePath, field, x, y);
            }
        }

        draw(screenStage);
    }

    public void addListener(EventListener listener) {
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                cellImages[rows][cols].addListener(listener);
            }
        }
    }

    public void addBlueTeamToActionTabListener(UnitActionChoiceTab actionTab) {
        CellImage cellImg;
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                cellImg = cellImages[rows][cols];
                if (cellImg.isOccupied() && cellImg.getOccupier().getState().getTeam().equals(Team.BLUE)) {
                    EventListener listener = new GameFieldToActionTabListener(cellImg, actionTab);
                    cellImg.addListener(listener);
                    blueTeamToActionTabListeners.add(listener);
                }
            }
        }
    }

    public void addRedTeamToActionTabListener(UnitActionChoiceTab actionTab) {
        CellImage cellImg;
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                cellImg = cellImages[rows][cols];
                if (cellImg.isOccupied() && cellImg.getOccupier().getState().getTeam().equals(Team.RED)) {
                    EventListener listener = new GameFieldToActionTabListener(cellImg, actionTab);
                    cellImg.addListener(listener);
                    redTeamToActionTabListeners.add(listener);
                }
            }
        }
    }

    public void addGameFieldToInfoTabClickListener(GameScreenComponentsManager manager, UnitInfoTab infoTab) {
        CellImage cellImg;
        for (int rows = 0; rows < field.getSideSize(); rows++ ) {
            for (int cols = 0; cols < field.getSideSize(); cols++) {
                cellImg = cellImages[rows][cols];
                cellImg.addListener(new CellImgToInfoTabClickListener(manager, infoTab, cellImg));
            }
        }
    }

    public void addPhysicalAttackedUnitListener(GameManager placementManager, CellImage attacker) {
        String attackedTeam;
        if ( attacker.getOccupier().getState().getTeam().equals(Team.BLUE) ) {
            attackedTeam = Team.RED;
        } else {
            attackedTeam = Team.BLUE;
        }
        CellImage cellImg;
        for (int rows = 0; rows < field.getSideSize(); rows++ ) {
            for (int cols = 0; cols < field.getSideSize(); cols++) {
                cellImg = cellImages[rows][cols];
                if ( cellImg.isOccupied() && cellImg.getOccupier().getState().getTeam().equals(attackedTeam) ) {
                    cellImg.addListener(new PhysicalAttackedListener(placementManager, attacker, cellImg));
                }
            }
        }
    }

    public void addMagicalAttackedUnitListener(GameManager placementManager, SpellCaster attacker) {
        String attackedTeam;
        if ( attacker.getState().getTeam().equals(Team.BLUE) ) {
            attackedTeam = Team.RED;
        } else {
            attackedTeam = Team.BLUE;
        }
        CellImage cellImg;
        for (int rows = 0; rows < field.getSideSize(); rows++ ) {
            for (int cols = 0; cols < field.getSideSize(); cols++) {
                cellImg = cellImages[rows][cols];
                if ( cellImg.isOccupied() && cellImg.getOccupier().getState().getTeam().equals(attackedTeam) ) {
                    cellImg.addListener(new MagicAttackedListener(placementManager, cellImg, attacker));
                }
            }
        }
    }

    public void addTransformedEnemyListener(GameManager placementManager, CellImage attacker) {
        String attackedTeam;
        if ( attacker.getOccupier().getState().getTeam().equals(Team.BLUE) ) {
            attackedTeam = Team.RED;
        } else {
            attackedTeam = Team.BLUE;
        }
        CellImage cellImg;
        for (int rows = 0; rows < field.getSideSize(); rows++ ) {
            for (int cols = 0; cols < field.getSideSize(); cols++) {
                cellImg = cellImages[rows][cols];
                if ( cellImg.isOccupied() && cellImg.getOccupier().getState().getTeam().equals(attackedTeam) ) {
                    cellImg.addListener(new TransformedEnemyListener(placementManager, attacker, cellImg));
                }
            }
        }
    }

    public void addObservedUnitListener(GameManager placementManager, CellImage observer) {
        CellImage cellImg;
        for (int rows = 0; rows < field.getSideSize(); rows++ ) {
            for (int cols = 0; cols < field.getSideSize(); cols++) {
                cellImg = cellImages[rows][cols];
                if ( cellImg.isOccupied() ) {
                    cellImg.addListener(new ObservedUnitListener(placementManager, cellImg, observer));
                }
            }
        }
    }

    public void removeListener(EventListener listener) {
        for ( int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for ( int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                cellImages[rows][cols].removeListener(listener);
            }
        }
    }

    public void clearListeners() {
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                cellImages[rows][cols].clearListeners();
            }
        }
    }

    public CellImage getCellImage(int x, int y) {
        return cellImages[x][y];
    }

    public GameField getGameField() {
        return field;
    }

    public void removeUnit(CellImage dead) {
        cellImages[dead.getCellX()][dead.getCellY()].deOccupy();
        cellImages[dead.getCellX()][dead.getCellY()].setDrawable(new Image(new Texture(Defaults.SPRITES_GAMEFIELD_CELL)).getDrawable());
    }
}
