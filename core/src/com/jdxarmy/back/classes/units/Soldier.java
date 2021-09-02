package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.SoldierAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.SoldierState;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.NotImplementedException;

public class Soldier extends Unit {
    public Soldier(Cell location, String team) {
        super(new SoldierState(location, team), new SoldierAttack());
    }

    @Override
    public Unit getCopy() {
        return new Soldier(this.getState().getLocation(), this.getState().getTeam());
    }

    @Override
    public void selfTransformSpecialAbility() throws NotImplementedException, CantTransformUnitException {
        super.selfTransformSpecialAbility();
    }
}
