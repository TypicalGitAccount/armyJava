package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.HealerMagicAttack;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.HealerState;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class Healer extends SpellCaster {
    public Healer(Cell location, String team, SpellBook book) {
        super(new HealerState(location, team, book), new Attack(), new HealerMagicAttack());
    }

    @Override
    public Unit getCopy() {
        return new Healer(this.state.getLocation(), this.state.getTeam(), new SpellBook());
    }
}
