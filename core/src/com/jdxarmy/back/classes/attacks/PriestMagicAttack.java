package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.constants.SpellType;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.NoSpellInUseException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;

public class PriestMagicAttack extends MagicAttack {
    @Override
    public void magicAttack(SpellCaster attacker, Unit enemy) throws UnitIsDeadException, NoSpellInUseException {
        if ( ((MagicState)attacker.getState()).getSpellInUse() == null ) {
            throw new NoSpellInUseException("No spell in use");
        }

        double buff = 0;
        if ( enemy.getState().getRole() == UnitRole.UNDEAD ) {
            buff += ((MagicState)attacker.getState()).getSpellInUse().getDmg();
        } else if ( ((MagicState)attacker.getState()).getSpellInUse().getSpellType() == SpellType.FIGHT_SPELL ) {
            buff -= ((MagicState)attacker.getState()).getSpellInUse().getDmg()/2;
        }

        ((MagicState)attacker.getState()).getSpellInUse().use(enemy, buff);
    }
}
