package com.jdxarmy.back.classes.spells;

import com.jdxarmy.back.classes.constants.SpellDmg;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.SpellRatio;
import com.jdxarmy.back.classes.constants.SpellType;

public class Heal extends Spell {
    public Heal() {
        super(SpellName.HEAL, SpellDmg.HEAL, SpellType.HEAL_SPELL, SpellRatio.HEAL);
    }
}
