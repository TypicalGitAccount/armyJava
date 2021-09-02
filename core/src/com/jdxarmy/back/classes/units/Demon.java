package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.DemonState;

public class Demon extends Unit {
    public Demon(Cell location, String team) {
        super(new DemonState(location, team), new Attack());
    }

    @Override
    public Unit getCopy() {
        return new Demon(this.state.getLocation(), this.state.getTeam());
    }
}
