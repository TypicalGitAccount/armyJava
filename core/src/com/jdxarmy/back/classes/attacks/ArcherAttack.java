package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;

public class ArcherAttack extends Attack {
    @Override
    public void attack(Unit attacker, Unit enemy) throws UnitIsDeadException, WrongCellException {
        enemy.takeDamage(attacker.getState().getDmg());
        enemy.counterAttack(attacker);
    }

    @Override
    public void counterAttack(Unit attacker, Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(attacker.getState().getDmg() / 2);
    }
}

