package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class HorseState extends State {
    public HorseState(Cell location, String team) {
        super(UnitName.HORSE, team, UnitHp.HORSE, UnitHp.HORSE, UnitDmg.HORSE, UnitMoveDistance.HORSE, UnitAttackRatio.HORSE, UnitRole.MOUNTABLE, location);
    }
}
