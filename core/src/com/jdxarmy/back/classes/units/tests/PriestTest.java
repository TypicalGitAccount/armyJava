package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.constants.SpellDmg;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitDmg;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.VampireState;
import com.jdxarmy.back.classes.units.Priest;
import com.jdxarmy.back.classes.units.Soldier;
import com.jdxarmy.back.classes.units.Vampire;
import org.junit.Assert;
import org.junit.Test;

public class PriestTest {
    private GameField field;
    private Priest p;

    public PriestTest() {
        this.field = new GameField(16);
        this.p = new Priest(this.field.getCell(0, 0), Team.BLUE, new SpellBook());
    }

    @Test
    public void priestAttackTest() {
        try {
            Soldier s = new Soldier(this.field.getCell(0, 1),  Team.BLUE);
            Vampire v = new Vampire(this.field.getCell(1, 0), Team.BLUE);
            //ensuring magic attack with fight spell deals half damage
            this.p.chooseSpell(SpellName.FIREBALL);
            p.magicAttack(s);
            Assert.assertEquals(s.getState().getMaxHp()-SpellDmg.FIREBALL/2, s.getState().getHp(), 0.00001);

//            ensuring physical and magic attack on undeads deal double damage
            double priestHpBeforeAttack = this.p.getState().getHp();
            p.attack(v);
//            healer attacks vampire with double dmg, vampire counterattacks and gains 5 % of healer's hp
            Assert.assertEquals(v.getState().getMaxHp()-UnitDmg.HEALER*2+priestHpBeforeAttack*0.05, v.getState().getHp(), 0.00001);
            v.setState(new VampireState(v.getState().getLocation(), Team.BLUE));

            p.chooseSpell(SpellName.THUNDERSTRIKE);
            p.magicAttack(v);
            Assert.assertEquals(v.getState().getMaxHp()- SpellDmg.THUNDERSTRIKE*2, v.getState().getHp(), 0.00001);
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
