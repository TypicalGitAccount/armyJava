package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Healer;
import com.jdxarmy.back.classes.units.Unit;
import org.junit.Assert;
import org.junit.Test;

public class HealerTest {
    private GameField field;
    private Healer h;

    public HealerTest() {
        this.field = new GameField(16);
        this.h = new Healer(this.field.getCell(0, 0),  Team.BLUE, new SpellBook());
    }

    @Test
    public void magicAttackTest() {
        try {
            Unit enemy = new Unit(new State(UnitName.SOLDIER, Team.BLUE,100, 100, 10, 1, 1, UnitRole.REGULAR, this.field.getCell(0, 1)), new Attack());
            this.h.chooseSpell(SpellName.FIREBALL);
            h.magicAttack(enemy);

            Assert.assertEquals(enemy.getState().getMaxHp()-SpellDmg.FIREBALL/2, enemy.getState().getHp(), 000001);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
