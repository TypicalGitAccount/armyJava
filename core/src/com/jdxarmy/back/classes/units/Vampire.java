package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.VampireAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.VampireState;

public class Vampire extends Unit {
    public Vampire(Cell location, String team) {
        super(new VampireState(location, team), new VampireAttack());
    }

    @Override
    public Unit getCopy() {
        return new Vampire(this.state.getLocation(), this.state.getTeam());
    }
}
