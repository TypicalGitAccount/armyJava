package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class WereWolfHumanState extends State {
    public WereWolfHumanState(Cell location, String team) {
        super( UnitName.WEREWOLF, team, UnitHp.WEREWOLF_HUMAN, UnitHp.WEREWOLF_HUMAN, UnitDmg.WEREWOLF_HUMAN, UnitMoveDistance.WEREWOLF_HUMAN, UnitAttackRatio.WEREWOLF_HUMAN, UnitRole.REGULAR, location);
    }
}
