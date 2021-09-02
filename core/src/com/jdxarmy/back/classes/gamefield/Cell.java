package com.jdxarmy.back.classes.gamefield;

import com.jdxarmy.back.classes.units.Unit;

public class Cell {
    private int x;
    private int y;
    private boolean isOccuipied;
    private Unit occupier;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccuipied = false;
        this.occupier = null;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public boolean isOccupied() { return this.isOccuipied; }

    public Unit getOccupier() { return this.occupier; }

    public void occupy(Unit occupier) {
        if ( !isOccuipied ) {
            this.isOccuipied = true;
            this.occupier = occupier;
            occupier.setLocation(this);
        }
    }

    public void deOccupy() {
        if ( occupier != null ) {
            this.isOccuipied = false;
            occupier.setLocation(null);
            this.occupier = null;
        }
    }
}
