package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.attacks.WereWolfAttack;
import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class WereWolfWolfState extends State {
    public WereWolfWolfState(Cell location, String team) {
        super( UnitName.WEREWOLF, team, UnitHp.WEREWOLF_WOLF, UnitHp.WEREWOLF_WOLF, UnitDmg.WEREWOLF_WOLF, UnitMoveDistance.WEREWOLF_WOLF, UnitAttackRatio.WEREWOLF_WOLF, UnitRole.REGULAR, location);
    }
}
