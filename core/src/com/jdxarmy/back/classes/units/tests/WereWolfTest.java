package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.WereWolfAttack;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.states.WereWolfHumanState;
import com.jdxarmy.back.classes.states.WereWolfWolfState;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.classes.units.Vampire;
import com.jdxarmy.back.classes.units.WereWolf;
import org.junit.Assert;
import org.junit.Test;

public class WereWolfTest {
    private GameField field;
    private WereWolf w;

    public WereWolfTest() {
        this.field = new GameField(16);
        this.w = new WereWolf(this.field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void specialAbilityTest() {
        try {
            Soldier enemy = new Soldier(this.field.getCell(0, 1), Team.BLUE);
            Soldier enemy2 = new Soldier(this.field.getCell(1, 1), Team.BLUE);
            Vampire exept = new Vampire(this.field.getCell(1, 0), Team.BLUE);

            this.w.transformEnemySpecialAbility(enemy);
            enemy.transformEnemySpecialAbility(enemy2);
            enemy2.transformEnemySpecialAbility(exept);

            Assert.assertTrue(enemy.getAttack() instanceof WereWolfAttack);
            Assert.assertTrue(enemy.getState() instanceof WereWolfHumanState);

            Assert.assertTrue( enemy2.getAttack() instanceof WereWolfAttack);
            Assert.assertTrue( enemy2.getState() instanceof WereWolfHumanState);

            Assert.assertFalse( exept.getAttack() instanceof WereWolfAttack);
            Assert.assertFalse( exept.getState() instanceof WereWolfHumanState);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void transformTest() {
        try {
            State before = this.w.getState();
            this.w.selfTransformSpecialAbility();

            Assert.assertTrue(before instanceof WereWolfHumanState);
            Assert.assertTrue( this.w.getState() instanceof WereWolfWolfState);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
