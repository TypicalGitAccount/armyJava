package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.interfaces.Observable;

public class State extends Observable {
    protected String name;
    protected String team;
    protected double maxHp;
    protected double hp;
    protected double dmg;
    protected String role;
    protected int moveDistance;
    protected int attackRatio;
    protected Cell location;
    protected boolean isObserved;
    protected Unit observer;

    public State(String name, String team, double hp, double maxHp, double dmg, int moveDistance, int attackRatio, String role, Cell location) {
        this.name = name;
        this.team = team;
        this.maxHp = maxHp;
        this.hp = hp;
        this.dmg = dmg;
        this.role = role;
        this.moveDistance = moveDistance;
        this.attackRatio = attackRatio;
        this.isObserved = false;
        this.observer = null;
        this.location = location;
    }

    public State(State copy) {
        this.name = copy.name;
        this.team = copy.team;
        this.maxHp = copy.maxHp;
        this.hp = copy.hp;
        this.dmg = copy.dmg;
        this.role = copy.role;
        this.moveDistance = copy.moveDistance;
        this.attackRatio = copy.attackRatio;
        this.isObserved = copy.isObserved;
        this.observer = copy.observer;
        this.location = copy.location;
    }

    public String getName() { return this.name; }

    public String getTeam() { return this.team; }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getMaxHp() {
        return this.maxHp;
    }

    public double getHp() {
        return this.hp;
    }

    public double getDmg() {
        return this.dmg;
    }

    public String getRole() { return this.role; }

    public int getMoveDistance() { return this.moveDistance; }

    public int getAttackRatio() { return this.attackRatio; }

    public Cell getLocation() { return this.location; }

    public void setLocation(Cell location) { this.location =  location; }

    public boolean getIsObserved() { return this.isObserved; }

    public Unit getObserver() {
        return this.observer;
    }

    public void setObserver(Unit observer) {
        this.observer = observer;
    }

    public void setIsObserved(boolean val) { this.isObserved = val; }

    public void heal(double hp) {
        if ( this.hp + hp > maxHp ) {
            this.hp = maxHp;
        } else {
            this.hp += hp;
        }
    }

    public void takeDmg(double dmg, Unit dmgReceiver) throws UnitIsDeadException {
        if ( (this.hp-dmg) <= 0 ) {
            notifyObservers(dmgReceiver);
            throw new UnitIsDeadException("Unit is dead", this.name);
        } else if ( this.hp-dmg > this.maxHp ) {
            this.hp = this.maxHp;
        } else {
            this.hp -= dmg;
        }
    }
}
