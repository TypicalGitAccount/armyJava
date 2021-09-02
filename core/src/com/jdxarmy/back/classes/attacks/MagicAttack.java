package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.NoSpellInUseException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;

import static java.lang.Math.abs;

public class MagicAttack {
    public void magicAttack(SpellCaster attacker, Unit enemy) throws UnitIsDeadException, NoSpellInUseException, WrongCellException {
        if ( ((MagicState)attacker.getState()).getSpellInUse() == null ) {
            throw new NoSpellInUseException("No spell in use");
        }
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= ((MagicState)attacker.getState()).getSpellInUse().getSpellRatio() ) {
            ((MagicState)attacker.getState()).getSpellInUse().use(enemy, 0);
        } else {
            throw new WrongCellException("Spell ratio is too short");
        }
    }
}
