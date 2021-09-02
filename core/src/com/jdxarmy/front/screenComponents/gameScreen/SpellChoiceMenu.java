package com.jdxarmy.front.screenComponents.gameScreen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdxarmy.back.classes.units.SpellCaster;
import com.jdxarmy.front.managers.GameManager;

public class SpellChoiceMenu extends Dialog {
    GameManager placementManager;
    CellImage unitImg;

    public SpellChoiceMenu(GameManager placementManager, CellImage unitImg, String label, Skin skin) {
        super(label, skin);
        this.placementManager = placementManager;
        this.unitImg = unitImg;
        this.button("OK", true);
        this.key(Input.Keys.ENTER, true);
        this.add(new SpellSelectBox(unitImg, placementManager));
    }

    @Override
    protected void result(Object object) {
        placementManager.getScreenComponentsManager().getGameFieldImg().addMagicalAttackedUnitListener(placementManager, (SpellCaster) unitImg.getOccupier());
        super.result(object);
    }
}
