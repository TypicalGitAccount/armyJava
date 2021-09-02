package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.DefaultSpell;
import com.jdxarmy.back.classes.gamefield.Cell;
import com.jdxarmy.back.classes.spells.Spell;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class MagicState extends State {
    protected Spell spellInUse;
    protected SpellBook book;

    public MagicState(String name, String team, double hp, double maxHp, double dmg, int moveDistance, int attackRatio, String role, Cell location, SpellBook book) {
        super(name, team, hp, maxHp, dmg, moveDistance, attackRatio, role, location);
        this.book = book;
    }

    public MagicState(MagicState copy) {
        super(copy.name, copy.team, copy.hp, copy.maxHp, copy.dmg, copy.moveDistance, copy.attackRatio, copy.role, copy.location);
        this.book = new SpellBook();
    }

    public Spell getSpellInUse() { return this.spellInUse; }

    public void setSpellInUse(String spell) {
        this.spellInUse = book.getSpell(spell);
    }
}
