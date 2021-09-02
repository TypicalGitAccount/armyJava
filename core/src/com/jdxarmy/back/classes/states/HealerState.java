package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;

public class HealerState extends MagicState {
    public HealerState(Cell location, String team, SpellBook book) {
        super( UnitName.HEALER, team, UnitHp.HEALER, UnitHp.HEALER, UnitDmg.HEALER, UnitMoveDistance.HEALER, UnitAttackRatio.HEALER, UnitRole.SUPPORT_MAGE, location, book);
        try {
            this.spellInUse = book.getSpell(DefaultSpell.HEALER);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
