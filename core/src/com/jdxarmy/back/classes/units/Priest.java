package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.PriestAttack;
import com.jdxarmy.back.classes.attacks.PriestMagicAttack;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.PriestState;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class Priest extends SpellCaster {
    public Priest(Cell location, String team, SpellBook book) {
        super(new PriestState(location, team, book), new PriestAttack(), new PriestMagicAttack());
    }

    @Override
    public Unit getCopy() {
        return new Priest(this.state.getLocation(), this.state.getTeam(), new SpellBook());
    }
}
