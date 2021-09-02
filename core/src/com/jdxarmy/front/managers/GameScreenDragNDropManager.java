package com.jdxarmy.front.managers;

import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.units.*;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.dragNdrop.CellSource;
import com.jdxarmy.front.dragNdrop.CellTarget;
import com.jdxarmy.front.dragNdrop.UnitMoveSource;
import com.jdxarmy.front.dragNdrop.UnitMoveTarget;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;
import java.util.ArrayList;

public class GameScreenDragNDropManager {
    GameManager manager;
    GameScreenComponentsManager componentsManager;
    DragAndDrop fieldHalfDnd;
    DragAndDrop unitMoveDnd;
    ArrayList<DragAndDrop.Target> fieldHalfTargets;
    ArrayList<DragAndDrop.Source> fieldHalfSources;

    public GameScreenDragNDropManager(GameManager manager, GameScreenComponentsManager componentsManager) {
        this.manager = manager;
        this.componentsManager = componentsManager;
        this.fieldHalfDnd = new DragAndDrop();
        this.unitMoveDnd = new DragAndDrop();
        this.fieldHalfTargets = new ArrayList<>();
        this.fieldHalfSources = new ArrayList<>();
    }

    public void removeDragNDropTargets() {
        for (DragAndDrop.Target fieldHalfTarget : fieldHalfTargets) {
            fieldHalfDnd.removeTarget(fieldHalfTarget);
        }
    }

    public void addUnitMoveDragNDrop(CellImage unitToMove) {
        unitMoveDnd.addSource(new UnitMoveSource(unitToMove));

        int x = unitToMove.getCellX()+1;
        int y = unitToMove.getCellY();
        int unitMoveDist = unitToMove.getOccupier().getState().getMoveDistance();
        for (; x < Defaults.GAMEFIELD_CELLS_IN_SIDE && Math.abs(x-unitToMove.getCellX()) <= unitMoveDist; ++x) {
            unitMoveDnd.addTarget(new UnitMoveTarget(componentsManager.fieldImg.getCellImage(x, y), unitToMove, manager));
        }
        x = unitToMove.getCellX()-1;
        for ( ; x >= 0 && Math.abs(x-unitToMove.getCellX()) <= unitMoveDist; --x) {
            unitMoveDnd.addTarget(new UnitMoveTarget(componentsManager.fieldImg.getCellImage(x, y), unitToMove, manager));
        }
        x = unitToMove.getCellX();
        y = unitToMove.getCellY()-1;
        for ( ; y >= 0 && Math.abs(y-unitToMove.getCellY()) <= unitMoveDist; --y) {
            unitMoveDnd.addTarget(new UnitMoveTarget(componentsManager.fieldImg.getCellImage(x, y), unitToMove, manager));
        }
        y = unitToMove.getCellY()+1;
        for ( ; y < Defaults.GAMEFIELD_CELLS_IN_SIDE && Math.abs(y-unitToMove.getCellY()) <= unitMoveDist; ++y) {
            unitMoveDnd.addTarget(new UnitMoveTarget(componentsManager.fieldImg.getCellImage(x, y), unitToMove, manager));
        }
    }

    public void addTeamBlueDragNDropSources() {
        CellSource soldier = new CellSource(componentsManager.choiceTab.getUnitImage(0), new Soldier(null, Team.BLUE));
        fieldHalfSources.add(soldier);
        fieldHalfDnd.addSource(soldier);
        CellSource rogue = new CellSource(componentsManager.choiceTab.getUnitImage(1), new Rogue(null, Team.BLUE));
        fieldHalfSources.add(rogue);
        fieldHalfDnd.addSource(rogue);
        CellSource berserker = new CellSource(componentsManager.choiceTab.getUnitImage(2), new Berserker(null, Team.BLUE));
        fieldHalfSources.add(berserker);
        fieldHalfDnd.addSource(berserker);
        CellSource archer = new CellSource(componentsManager.choiceTab.getUnitImage(3), new Archer(null, Team.BLUE));
        fieldHalfDnd.addSource(archer);
        fieldHalfSources.add(archer);
        CellSource werewolf = new CellSource(componentsManager.choiceTab.getUnitImage(4), new WereWolf(null, Team.BLUE));
        fieldHalfDnd.addSource(werewolf);
        fieldHalfSources.add(werewolf);
        CellSource vampire = new CellSource(componentsManager.choiceTab.getUnitImage(5), new Vampire(null, Team.BLUE));
        fieldHalfDnd.addSource(vampire);
        fieldHalfSources.add(vampire);
        CellSource wizard = new CellSource(componentsManager.choiceTab.getUnitImage(6), new Wizard(null, Team.BLUE, new SpellBook()));
        fieldHalfDnd.addSource(wizard);
        fieldHalfSources.add(wizard);
        CellSource healer = new CellSource(componentsManager.choiceTab.getUnitImage(7), new Healer(null, Team.BLUE, new SpellBook()));
        fieldHalfDnd.addSource(healer);
        fieldHalfSources.add(healer);
        CellSource priest = new CellSource(componentsManager.choiceTab.getUnitImage(8), new Priest(null, Team.BLUE, new SpellBook()));
        fieldHalfDnd.addSource(priest);
        fieldHalfSources.add(priest);
        CellSource warlock = new CellSource(componentsManager.choiceTab.getUnitImage(9), new Warlock(null, Team.BLUE, new SpellBook()));
        fieldHalfDnd.addSource(warlock);
        fieldHalfSources.add(warlock);
        CellSource necromancer = new CellSource(componentsManager.choiceTab.getUnitImage(10), new Necromancer(null, Team.BLUE, new SpellBook()));
        fieldHalfDnd.addSource(necromancer);
        fieldHalfSources.add(necromancer);
        CellSource demon = new CellSource(componentsManager.choiceTab.getUnitImage(11), new Demon(null, Team.BLUE));
        fieldHalfDnd.addSource(demon);
        fieldHalfSources.add(demon);
        CellSource horse = new CellSource(componentsManager.choiceTab.getUnitImage(12), new Horse(null, Team.BLUE));
        fieldHalfDnd.addSource(horse);
        fieldHalfSources.add(horse);
    }

    public void addTeamRedDragNDropSources() {
        CellSource soldier = new CellSource(componentsManager.choiceTab.getUnitImage(0), new Soldier(null, Team.RED));
        fieldHalfSources.add(soldier);
        fieldHalfDnd.addSource(soldier);
        CellSource rogue = new CellSource(componentsManager.choiceTab.getUnitImage(1), new Rogue(null, Team.RED));
        fieldHalfSources.add(rogue);
        fieldHalfDnd.addSource(rogue);
        CellSource berserker = new CellSource(componentsManager.choiceTab.getUnitImage(2), new Berserker(null, Team.RED));
        fieldHalfSources.add(berserker);
        fieldHalfDnd.addSource(berserker);
        CellSource archer = new CellSource(componentsManager.choiceTab.getUnitImage(3), new Archer(null, Team.RED));
        fieldHalfDnd.addSource(archer);
        fieldHalfSources.add(archer);
        CellSource werewolf = new CellSource(componentsManager.choiceTab.getUnitImage(4), new WereWolf(null, Team.RED));
        fieldHalfDnd.addSource(werewolf);
        fieldHalfSources.add(werewolf);
        CellSource vampire = new CellSource(componentsManager.choiceTab.getUnitImage(5), new Vampire(null, Team.RED));
        fieldHalfDnd.addSource(vampire);
        fieldHalfSources.add(vampire);
        CellSource wizard = new CellSource(componentsManager.choiceTab.getUnitImage(6), new Wizard(null, Team.RED, new SpellBook()));
        fieldHalfDnd.addSource(wizard);
        fieldHalfSources.add(wizard);
        CellSource healer = new CellSource(componentsManager.choiceTab.getUnitImage(7), new Healer(null, Team.RED, new SpellBook()));
        fieldHalfDnd.addSource(healer);
        fieldHalfSources.add(healer);
        CellSource priest = new CellSource(componentsManager.choiceTab.getUnitImage(8), new Priest(null, Team.RED, new SpellBook()));
        fieldHalfDnd.addSource(priest);
        fieldHalfSources.add(priest);
        CellSource warlock = new CellSource(componentsManager.choiceTab.getUnitImage(9), new Warlock(null, Team.RED, new SpellBook()));
        fieldHalfDnd.addSource(warlock);
        fieldHalfSources.add(warlock);
        CellSource necromancer = new CellSource(componentsManager.choiceTab.getUnitImage(10), new Necromancer(null, Team.RED, new SpellBook()));
        fieldHalfDnd.addSource(necromancer);
        fieldHalfSources.add(necromancer);
        CellSource demon = new CellSource(componentsManager.choiceTab.getUnitImage(11), new Demon(null, Team.RED));
        fieldHalfDnd.addSource(demon);
        fieldHalfSources.add(demon);
        CellSource horse = new CellSource(componentsManager.choiceTab.getUnitImage(12), new Horse(null, Team.RED));
        fieldHalfDnd.addSource(horse);
        fieldHalfSources.add(horse);
    }

    public void removeDragNDropSources() {
        for (DragAndDrop.Source fieldHalfSource : fieldHalfSources) {
            fieldHalfDnd.removeSource(fieldHalfSource);
        }
    }

    public void addBlueTeamDragNDropTargets() {
        for (int rows = 0; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE / 2; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                CellTarget target = new CellTarget(componentsManager.fieldImg.getCellImage(rows, cols));
                fieldHalfTargets.add(target);
                fieldHalfDnd.addTarget(target);
            }
        }
    }

    public void addRedTeamDragNDropTargets() {
        for (int rows = Defaults.GAMEFIELD_CELLS_IN_SIDE / 2; rows < Defaults.GAMEFIELD_CELLS_IN_SIDE; rows++) {
            for (int cols = 0; cols < Defaults.GAMEFIELD_CELLS_IN_SIDE; cols++) {
                CellTarget target = new CellTarget(componentsManager.fieldImg.getCellImage(rows, cols));
                fieldHalfTargets.add(target);
                fieldHalfDnd.addTarget(target);
            }
        }
    }

    public void clearUnitMoveDragNDrop() {
        unitMoveDnd.clear();
    }
}
