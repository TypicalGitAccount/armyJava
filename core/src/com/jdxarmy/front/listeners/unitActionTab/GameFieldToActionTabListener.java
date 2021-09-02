package com.jdxarmy.front.listeners.unitActionTab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.screenComponents.gameScreen.CellImage;
import com.jdxarmy.front.screenComponents.gameScreen.UnitActionChoiceTab;

public class GameFieldToActionTabListener extends ClickListener {
    CellImage fieldCell;
    UnitActionChoiceTab actionTab;

    public GameFieldToActionTabListener(CellImage fieldCell, UnitActionChoiceTab actionTab) {
        super();
        this.fieldCell = fieldCell;
        this.actionTab = actionTab;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        if ( fieldCell.getCell().isOccupied() ) {
            actionTab.displayActions(fieldCell);
        }
    }
}
