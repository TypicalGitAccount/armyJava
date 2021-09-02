package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.MagicAttack;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitName;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Berserker;
import com.jdxarmy.back.classes.units.SpellCaster;
import org.junit.Assert;
import org.junit.Test;

public class BerserkerTest {
    private GameField field;
    private Berserker b;

    public BerserkerTest() {
        this.field = new GameField(16);
        this.b = new Berserker(this.field.getCell(0, 0), Team.BLUE);
    }

    @Test
    public void takeMagicDamageTest() {
        try {
            SpellCaster enemy = new SpellCaster(new MagicState(UnitName.SOLDIER, Team.BLUE, 100, 100, 10, 1, 1, UnitRole.FIGHT_MAGE, this.field.getCell(0, 1), new SpellBook()), new Attack(), new MagicAttack());
            enemy.chooseSpell(SpellName.FIREBALL);
            enemy.magicAttack(this.b);
            Assert.assertEquals(this.b.getState().getMaxHp(), this.b.getState().getHp(), 0.00001);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
