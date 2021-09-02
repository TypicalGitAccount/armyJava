package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.ArcherAttack;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.states.ArcherState;
import com.jdxarmy.back.classes.units.Soldier;
import org.junit.Assert;
import org.junit.Test;

public class SoldierTest {
    private GameField field;
    private Soldier s;

    public SoldierTest() {
        this.field = new GameField(4);
        this.s = new Soldier(field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void transformToArcherTest() {
        try {
            this.s.selfTransformSpecialAbility();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Assert.assertTrue( s.getState() instanceof ArcherState);
        Assert.assertTrue( s.getAttack() instanceof ArcherAttack);
    }
}
