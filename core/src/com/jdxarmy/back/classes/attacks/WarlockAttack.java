package com.jdxarmy.back.classes.attacks;

import com.jdxarmy.back.classes.gamefield.GameField;
import com.jdxarmy.back.classes.units.Demon;
import com.jdxarmy.back.classes.units.Unit;
import com.jdxarmy.back.exceptions.WrongCellException;

public class WarlockAttack extends Attack {
    @Override
    public int[] SpawnSpecialAbility(Unit attacker, GameField field) throws WrongCellException {
        int spawnedOnX, spawnedOnY;

        if (!field.getCell(attacker.getState().getLocation().getX() - 1, attacker.getState().getLocation().getY()).isOccupied()) {
            spawnedOnX = attacker.getState().getLocation().getX() - 1;
            spawnedOnY = attacker.getState().getLocation().getY();
            field.getCell(spawnedOnX, spawnedOnY).occupy(new Demon(field.getCell(spawnedOnX, spawnedOnY), attacker.getState().getTeam()));
        } else if (!field.getCell(attacker.getState().getLocation().getX() + 1, attacker.getState().getLocation().getY()).isOccupied()) {
            spawnedOnX = attacker.getState().getLocation().getX() + 1;
            spawnedOnY = attacker.getState().getLocation().getY();
            field.getCell(spawnedOnX, spawnedOnY).occupy(new Demon(field.getCell(spawnedOnX, spawnedOnY), attacker.getState().getTeam()));
        } else if (!field.getCell(attacker.getState().getLocation().getX(), attacker.getState().getLocation().getY() - 1).isOccupied()) {
            spawnedOnX = attacker.getState().getLocation().getX();
            spawnedOnY = attacker.getState().getLocation().getY() - 1;
            field.getCell(spawnedOnX, spawnedOnY).occupy(new Demon(field.getCell(spawnedOnX, spawnedOnY), attacker.getState().getTeam()));
        } else if (!field.getCell(attacker.getState().getLocation().getX(), attacker.getState().getLocation().getY() + 1).isOccupied()) {
            spawnedOnX = attacker.getState().getLocation().getX();
            spawnedOnY = attacker.getState().getLocation().getY() + 1;
            field.getCell(spawnedOnX, spawnedOnY).occupy(new Demon(field.getCell(spawnedOnX, spawnedOnY), attacker.getState().getTeam()));
        } else throw new WrongCellException("No room to spawn demon");

        return new int[]{spawnedOnX, spawnedOnY};
    }
}

