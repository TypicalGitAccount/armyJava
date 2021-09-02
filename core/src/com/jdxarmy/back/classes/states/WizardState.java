package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;

public class WizardState extends MagicState {
    public  WizardState(Cell location, String team, SpellBook book) {
        super( UnitName.WIZARD, team, UnitHp.WIZARD, UnitHp.WIZARD, UnitDmg.WIZARD, UnitMoveDistance.WIZARD, UnitAttackRatio.WIZARD, UnitRole.FIGHT_MAGE, location, book);
        try {
            this.spellInUse = book.getSpell(DefaultSpell.WIZARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
