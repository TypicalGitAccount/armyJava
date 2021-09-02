package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.units.Necromancer;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.interfaces.Observable;
import org.junit.Assert;
import org.junit.Test;

public class NecromancerTest {
    private GameField field;
    private Necromancer n;

    public NecromancerTest() {
        this.field = new GameField(16);
        this.n = new Necromancer(this.field.getCell(0, 0), Team.BLUE, new SpellBook());
    }

    @Test
    public void attackTest() {
        Soldier s = new Soldier(this.field.getCell(0, 1), Team.BLUE);

        try {
            this.n.observeSpecialAbility(n, s);
            Assert.assertTrue(s.getState().getIsObserved());
            Assert.assertEquals(s.getState().getObserver(), n);
            n.attack(s);
            try {
                s.takeDamage(s.getState().getMaxHp());
            } catch (UnitIsDeadException ex) {
                System.out.println(ex.getMessage());
            }

            if ( n.getState().getMaxHp()-s.getState().getDmg()/2+s.getState().getMaxHp()*0.2 > n.getState().getMaxHp() ) {
                Assert.assertEquals(n.getState().getMaxHp(), n.getState().getHp(), 0.00001);
            } else {
                Assert.assertEquals(n.getState().getMaxHp()-s.getState().getDmg()/2+s.getState().getMaxHp()*0.2, n.getState().getHp(), 0.00001);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
