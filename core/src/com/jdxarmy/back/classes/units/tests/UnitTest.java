package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitName;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;
import org.junit.*;
import com.jdxarmy.back.classes.units.Unit;

public class UnitTest {
    private Unit u;
    private GameField field;

    public UnitTest() {
        this.field = new GameField(16);
        this.u = new Unit(new State(UnitName.SOLDIER, Team.BLUE,100, 100, 10, 2, 1, UnitRole.REGULAR, this.field.getCell(0, 0)), new Attack());
    }

    @Test
    public void moveTest() {
        try {
            this.u.move(this.field, 1, 0);
        } catch (WrongCellException ex) {
            System.out.println(ex.getMessage());
        }
        Assert.assertEquals(1, u.getState().getLocation().getX());
        Assert.assertEquals(0, u.getState().getLocation().getY());
        try {
            this.u.move(this.field, 1, 3);
            Assert.assertEquals(1, u.getState().getLocation().getX());
            Assert.assertEquals(0, u.getState().getLocation().getY());
        } catch (WrongCellException e) {
            System.out.println(e.getMessage());
        }

        try {
            this.u.move(this.field, 16, 16);
        } catch (WrongCellException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(1, u.getState().getLocation().getX());
        Assert.assertEquals(0, u.getState().getLocation().getY());

        try {
            this.u.move(field, 1, 2);
        } catch (WrongCellException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(1, u.getState().getLocation().getX());
        Assert.assertEquals(2, u.getState().getLocation().getY());
    }

    @Test
    public void takeDmgTest() {
        double initHp = u.getState().getHp();
        double dmg = 11.529;

        try {
            u.takeDamage(dmg);
        } catch ( UnitIsDeadException ex) {
            System.out.println(ex.getMessage());
        }

        double afterHp = u.getState().getHp();
        Assert.assertEquals(initHp, afterHp+dmg, 0.00001);
    }

    @Test
    public void attackTest() {
        Unit enemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE,100, 100, 10, 2, 1, UnitRole.REGULAR, this.field.getCell(0, 1)), new Attack());

        double uHp = this.u.getState().getHp();
        double enemyHp = enemy.getState().getHp();

        try {
            u.attack(enemy);
            Assert.assertEquals(enemy.getState().getHp()+this.u.getState().getDmg(), enemyHp, 0.00001);//u attacks enemy
            Assert.assertEquals(u.getState().getHp()+enemy.getState().getDmg()/2, uHp, 0.00001);//enemy counterattacks
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }

        //ensuring that enemy who's too far on field is not attacked
        Unit farEnemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE,100, 100, 10, 2, 1, UnitRole.REGULAR, this.field.getCell(0, 2)), new Attack());

        try {
            u.attack(farEnemy);
            Assert.assertEquals(farEnemy.getState().getMaxHp(), farEnemy.getState().getHp(), 0.00001);
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
