package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.SpellBook;

public class NecromancerState extends MagicState {
    public NecromancerState(Cell location, String team, SpellBook book) {
        super(UnitName.NECROMANCER, team, UnitHp.NECROMANCER, UnitHp.NECROMANCER, UnitDmg.NECROMANCER, UnitMoveDistance.NECROMANCER, UnitAttackRatio.NECROMANCER, UnitRole.FIGHT_MAGE, location, book);
        try {
            this.spellInUse = book.getSpell(DefaultSpell.NECROMANCER);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
