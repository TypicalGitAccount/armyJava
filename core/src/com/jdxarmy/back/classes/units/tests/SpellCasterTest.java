package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.MagicAttack;
import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.back.exceptions.WrongSpellNameException;
import org.junit.Assert;
import org.junit.Test;

public class SpellCasterTest {
    private GameField field;
    private SpellCaster sc;

    public SpellCasterTest() {
        this.field = new GameField(16);
        this.sc = new SpellCaster(new MagicState(UnitName.SOLDIER, Team.BLUE, 100, 100, 10, 1, 1, UnitRole.FIGHT_MAGE, field.getCell(0, 0), new SpellBook()), new Attack(), new MagicAttack());
    }

    @Test
    public void chooseSpellTest() {
        try {
            this.sc.chooseSpell(SpellName.FIREBALL);
        } catch (WrongSpellNameException ex) {
            System.out.println(ex.getMessage());
        }

        Assert.assertEquals(SpellName.FIREBALL, ((MagicState)sc.getState()).getSpellInUse().getName());
    }

    @Test
    public void magicAttackTest() {
        Soldier enemy = new Soldier(this.field.getCell(0, 1), Team.BLUE);

        try {                        //ensuring that magic attack is not used before chosing spell
            this.sc.magicAttack(enemy);
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
        try {
            sc.chooseSpell(SpellName.FIREBALL);
        } catch (WrongSpellNameException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            this.sc.magicAttack(enemy);
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }

        Assert.assertEquals(UnitHp.SOLDIER-SpellDmg.FIREBALL, enemy.getState().getHp(), 0.00001); //ensuring magic attack

        //ensuring enemy that's too far on field isn't attacked with spell
        Soldier tooFarEnemy = new Soldier(this.field.getCell(0, 6), Team.BLUE);
        try {
            this.sc.magicAttack(tooFarEnemy);
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
        Assert.assertEquals(tooFarEnemy.getState().getMaxHp(), tooFarEnemy.getState().getHp(), 0.00001);
    }
}
