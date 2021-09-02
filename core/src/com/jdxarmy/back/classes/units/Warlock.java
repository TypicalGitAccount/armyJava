package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.MagicAttack;
import com.jdxarmy.back.classes.attacks.WarlockAttack;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.WarlockState;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class Warlock extends SpellCaster {
    public Warlock(Cell location, String team, SpellBook book) {
        super(new WarlockState(location, team, book), new WarlockAttack(), new MagicAttack());
    }

    @Override
    public Unit getCopy() {
        return new Warlock(this.state.getLocation(), this.state.getTeam(), new SpellBook());
    }
}
