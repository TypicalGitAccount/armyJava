package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;

public class PriestState extends MagicState {
    public PriestState(Cell location, String team, SpellBook book) {
        super(UnitName.PRIEST, team,  UnitHp.PRIEST, UnitHp.PRIEST, UnitDmg.PRIEST, UnitMoveDistance.PRIEST, UnitAttackRatio.PRIEST, UnitRole.SUPPORT_MAGE, location, book);
        try {
            this.spellInUse = book.getSpell(DefaultSpell.PRIEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
