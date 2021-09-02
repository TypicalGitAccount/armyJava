package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.states.VampireState;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.classes.units.WereWolf;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;

import static java.lang.Math.abs;

public class VampireAttack extends Attack {
    @Override
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            attacker.takeDamage(-(enemy.getState().getHp() * 0.05));
            enemy.takeDamage(attacker.getState().getDmg());
            enemy.counterAttack(attacker);
        } else {
            throw new WrongCellException("Unit's too far to attack");
        }
    }

    @Override
    public void counterAttack(Unit attacker, Unit enemy) throws UnitIsDeadException {
        if ( abs((attacker.getState().getLocation().getX()-enemy.getState().getLocation().getX())+abs(attacker.getState().getLocation().getY()-enemy.getState().getLocation().getY()))
                <= attacker.getState().getAttackRatio() ) {
            attacker.takeDamage(-(enemy.getState().getHp() * 0.05));
            enemy.takeDamage(attacker.getState().getDmg() / 2);
        }
    }

    @Override
    public void TransformEnemySpecialAbility(Unit enemy) throws CantTransformUnitException {
        if (!(enemy instanceof WereWolf)) {
            String teamToJoin;
            if ( enemy.getState().getTeam().equals(Team.BLUE) ) {
                teamToJoin = Team.RED;
            } else {
                teamToJoin = Team.BLUE;
            }
            enemy.setState(new VampireState(enemy.getState().getLocation(), teamToJoin));
            enemy.setAttack(new VampireAttack());
        } else if (enemy instanceof WereWolf ) {
            throw new CantTransformUnitException("Can't bite a werewolf!");
        } else {
                throw new CantTransformUnitException(enemy.getState().getName()+" was already biten!");
        }
    }
}
