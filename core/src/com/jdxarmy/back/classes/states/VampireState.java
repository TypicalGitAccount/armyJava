package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class VampireState extends State {
    public VampireState(Cell location, String team) {
        super(UnitName.VAMPIRE, team, UnitHp.VAMPIRE, UnitHp.VAMPIRE, UnitDmg.VAMPIRE, UnitMoveDistance.VAMPIRE, UnitAttackRatio.VAMPIRE, UnitRole.UNDEAD, location);
    }
}
