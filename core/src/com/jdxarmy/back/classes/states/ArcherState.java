package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class ArcherState extends State {
    public ArcherState(Cell location, String team) {
        super(UnitName.ARCHER, team, UnitHp.ARCHER, UnitHp.ARCHER, UnitDmg.ARCHER, UnitMoveDistance.ARCHER, UnitAttackRatio.INFINITE, UnitRole.REGULAR, location);
    }
}
