package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.states.WereWolfHumanState;
import com.jdxarmy.back.classes.states.WereWolfWolfState;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.classes.units.Vampire;
import com.jdxarmy.back.exceptions.CantTransformUnitException;

public class WereWolfAttack extends Attack {
    @Override
    public void TransformEnemySpecialAbility(Unit enemy) throws CantTransformUnitException {
        if (!(enemy instanceof Vampire)) {
            String teamToJoin;
            if ( enemy.getState().getTeam().equals(Team.BLUE) ) {
                teamToJoin = Team.RED;
            } else {
                teamToJoin = Team.BLUE;
            }
            enemy.setState(new WereWolfHumanState(enemy.getState().getLocation(), teamToJoin));
            enemy.setAttack(new WereWolfAttack());
        } else if (enemy instanceof Vampire) {
            throw new CantTransformUnitException("Can't bite a vampire!");
        } else {
            throw new CantTransformUnitException(enemy.getState().getName()+" was already biten!");
        }
    }

    @Override
    public void TransformSpecialAbility(Unit user) throws CantTransformUnitException {
        if ( user.getState() instanceof WereWolfHumanState ) {
            user.setState(new WereWolfWolfState(user.getState().getLocation(), user.getState().getTeam()));
        } else {
            throw new CantTransformUnitException("Already transformed!");
        }
    }
}
