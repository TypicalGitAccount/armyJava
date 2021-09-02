package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.spells.SpellBook;
import com.jdxarmy.back.classes.states.*;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.listeners.unitChoiceTab.UnitChoiceTabToInfoTabClickListener;

import java.util.ArrayList;

public class UnitChoosingTab extends Actor {
    Stage screenStage;
    Image background;
    ArrayList<UnitImageAndUnitState> unitImages;

    private void draw() {
        float tabWidth = Defaults.UNIT_CHOICE_TAB_WIDTH;
        float tabHeight = Defaults.UNIT_CHOICE_TAB_HEIGHT;
        screenStage.addActor(background);
        background.setBounds(Defaults.GAMEFIELD_WIDTH, 0, tabWidth, tabHeight);

        float unitPicHeight = Defaults.UNIT_CHOICE_TAB_UNIT_PIC_HEIGHT;
        float unitPicWidth = Defaults.UNIT_CHOICE_TAB_UNIT_PIC_WIDTH;
        float unitPicY = Gdx.graphics.getHeight()*0.85f;
        float widthInterval = Defaults.UNIT_CHOICE_TAB_UNIT_PIC_WIDTH_INTERVAL;
        float heightInterval = unitPicHeight*1.5f;

        for( int i = 0; i < Defaults.UNITS_EXIST; i++ ) {
            screenStage.addActor(unitImages.get(i));
            float unitPicX = Gdx.graphics.getWidth()*0.81f;
            if ( i % 2 == 0 ) {
                unitImages.get(i).setBounds(unitPicX, unitPicY, unitPicWidth, unitPicHeight);
            } else {
                unitImages.get(i).setBounds(unitPicX +widthInterval, unitPicY, unitPicWidth, unitPicHeight);
                unitPicY -= heightInterval;
            }
        }
    }

    public UnitChoosingTab(Stage screenStage) {
        this.screenStage = screenStage;
        background = new Image(new Texture("backgrounds/textura.jpg"));
        unitImages = new ArrayList<>();

        unitImages.add(new UnitImageAndUnitState("sprites/soldier_blue.png", new SoldierState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/rogue_blue.png", new RogueState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/berserker_blue.png", new BerserkerState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/archer_blue.png", new ArcherState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/werewolf_human_blue.png", new WereWolfHumanState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/vampire_blue.png", new VampireState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/wizard_blue.png", new WizardState(null, Team.BLUE, new SpellBook())));
        unitImages.add(new UnitImageAndUnitState("sprites/healer_blue.png", new HealerState(null,  Team.BLUE, new SpellBook())));
        unitImages.add(new UnitImageAndUnitState("sprites/priest_blue.png", new PriestState(null,  Team.BLUE, new SpellBook())));
        unitImages.add(new UnitImageAndUnitState("sprites/warlock_blue.png", new WarlockState(null,  Team.BLUE, new SpellBook())));
        unitImages.add(new UnitImageAndUnitState("sprites/necromancer_blue.png", new NecromancerState(null,  Team.BLUE, new SpellBook())));
        unitImages.add(new UnitImageAndUnitState("sprites/demon_blue.png", new DemonState(null, Team.BLUE)));
        unitImages.add(new UnitImageAndUnitState("sprites/horse_blue.png", new HorseState(null, Team.BLUE)));

        draw();
    }

    public void setTeamToSpawn(String team) {
        if ( team.equals(Team.RED) ) {
            unitImages.get(0).setDrawable(new Image(new Texture("sprites/soldier_red.png")).getDrawable());
            unitImages.get(0).getState().setTeam(team);
            unitImages.get(1).setDrawable(new Image(new Texture("sprites/rogue_red.png")).getDrawable());
            unitImages.get(1).getState().setTeam(team);
            unitImages.get(2).setDrawable(new Image(new Texture("sprites/berserker_red.png")).getDrawable());
            unitImages.get(2).getState().setTeam(team);
            unitImages.get(3).setDrawable(new Image(new Texture("sprites/archer_red.png")).getDrawable());
            unitImages.get(3).getState().setTeam(team);
            unitImages.get(4).setDrawable(new Image(new Texture("sprites/werewolf_human_red.png")).getDrawable());
            unitImages.get(4).getState().setTeam(team);
            unitImages.get(5).setDrawable(new Image(new Texture("sprites/vampire_red.png")).getDrawable());
            unitImages.get(5).getState().setTeam(team);
            unitImages.get(6).setDrawable(new Image(new Texture("sprites/wizard_red.png")).getDrawable());
            unitImages.get(6).getState().setTeam(team);
            unitImages.get(7).setDrawable(new Image(new Texture("sprites/healer_red.png")).getDrawable());
            unitImages.get(7).getState().setTeam(team);
            unitImages.get(8).setDrawable(new Image(new Texture("sprites/priest_red.png")).getDrawable());
            unitImages.get(8).getState().setTeam(team);
            unitImages.get(9).setDrawable(new Image(new Texture("sprites/warlock_red.png")).getDrawable());
            unitImages.get(9).getState().setTeam(team);
            unitImages.get(10).setDrawable(new Image(new Texture("sprites/necromancer_red.png")).getDrawable());
            unitImages.get(10).getState().setTeam(team);
            unitImages.get(11).setDrawable(new Image(new Texture("sprites/demon_red.png")).getDrawable());
            unitImages.get(11).getState().setTeam(team);
            unitImages.get(12).setDrawable(new Image(new Texture("sprites/horse_red.png")).getDrawable());
            unitImages.get(12).getState().setTeam(team);
        }
    }

    public UnitImageAndUnitState getUnitImage(int index) { return unitImages.get(index); }

    public void addInfoTabClickListener(UnitInfoTab infoTab) {
        for ( int i = 0; i < 13; i++) {
            unitImages.get(i).addListener(new UnitChoiceTabToInfoTabClickListener(infoTab, unitImages.get(i)));
        }
    }

    @Override
    public boolean remove() {
        background.remove();
        for (UnitImageAndUnitState unitImage : unitImages) {
            unitImage.remove();
        }
        return super.remove();
    }
}
