package com.jdxarmy.front.listeners.unitChoiceTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.screenComponents.gameScreen.UnitImageAndUnitState;
import com.jdxarmy.front.screenComponents.gameScreen.UnitInfoTab;

public class UnitChoiceTabToInfoTabClickListener extends ClickListener {
    UnitInfoTab infoTab;
    UnitImageAndUnitState unitInfo;

    public UnitChoiceTabToInfoTabClickListener(UnitInfoTab tab, UnitImageAndUnitState info) {
        super();
        this.infoTab = tab;
        this.unitInfo = info;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        infoTab.drawFromUnitImageAndState(unitInfo);
    }
}
