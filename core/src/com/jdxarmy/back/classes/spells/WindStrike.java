package com.jdxarmy.back.classes.spells;

import com.jdxarmy.back.classes.constants.SpellDmg;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.SpellRatio;
import com.jdxarmy.back.classes.constants.SpellType;

public class WindStrike extends Spell {
    public WindStrike() {
        super(SpellName.WINDSTRIKE, SpellDmg.WINDSTRIKE, SpellType.FIGHT_SPELL, SpellRatio.WINDSTRIKE);
    }
}
