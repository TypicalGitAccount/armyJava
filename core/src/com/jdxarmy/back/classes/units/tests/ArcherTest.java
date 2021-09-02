package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.units.Archer;
import com.jdxarmy.back.classes.units.Soldier;
import org.junit.Assert;
import org.junit.Test;

public class ArcherTest {
    private GameField field;
    private Archer a;

    public ArcherTest() {
        this.field = new GameField(16);
        this.a = new Archer(field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void attackTest() {
        try {
            Soldier enemy = new Soldier(field.getCell(5, 5), Team.BLUE);

            this.a.attack(enemy);
            //ensuring archer can attack units from any distance
            Assert.assertEquals(enemy.getState().getMaxHp()-this.a.getState().getDmg(), enemy.getState().getHp(), 0.00001);
            Assert.assertEquals(this.a.getState().getMaxHp(), this.a.getState().getHp(), 0.00001);

            Soldier closeEnemy = new Soldier(field.getCell(0, 1), Team.BLUE);
            //ensuring that units that are close enough can counterattack archer
            this.a.attack(closeEnemy);
            Assert.assertEquals(closeEnemy.getState().getMaxHp()-this.a.getState().getDmg(), closeEnemy.getState().getHp(), 0.00001);
            Assert.assertEquals(this.a.getState().getMaxHp()-closeEnemy.getState().getDmg()/2, this.a.getState().getHp(), 0.00001);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
