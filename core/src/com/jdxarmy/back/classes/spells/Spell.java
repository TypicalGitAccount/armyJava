package com.jdxarmy.back.classes.spells;

import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.UnitIsDeadException;

public class Spell {
    private double dmg;
    private String spellType;
    private String name;
    private int spellRatio;

    public Spell(String spellName, double dmg, String spellType, int SpellRatio) {
        this.name = spellName;
        this.dmg = dmg;
        this.spellType = spellType;
        this.spellRatio = SpellRatio;
    }

    public String getSpellType() {
        return spellType;
    }

    public String getName() {
        return this.name;
    }

    public double getDmg() {
        return this.dmg;
    }

    public int getSpellRatio() { return this.spellRatio; }

    public void use(Unit enemy, double buff) throws UnitIsDeadException {
        enemy.takeMagicDamage(this.dmg+buff);
    }
}
