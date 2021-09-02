package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class BerserkerState extends State {
    public BerserkerState(Cell location, String team) {
        super(UnitName.BERSERKER, team, UnitHp.BERSERKER, UnitHp.BERSERKER, UnitDmg.BERSERKER, UnitMoveDistance.BERSERKER, UnitAttackRatio.BERSERKER, UnitRole.REGULAR, location);
    }
}
