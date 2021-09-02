package com.jdxarmy.back.classes.states.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitName;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Unit;
import org.junit.Assert;
import org.junit.Test;

public class StateTest {
    private Unit attacked;

    public StateTest() { this.attacked = new Unit(new State(UnitName.SOLDIER,  Team.BLUE, 100, 100, 10, 1, 1, UnitRole.REGULAR, new Cell(0, 0)), new Attack()); }

    @Test
    public void takeDmgTest() {
        try {
            int dmg = 10;
            attacked.takeDamage(dmg);
            Assert.assertEquals(attacked.getState().getMaxHp()-dmg, attacked.getState().getHp(), 0.00001);

            int heal = -10;
            attacked.takeDamage(heal);
            Assert.assertEquals(attacked.getState().getMaxHp(), attacked.getState().getHp(), 0.00001);

            attacked.takeDamage(attacked.getState().getMaxHp());
            Assert.assertEquals(0, attacked.getState().getHp(), 0.00001);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
