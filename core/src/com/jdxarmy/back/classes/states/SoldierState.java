package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class SoldierState extends State {
    public SoldierState(Cell location, String team) {
        super(UnitName.SOLDIER, team, UnitHp.SOLDIER, UnitHp.SOLDIER, UnitDmg.SOLDIER, UnitMoveDistance.SOLDIER, UnitAttackRatio.SOLDIER, UnitRole.REGULAR, location);
    }
}
