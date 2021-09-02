package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.NotImplementedException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;
import com.jdxarmy.back.interfaces.Observer;

import static java.lang.Math.abs;

public class Attack {
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            enemy.takeDamage(attacker.getState().getDmg());
            enemy.counterAttack(attacker);
        } else {
            throw new WrongCellException("Unit is too far to attack");
        }
    }

    public void counterAttack(Unit attacker, Unit enemy) throws UnitIsDeadException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            enemy.takeDamage(attacker.getState().getDmg() / 2);
        }
    }

    public void TransformSpecialAbility(Unit user) throws NotImplementedException, CantTransformUnitException { throw new NotImplementedException("not implemented"); }
    public void TransformEnemySpecialAbility(Unit enemy) throws NotImplementedException, CantTransformUnitException {   throw new NotImplementedException("not implemented"); }
    public void observeSpecialAbility(Observer attacker, Unit enemy) throws NotImplementedException, CantTransformUnitException {  throw new NotImplementedException("not implemented"); }
    public int[] SpawnSpecialAbility(Unit attacker, GameField field) throws WrongCellException, NotImplementedException {   throw new NotImplementedException("not implemented"); }
}
