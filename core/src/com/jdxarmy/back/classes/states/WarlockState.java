package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;

public class WarlockState extends MagicState {
    public WarlockState(Cell location, String team, SpellBook book) {
        super(UnitName.WARLOCK, team, UnitHp.WARLOCK, UnitHp.WARLOCK, UnitDmg.WARLOCK, UnitMoveDistance.WARLOCK, UnitAttackRatio.WARLOCK, UnitRole.FIGHT_MAGE, location, book);
        try {
            this.spellInUse = book.getSpell(DefaultSpell.WARLOCK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
