package com.jdxarmy.back.classes.states;

import com.jdxarmy.back.classes.constants.*;
import com.jdxarmy.back.classes.gamefield.Cell;

public class RogueState extends State {
    public RogueState(Cell location, String team) {
        super(UnitName.ROGUE , team, UnitHp.ROGUE, UnitHp.ROGUE, UnitDmg.ROGUE, UnitMoveDistance.ROGUE, UnitAttackRatio.ROGUE, UnitRole.REGULAR, location);
    }
}
