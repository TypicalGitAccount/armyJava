package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class DemonState extends State {
    public DemonState(Cell location, String team) {
        super(UnitName.DEMON, team, UnitHp.SOLDIER, UnitHp.SOLDIER, UnitDmg.SOLDIER, UnitMoveDistance.SOLDIER, UnitAttackRatio.SOLDIER, UnitRole.UNDEAD, location);
    }
}
