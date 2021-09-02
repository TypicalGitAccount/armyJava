package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jdxarmy.back.classes.constants.Team;
import com.jdxarmy.back.classes.constants.UnitName;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.exceptions.NotImplementedException;
import com.jdxarmy.front.constants.Defaults;
import com.jdxarmy.front.listeners.unitActionTab.*;
import com.jdxarmy.front.listeners.unitActionTab.TransformButtonListener;
import com.jdxarmy.front.managers.GameManager;

public class UnitActionChoiceTab {
    GameManager placementManger;
    Stage screenStage;
    Image background;
    TextButton moveButton, physicalAttackButton, magicAttackButton,
            selfTransformAbilityButton, enemyTransformAbilityButton,
            observeAbilityButton, spawnAbilityButton;

    public UnitActionChoiceTab(Stage screenStage, GameManager placementManger) {
        this.placementManger = placementManger;
        this.screenStage = screenStage;
        background = new Image(new Texture(Defaults.BACKGROUNDS_UNIT_ACTION_CHOICE_TAB_PATH));
        Skin buttonSkin = new Skin(Gdx.files.internal(Defaults.SKINS_NUMBER_CRUNCHER_PATH));
        this.moveButton = new TextButton("", buttonSkin);
        this.physicalAttackButton = new TextButton("", buttonSkin);
        this.magicAttackButton = new TextButton("", buttonSkin);
        this.selfTransformAbilityButton = new TextButton("", buttonSkin);
        this.enemyTransformAbilityButton = new TextButton("", buttonSkin);
        this.observeAbilityButton = new TextButton("", buttonSkin);
        this.spawnAbilityButton = new TextButton("", buttonSkin);
    }

    public void draw() {
        float tabWidth = Defaults.UNIT_CHOICE_TAB_WIDTH;
        float tabHeight = Defaults.UNIT_CHOICE_TAB_HEIGHT;
        screenStage.addActor(background);
        background.setBounds(Gdx.graphics.getWidth()*0.8f, 0, tabWidth, tabHeight);
        float buttonWidth = Gdx.graphics.getWidth()*0.2f;
        float buttonHeight = Gdx.graphics.getHeight()*0.1f;
        float heightInterval = buttonHeight *0.3f;
        moveButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight -heightInterval, buttonWidth, buttonHeight);
        physicalAttackButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight*2 -heightInterval*2, buttonWidth, buttonHeight);
        magicAttackButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight *3-heightInterval*3, buttonWidth, buttonHeight);
        selfTransformAbilityButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight *4-heightInterval*4, buttonWidth, buttonHeight);
        enemyTransformAbilityButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight *5-heightInterval*5, buttonWidth, buttonHeight);
        observeAbilityButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight *6-heightInterval*6, buttonWidth, buttonHeight);
        spawnAbilityButton.setBounds(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()- buttonHeight *7-heightInterval*7, buttonWidth, buttonHeight);
    }

    public void disableButtons() {
        moveButton.clearListeners();
        moveButton.remove();
        physicalAttackButton.clearListeners();
        physicalAttackButton.remove();
        magicAttackButton.clearListeners();
        magicAttackButton.remove();
        selfTransformAbilityButton.clearListeners();
        selfTransformAbilityButton.remove();
        enemyTransformAbilityButton.clearListeners();
        enemyTransformAbilityButton.remove();
        observeAbilityButton.clearListeners();
        observeAbilityButton.remove();
        spawnAbilityButton.clearListeners();
        spawnAbilityButton.remove();
    }

    public void enableButtons() {
        screenStage.addActor(moveButton);
        moveButton.setText("");
        screenStage.addActor(physicalAttackButton);
        physicalAttackButton.setText("");
        screenStage.addActor(magicAttackButton);
        magicAttackButton.setText("");
        screenStage.addActor(magicAttackButton);
        screenStage.addActor(selfTransformAbilityButton);
        selfTransformAbilityButton.setText("");
        screenStage.addActor(enemyTransformAbilityButton);
        enemyTransformAbilityButton.setText("");
        screenStage.addActor(observeAbilityButton);
        spawnAbilityButton.setText("");
        screenStage.addActor(spawnAbilityButton);
        spawnAbilityButton.setText("");
    }

    public boolean actionButtonPressed() {
        return moveButton.isPressed() || physicalAttackButton.isPressed() || magicAttackButton.isPressed()
                || selfTransformAbilityButton.isPressed() || enemyTransformAbilityButton.isPressed()
                || spawnAbilityButton.isPressed();
    }

    public void displayActions(CellImage unitImg) {
        enableButtons();
        moveButton.setText("move");
        moveButton.addListener(new MoveButtonClickListener(unitImg, placementManger));
        physicalAttackButton.setText("physical attack");
        physicalAttackButton.addListener(new PhysicalAttackButtonListener(placementManger, unitImg));

        if ( unitImg.getOccupier().getState().getRole().equals(UnitRole.FIGHT_MAGE) || unitImg.getOccupier().getState().getRole().equals(UnitRole.SUPPORT_MAGE) ) {
            magicAttackButton.setDisabled(false);
            magicAttackButton.setText("magic attack!");
            magicAttackButton.addListener(new MagicAttackButtonListener(placementManger, unitImg));
        } else {
            magicAttackButton.setDisabled(true);
            magicAttackButton.setText("");
        }

        String transformImgPath;
        if (unitImg.getOccupier().getState().getName().equals(UnitName.WEREWOLF)) {
            if ( unitImg.getOccupier().getState().getTeam().equals(Team.BLUE) ) {
                transformImgPath = Defaults.SPRITES_WEREWOLF_WOLF_BLUE_PATH;
            } else {
                transformImgPath = Defaults.SPRITES_WEREWOLF_WOLF_RED_PATH;
            }
            selfTransformAbilityButton.addListener(new TransformButtonListener(placementManger, unitImg, transformImgPath));
            selfTransformAbilityButton.setDisabled(false);
            selfTransformAbilityButton.setText("transform!");
        } else if (unitImg.getOccupier().getState().getName().equals(UnitName.SOLDIER)) {
            if ( unitImg.getOccupier().getState().getTeam().equals(Team.BLUE) ) {
                transformImgPath = Defaults.SPRITES_ARCHER_BLUE_PATH;
            } else {
                transformImgPath = Defaults.SPRITES_ARCHER_RED_PATH;
            }
            selfTransformAbilityButton.addListener(new TransformButtonListener(placementManger, unitImg, transformImgPath));
            selfTransformAbilityButton.setDisabled(false);
            selfTransformAbilityButton.setText("transform!");
        } else {
            selfTransformAbilityButton.setDisabled(true);
            selfTransformAbilityButton.setText("");
        }

        try {
            unitImg.getOccupier().transformEnemySpecialAbility(null);
        } catch (NotImplementedException ex) {
            enemyTransformAbilityButton.setDisabled(true);
            enemyTransformAbilityButton.setText("");
        } catch (Exception ex) {
            enemyTransformAbilityButton.addListener(new TransformEnemyButtonListener(placementManger, unitImg));
            enemyTransformAbilityButton.setDisabled(false);
            enemyTransformAbilityButton.setText("transform enemy!");
        }

        try {
            unitImg.getOccupier().observeSpecialAbility(null, null);
        } catch (NotImplementedException ex) {
            observeAbilityButton.setDisabled(true);
            observeAbilityButton.setText("");
        } catch (Exception ex) {
            observeAbilityButton.addListener(new ObserveAbilityButtonListener(placementManger, unitImg));
            observeAbilityButton.setDisabled(false);
            observeAbilityButton.setText("observe!");
        }

        try {
            unitImg.getOccupier().spawnSpecialAbility(null);
        } catch (NotImplementedException ex) {
            spawnAbilityButton.setDisabled(true);
            spawnAbilityButton.setText("");
        } catch (Exception ex) {
            spawnAbilityButton.addListener(new SpawnButtonListener(placementManger, unitImg));
            spawnAbilityButton.setDisabled(false);
            spawnAbilityButton.setText("spawn the chort!");
        }
    }
}
