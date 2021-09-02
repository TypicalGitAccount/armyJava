package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.WereWolfAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.WereWolfHumanState;
import com.jdxarmy.back.classes.states.WereWolfWolfState;

public class WereWolf extends Unit {
    public WereWolf(Cell location, String team) {
        super(new WereWolfHumanState(location, team), new WereWolfAttack());
    }

    @Override
    public Unit getCopy() {
        return new WereWolf(this.state.getLocation(), this.state.getTeam());
    }
}
