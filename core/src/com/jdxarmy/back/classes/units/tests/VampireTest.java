package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitName;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.states.VampireState;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.classes.units.Vampire;
import com.jdxarmy.back.classes.units.WereWolf;
import com.jdxarmy.back.exceptions.NotImplementedException;
import org.junit.Assert;
import org.junit.Test;

public class VampireTest {
    private GameField field;
    private Vampire v;

    public VampireTest() {
        this.field = new GameField(4);
        this.v = new Vampire(this.field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void attackTest() {
        try {
            Unit enemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE, 100, 100, 10, 1, 1, UnitRole.REGULAR, this.field.getCell(0, 1)), new Attack());
            v.attack(enemy);

            Assert.assertEquals(enemy.getState().getMaxHp()-v.getState().getDmg(), enemy.getState().getHp(), 0.00001);
            //ensuring enemy is attacked
            Assert.assertEquals(v.getState().getMaxHp()-enemy.getState().getDmg()/2, v.getState().getHp(), 0.00001);
            //ensuring vampire is counterattacked after he gains Soldiers hp

            double VhpBeforeAttack = v.getState().getHp();
            double enemyHpBeforeAttack = enemy.getState().getHp();
            v.attack(enemy);
            Assert.assertEquals(VhpBeforeAttack+enemyHpBeforeAttack*0.05-enemy.getState().getDmg()/2, v.getState().getHp(), 0.00001);
            //ensuring vampire gains 5 % of enemy's hp before physical attack
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void counterAttackTest() {
        try {
            Unit enemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE, 100, 100, 10, 1, 1, UnitRole.REGULAR, this.field.getCell(0, 1)), new Attack());
            v.takeDamage(17.5);
            double vHpBeforeAttack = v.getState().getHp();
            double enemyHpBeforeAttack = enemy.getState().getHp();
            enemy.attack(this.v);

            Assert.assertEquals(vHpBeforeAttack-enemy.getState().getDmg()+enemyHpBeforeAttack*0.05, v.getState().getHp(), 0.0001);
        //ensuring vampire gains 5% of enemy's hp before physical counterattack
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void specAbilityTest() {
        try {
            Soldier enemy = new Soldier(this.field.getCell(0, 1), Team.BLUE);
            Soldier enemy2 = new Soldier(this.field.getCell(1, 0), Team.BLUE);
            WereWolf exept = new WereWolf(this.field.getCell(1, 1), Team.BLUE);
            this.v.transformEnemySpecialAbility(enemy);
            enemy.transformEnemySpecialAbility(enemy2);
            enemy2.transformEnemySpecialAbility(exept);

            Assert.assertEquals(true, enemy.getState() instanceof VampireState);
            Assert.assertEquals(true, enemy2.getState() instanceof VampireState);
            Assert.assertEquals(false, exept.getState() instanceof VampireState);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
