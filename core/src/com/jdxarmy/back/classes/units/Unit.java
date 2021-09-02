package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.NotImplementedException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;
import com.jdxarmy.back.interfaces.Observer;

import static java.lang.Math.abs;

public class Unit {
    protected State state;
    protected Attack attack;

    public Unit(State state, Attack attack) {
        this.state = state;
        this.attack = attack;
    }

    public Unit(Unit copy)  {
        this.state = new State(copy.state);
        this.attack = new Attack();
    }

    public Unit getCopy() {
        return new Unit(this);
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Attack getAttack() {
        return this.attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public void setLocation(Cell location) {
        this.getState().setLocation(location);
    }

    public void takeDamage(double dmg) throws UnitIsDeadException {
        this.state.takeDmg(dmg, this);
    }

    public void takeMagicDamage(double dmg) throws UnitIsDeadException {
        this.takeDamage(dmg);
    }

    public void heal(double hp) {
        this.state.heal(hp);
    }

    public void attack(Unit enemy) throws UnitIsDeadException, WrongCellException {
        this.attack.attack(this, enemy);
    }

    public void subscribe(Observer subscriber) {
        this.state.subscribe(subscriber, this);
    }

    public void counterAttack(Unit enemy) throws UnitIsDeadException {
        this.attack.counterAttack(this, enemy);
    }

    public void selfTransformSpecialAbility() throws NotImplementedException, CantTransformUnitException {
        this.attack.TransformSpecialAbility(this);
    }

    public void transformEnemySpecialAbility(Unit enemy) throws NotImplementedException, CantTransformUnitException {
        this.attack.TransformEnemySpecialAbility(enemy);
    }

    public void observeSpecialAbility(Observer attacker, Unit enemy) throws NotImplementedException, CantTransformUnitException {
        this.attack.observeSpecialAbility(attacker, enemy);
    }

    public int[] spawnSpecialAbility(GameField field) throws WrongCellException, NotImplementedException {
        return this.attack.SpawnSpecialAbility(this, field);
    }

    public void move(GameField field, int x, int y) throws WrongCellException {
        if ( x*y >= field.getSize() || x < 0 || y < 0 ) {
            throw new WrongCellException("Wrong cell coordinates");
        } else if ( abs(x-this.state.getLocation().getX()) > this.state.getMoveDistance() || abs(y-this.state.getLocation().getY()) > this.state.getMoveDistance()) {
            throw new WrongCellException("trying to move too far");
        } else {
            this.getState().getLocation().deOccupy();
            field.getCell(x, y).occupy(this);
        }
    }
}
