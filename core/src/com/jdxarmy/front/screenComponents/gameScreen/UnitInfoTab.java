package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.jdxarmy.back.classes.constants.UnitRole;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.back.classes.states.State;
import com.jdxarmy.front.managers.GameManager;

public class UnitInfoTab {
    Stage stage;
    SpriteBatch batch;
    Image background;
    Image clickedUnitImg;
    BitmapFont labelFont;
    Label headLabel, teamLabel, hpLabel, dmgLabel, moveDistanceLabel, attackRatioLabel, isObservedLabel,  currentSpellLabel;
    Label.LabelStyle labelStyle;
    UnitActionCancelButton actionCancelButton;

    private void setLabelsPosition() {
        float backgroundWidth = Gdx.graphics.getWidth()*0.8f;
        float backgroundHeight = Gdx.graphics.getHeight()*0.2f;
        this.background.setBounds(0, 0, backgroundWidth, backgroundHeight);
        float labelHeight = Gdx.graphics.getHeight() * 0.03f;
        float labelWidth = Gdx.graphics.getWidth() * 0.03f;
        float widthInterval = labelWidth*3;
        float heightInterval = labelHeight*0.75f;
        float labelStartPositionX = Gdx.graphics.getWidth() * 0.2f;
        float labelStartPositionY = backgroundHeight-labelHeight*1.25f;
        float clickedUnitImgStartPos = Gdx.graphics.getWidth()*0.01f;
        float clickedUnitImgWidth = Gdx.graphics.getWidth()*0.18f;
        float clickedUnitImgHeight = Gdx.graphics.getHeight()*0.18f;
        clickedUnitImg.setBounds(clickedUnitImgStartPos, clickedUnitImgStartPos, clickedUnitImgWidth, clickedUnitImgHeight);
        headLabel.setBounds(labelStartPositionX, labelStartPositionY, labelWidth, labelHeight);
        teamLabel.setBounds(labelStartPositionX, labelStartPositionY -labelHeight-heightInterval, labelWidth, labelHeight);
        hpLabel.setBounds(labelStartPositionX, labelStartPositionY -labelHeight*2-heightInterval*2, labelWidth, labelHeight);
        dmgLabel.setBounds(labelStartPositionX, labelStartPositionY -labelHeight*3-heightInterval*3, labelWidth, labelHeight);
        moveDistanceLabel.setBounds(labelStartPositionX +widthInterval, labelStartPositionY, labelWidth, labelHeight);
        attackRatioLabel.setBounds(labelStartPositionX +widthInterval, labelStartPositionY -labelHeight-heightInterval, labelWidth, labelHeight);
        currentSpellLabel.setBounds(labelStartPositionX +widthInterval, labelStartPositionY -labelHeight*2-heightInterval*2, labelWidth, labelHeight);
        isObservedLabel.setBounds(labelStartPositionX+widthInterval, labelStartPositionY-labelHeight*3-heightInterval*3, labelWidth, labelHeight);
    }

    public UnitInfoTab(GameManager manager, Stage stage, SpriteBatch batch) {
        this.stage = stage;
        this.batch = batch;
        this.background = new Image(new Texture("backgrounds/dungeonwall.png"));
        this.labelFont = new BitmapFont();
        labelFont.getData().setScale(1.1f);
        this.labelStyle = new Label.LabelStyle(labelFont, Color.WHITE);
        clickedUnitImg = new Image();
        headLabel = new Label("", labelStyle);
        teamLabel = new Label("", labelStyle);
        hpLabel = new Label("", labelStyle);
        dmgLabel = new Label("", labelStyle);
        moveDistanceLabel = new Label("", labelStyle);
        attackRatioLabel = new Label("", labelStyle);
        currentSpellLabel = new Label("", labelStyle);
        isObservedLabel = new Label("", labelStyle);
        this.actionCancelButton = new UnitActionCancelButton(manager);
        stage.addActor(this.background);
        stage.addActor(clickedUnitImg);
        stage.addActor(headLabel);
        stage.addActor(teamLabel);
        stage.addActor(hpLabel);
        stage.addActor(dmgLabel);
        stage.addActor(moveDistanceLabel);
        stage.addActor(attackRatioLabel);
        stage.addActor(currentSpellLabel);
        stage.addActor(isObservedLabel);
        setLabelsPosition();
    }

    private void draw(State unitState, Image unitImage) {
        clickedUnitImg.setDrawable(unitImage.getDrawable());
        headLabel.setText(unitState.getName() + " info:");
        teamLabel.setText("Team : " + unitState.getTeam());
        hpLabel.setText("Hp : " + unitState.getHp() + " / " + unitState.getMaxHp());
        dmgLabel.setText("Damage : " + unitState.getDmg());
        moveDistanceLabel.setText("max move distance : " + unitState.getMoveDistance());
        attackRatioLabel.setText("physical attack ratio : " + unitState.getAttackRatio());
        if (unitState.getRole().equals(UnitRole.FIGHT_MAGE) || unitState.getRole().equals(UnitRole.SUPPORT_MAGE)) {
            currentSpellLabel.setText("current spell : " + ((MagicState) unitState).getSpellInUse().getName() +
                    " with magic damage " + ((MagicState) unitState).getSpellInUse().getDmg() +
                    " and action ratio " + ((MagicState) unitState).getSpellInUse().getSpellRatio());
        } else {
            currentSpellLabel.setText("");
        }
    }

    public void addActionCancelButton() {
        stage.addActor(actionCancelButton);
    }

    public void removeActionCancelButton() {
        actionCancelButton.remove();
    }

    public void drawFromCellImage(CellImage unitImage) {
        if ( unitImage.getCell().isOccupied() ) {
            String isObserved;
            if ( unitImage.getOccupier().getState().getIsObserved() ) {
                isObserved = "is observed by " + unitImage.getOccupier().getState().getObserver().getState().getName();
            } else {
                isObserved = "not observed by other units";
            }

            draw(unitImage.getOccupier().getState(), unitImage);
            isObservedLabel.setText(isObserved);
        }
    }

    public void drawFromUnitImageAndState(UnitImageAndUnitState unitImage) {
        draw(unitImage.getState(), unitImage);
        isObservedLabel.setText("");
    }
}
