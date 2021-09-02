package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdxarmy.back.classes.constants.SpellName;
import com.jdxarmy.back.classes.states.MagicState;
import com.jdxarmy.front.managers.GameManager;

public class SpellSelectBox extends SelectBox<String> {
    CellImage unitImg;
    GameManager placementManager;

    public SpellSelectBox(CellImage unitImg, GameManager placementManager) {
        super(new Skin(Gdx.files.internal("skins/default/skin/uiskin.json")));
        this.unitImg = unitImg;
        this.placementManager = placementManager;
        this.setItems(SpellName.FIREBALL, SpellName.WATERBALL, SpellName.WINDSTRIKE, SpellName.THUNDERSTRIKE, SpellName.HEAL);
    }

    @Override
    protected void onHide(Actor selectBoxList) {
        ((MagicState)unitImg.getOccupier().getState()).setSpellInUse(getSelected());
        placementManager.getScreenComponentsManager().getInfoTab().drawFromCellImage(unitImg);
        super.onHide(selectBoxList);
    }
}
