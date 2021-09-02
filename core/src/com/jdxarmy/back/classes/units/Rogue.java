package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.RogueAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.RogueState;

public class Rogue extends Unit {
    public Rogue (Cell location, String team) {
        super(new RogueState(location, team), new RogueAttack());
    }

    @Override
    public Unit getCopy() {
        return new Rogue(this.state.getLocation(), this.state.getTeam());
    }
}
