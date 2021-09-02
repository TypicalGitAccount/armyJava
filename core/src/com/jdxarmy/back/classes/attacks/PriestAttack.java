package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;

import static java.lang.Math.abs;

public class PriestAttack extends Attack {
    @Override
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            if (enemy.getState().getRole() == UnitRole.UNDEAD) {
                enemy.takeDamage(attacker.getState().getDmg() * 2);
            } else {
                enemy.takeDamage(attacker.getState().getDmg());
            }
            enemy.counterAttack(attacker);
        } else {
            throw new WrongCellException("Unit's too far to attack");
        }
    }
}
