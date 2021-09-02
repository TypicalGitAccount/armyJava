package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.states.ArcherState;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.CantTransformUnitException;
import com.jdxarmy.back.exceptions.NotImplementedException;

public class SoldierAttack extends Attack {
    @Override
    public void TransformSpecialAbility(Unit user) throws NotImplementedException, CantTransformUnitException {
        if ( !(user.getState() instanceof ArcherState) ) {
            user.setState(new ArcherState(user.getState().getLocation(), user.getState().getTeam()));
            user.setAttack(new ArcherAttack());
        }
    }
}
