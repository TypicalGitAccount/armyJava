package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.WrongCellException;

public class CellImage extends Image {
    GameField field;
    int cellX;
    int cellY;

    public CellImage(String filepath, GameField field, int x, int y) {
        super(new Texture(filepath));
        this.field = field;
        this.cellX = x;
        this.cellY = y;
    }

    public GameField getField() { return field; }

    public Cell getCell() {
        return field.getCell(cellX, cellY);
    }

    public int getCellX() { return cellX; }

    public int getCellY() { return cellY; }

    public boolean isOccupied() { return field.getCell(cellX, cellY).isOccupied(); }

    public Unit getOccupier() {
        return field.getCell(cellX, cellY).getOccupier();
    }

    public void occupy(Unit occupier) throws WrongCellException {
        field.occupyCell(cellX, cellY, occupier);
    }

    public void deOccupy() {
        field.deOccupyCell(cellX, cellY);
    }

    public void moveOccupier(CellImage moveTo) throws WrongCellException {
        getOccupier().move(field, moveTo.cellX, moveTo.cellY);
        moveTo.setDrawable(getDrawable());
        this.setDrawable(new Image(new Texture("sprites/cell.png")).getDrawable());
    }
}
