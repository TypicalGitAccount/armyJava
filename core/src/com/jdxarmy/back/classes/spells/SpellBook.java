package com.jdxarmy.back.classes.spells;

import java.util.TreeMap;

public class SpellBook {
    private TreeMap<String, Spell> book;

    public SpellBook() {
        this.book = new TreeMap<String, Spell>();
        Spell f = new FireBall();
        book.put(f.getName(), f);
        Spell w = new WaterBall();
        book.put(w.getName(), w);
        Spell ws = new WindStrike();
        book.put(ws.getName(), ws);
        Spell ts = new ThunderStrike();
        book.put(ts.getName(), ts);
        Spell h = new Heal();
        book.put(h.getName(), h);
    }

    public Spell getSpell(String spellName){
        return this.book.get(spellName);
    }
}
