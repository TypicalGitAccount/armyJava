package com.jdxarmy.back.classes.spells;

import com.jdxarmy.back.classes.constants.SpellDmg;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.SpellRatio;
import com.jdxarmy.back.classes.constants.SpellType;

public class WaterBall extends Spell {
    public WaterBall () {
        super(SpellName.WATERBALL, SpellDmg.WATERBALL, SpellType.FIGHT_SPELL, SpellRatio.WATERBALL);
    }
}
