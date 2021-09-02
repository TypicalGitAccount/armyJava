package com.jdxarmy.back.classes.units.tests;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.units.Demon;
import com.jdxarmy.back.classes.units.Warlock;
import com.jdxarmy.back.exceptions.WrongCellException;
import org.junit.Assert;
import org.junit.Test;

public class WarlockTest {
    private GameField field;
    private Warlock w;

    public WarlockTest() {
        this.field = new GameField(16);
        this.w = new Warlock(field.getCell(1, 1), Team.BLUE, new SpellBook());
    }

    @Test
    public void spawnDemonsTest() {
        try {

            w.spawnSpecialAbility(field);
            Assert.assertEquals(true, field.getCell(0, 1).isOccupied());
            Assert.assertEquals(true, field.getCell(0, 1).getOccupier() instanceof Demon );

            w.spawnSpecialAbility(field);
            Assert.assertEquals(true, field.getCell(2, 1).isOccupied());
            Assert.assertEquals(true, field.getCell(2, 1).getOccupier() instanceof Demon );

            w.spawnSpecialAbility(field);
            Assert.assertEquals(true, field.getCell(1, 0).isOccupied());
            Assert.assertEquals(true, field.getCell(1, 0).getOccupier() instanceof Demon );

            w.spawnSpecialAbility(field);
            Assert.assertEquals(true, field.getCell(1, 2).isOccupied());
            Assert.assertEquals(true, field.getCell(1, 2).getOccupier() instanceof Demon );

            try {
                w.spawnSpecialAbility(field);
            } catch (WrongCellException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
