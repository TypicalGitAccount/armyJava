package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.BerserkerState;

public class Berserker extends Unit {
    public Berserker(Cell location, String team) {
        super(new BerserkerState(location, team), new Attack());
    }

    @Override
    public Unit getCopy() {
        return new Berserker(this.state.getLocation(), this.state.getTeam());
    }

    @Override
    public void takeMagicDamage(double dmg) {}
}
