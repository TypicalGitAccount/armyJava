package com.jdxarmy.front.listeners.unitInfoTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.managers.GameScreenComponentsManager;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;
import com.jdxarmy.front.screenComponents.gameScreen.UnitInfoTab;

public class CellImgToInfoTabClickListener extends ClickListener {
    UnitInfoTab tab;
    CellImage unitImg;
    GameScreenComponentsManager manager;

    public CellImgToInfoTabClickListener(GameScreenComponentsManager manager, UnitInfoTab tab, CellImage unitImg) {
        this.tab = tab;
        this.unitImg = unitImg;
        this.manager = manager;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        manager.getActionTab().disableButtons();
        tab.drawFromCellImage(unitImg);
    }
}
