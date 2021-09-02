package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;
import com.jdxarmy.back.interfaces.Observable;
import com.jdxarmy.back.interfaces.Observer;

import static java.lang.Math.abs;

public class NecromancerAttack extends Attack {
    @Override
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            enemy.takeDamage(attacker.getState().getDmg());
            enemy.counterAttack(attacker);
        } else {
            throw new WrongCellException("Unit's too far to attack");
        }
    }

    @Override
    public void observeSpecialAbility(Observer attacker, Unit enemy) throws CantTransformUnitException {
        if ( !enemy.getState().getIsObserved() ) {
            enemy.subscribe(attacker);
        } else {
            throw new CantTransformUnitException("Unit is already observed!");
        }
    }
}
