package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.classes.units.Wizard;
import org.junit.Assert;
import org.junit.Test;

public class WizardTest {
    private GameField field;
    private Wizard w;

    public WizardTest() {
        this.field = new GameField(16);
        this.w = new Wizard(this.field.getCell(0, 0), Team.BLUE, new SpellBook());
    }

    @Test
    public void magicAttackTest() {
        try {
            Unit enemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE,100, 100, 10, 1, 1, UnitRole.REGULAR, this.field.getCell(0, 1)), new Attack());
            enemy.takeDamage(50);
            double enemyHpBeforeAttack = enemy.getState().getHp();

            this.w.chooseSpell(SpellName.HEAL);
            w.magicAttack(enemy);

            Assert.assertEquals(enemyHpBeforeAttack-SpellDmg.HEAL/2, enemy.getState().getHp(), 0.00001);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
