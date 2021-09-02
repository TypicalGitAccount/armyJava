package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.WizardMagicAttack;
import com.jdxarmy.back.classes.constants.DefaultSpell;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.WizardState;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class Wizard extends SpellCaster  {
    public Wizard(Cell location, String team, SpellBook book) {
        super(new WizardState(location, team, book), new Attack(), new WizardMagicAttack());
    }

    @Override
    public Unit getCopy() {
        return new Wizard(this.state.getLocation(), this.state.getTeam(), new SpellBook());
    }
}
