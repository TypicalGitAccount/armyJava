package com.jdxarmy.back.classes.gamefield;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.WrongCellException;

public class GameField {
    int side;
    int size;
    private Cell[][] cells;
    int unitsAmount;

    public GameField(int side) {
        this.unitsAmount = 0;
        this.side = side;
        this.size = side*side;

        this.cells = new Cell[side][side];
        for ( int x = 0; x < side; x++) {
            for ( int y = 0; y < side; y++ ) {
                this.cells[x][y] = new Cell(x, y);
            }
        }
    }

    public double getSize() { return this.size; }

    public double getSideSize() { return side; }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public int getUnitsAmount() { return this.unitsAmount; }

    public void occupyCell(int x, int y, Unit occupier) throws WrongCellException {
        if ( !cells[x][y].isOccupied() ) {
            cells[x][y].occupy(occupier);
            unitsAmount++;
        } else {
            throw new WrongCellException("Cell is occupied!");
        }
    }

    public void deOccupyCell(int x, int y) {
        if ( cells[x][y].isOccupied() ) {
            cells[x][y].deOccupy();
            unitsAmount--;
        }
    }

    public boolean isGameOver() {
        int blueTeamUnits = 0, redTeamUnits = 0;
        for ( int rows = 0; rows < side; rows++ ) {
            for ( int cols = 0; cols < side; cols++ ) {
                if ( cells[rows][cols].isOccupied() ) {
                    if  ( cells[rows][cols].getOccupier().getState().getTeam().equals(Team.BLUE) ) {
                        blueTeamUnits++;
                    } else {
                        redTeamUnits++;
                    }
                }
            }
        }

        return blueTeamUnits == 0 || redTeamUnits == 0;
    }
 }
