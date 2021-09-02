package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.HorseState;

public class Horse extends Unit {
    public Horse(Cell location, String team) {
        super(new HorseState(location, team), new Attack());
    }

    @Override
    public Unit getCopy() {
        return new Horse(this.state.getLocation(), this.state.getTeam());
    }
}
