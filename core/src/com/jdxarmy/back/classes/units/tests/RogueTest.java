package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.units.Rogue;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import org.junit.Assert;
import org.junit.Test;

public class RogueTest {
    private Rogue r;
    private GameField field;

    public RogueTest() {
        this.field = new GameField(16);
        this.r = new Rogue(this.field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void counterAttackTest() {
        Soldier s = new Soldier(this.field.getCell(0, 1), Team.BLUE);
        double rHp = this.r.getState().getHp();
        double sHp = s.getState().getHp();

        try {
            r.attack(s);
            Assert.assertEquals(sHp, s.getState().getHp()+r.getState().getDmg(), 0.00001); //making sure Rogue attacks
            Assert.assertEquals(rHp, r.getState().getHp(), 0.00001); //making sure Rogue cant be counterattacked
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
