package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.ArcherAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.ArcherState;

public class Archer extends Unit {
    public Archer(Cell location, String team) {
        super(new ArcherState(location, team), new ArcherAttack());
    }

    @Override
    public Unit getCopy() {
        return new Archer(this.state.getLocation(), this.state.getTeam());
    }
}
