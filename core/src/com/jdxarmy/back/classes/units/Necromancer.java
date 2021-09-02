package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.MagicAttack;
import com.jdxarmy.back.classes.attacks.NecromancerAttack;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.NecromancerState;
import com.jdxarmy.back.interfaces.Observer;

public class Necromancer extends SpellCaster implements Observer {
    public Necromancer(Cell location, String team, SpellBook book) {
        super(new NecromancerState(location, team, book), new NecromancerAttack(), new MagicAttack());
    }

    @Override
    public Unit getCopy() {
        return new Necromancer(this.state.getLocation(), this.state.getTeam(), new SpellBook());
    }

    @Override
    public void update(Unit observable) {
        heal(observable.getState().getMaxHp()*0.2);
    }
}
