package com.jdxarmy.back.classes.spells;

import com.jdxarmy.back.classes.constants.SpellDmg;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.SpellRatio;
import com.jdxarmy.back.classes.constants.SpellType;

public class FireBall extends Spell {
    public FireBall() {
        super(SpellName.FIREBALL, SpellDmg.FIREBALL, SpellType.FIGHT_SPELL, SpellRatio.FIREBALL);
    }
}
