package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.constants.SpellType;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.NoSpellInUseException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;

public class WizardMagicAttack extends MagicAttack {
    @Override
    public void magicAttack(SpellCaster attacker, Unit enemy) throws UnitIsDeadException, NoSpellInUseException {
        if ( ((MagicState)attacker.getState()).getSpellInUse() == null ) {
            throw new NoSpellInUseException("No spell in use");
        }

        double buff = 0;
        if (((MagicState)attacker.getState()).getSpellInUse().getSpellType() == SpellType.HEAL_SPELL ) {
            buff -= ((MagicState)attacker.getState()).getSpellInUse().getDmg()/2;
        }

        ((MagicState)attacker.getState()).getSpellInUse().use(enemy, buff);
    }
}
