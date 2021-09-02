package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;

import static java.lang.Math.abs;

public class RogueAttack extends Attack {
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            enemy.takeDamage(attacker.getState().getDmg());
        } else {
            throw new WrongCellException("Unit's too far to attack");
        }
    }
}
