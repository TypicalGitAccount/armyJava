package com.jdxarmy.back.classes.units;

import com.jdxarmy.back.classes.attacks.Attack;
import com.jdxarmy.back.classes.attacks.MagicAttack;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.exceptions.NoSpellInUseException;
import com.jdxarmy.back.exceptions.UnitIsDeadException;
import com.jdxarmy.back.exceptions.WrongCellException;
import com.jdxarmy.back.exceptions.WrongSpellNameException;

public class SpellCaster extends Unit {
    protected MagicAttack magicAttack;

    public SpellCaster(MagicState state, Attack attack, MagicAttack magAttack) {
        super(state, attack);
        this.magicAttack = magAttack;
    }

    @Override
    public Unit getCopy() {
        return new SpellCaster(new MagicState((MagicState) this.state), this.attack, this.magicAttack);
    }

    public void chooseSpell(String spellName) throws WrongSpellNameException {
        ((MagicState)this.getState()).setSpellInUse(spellName);
    }

    public void magicAttack(Unit enemy) throws UnitIsDeadException, NoSpellInUseException, WrongCellException {
        this.magicAttack.magicAttack(this, enemy);
    }
}
