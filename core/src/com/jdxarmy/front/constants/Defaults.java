package com.jdxarmy.front.constants;

import com.badlogic.gdx.Gdx;

public enum Defaults {
    ;
    public static final int UNITS_IN_TEAM = 1;
    public static final int UNITS_EXIST = 13;
    public static final float GAMEFIELD_CELL_WIDTH = Gdx.graphics.getWidth()*0.08f;
    public static final float GAMEFIELD_CELL_HEIGHT = Gdx.graphics.getHeight()*0.08f;
    public static final int GAMEFIELD_CELLS_IN_SIDE = 10;
    public static final float GAMEFIELD_WIDTH = GAMEFIELD_CELL_WIDTH*GAMEFIELD_CELLS_IN_SIDE;
    public static final float GAMEFIELD_HEIGHT = GAMEFIELD_CELL_HEIGHT*GAMEFIELD_CELLS_IN_SIDE;
    public static final float UNIT_CHOICE_TAB_WIDTH = Gdx.graphics.getWidth()*0.2f;
    public static final float UNIT_CHOICE_TAB_HEIGHT = Gdx.graphics.getHeight();
    public static final float UNIT_CHOICE_TAB_UNIT_PIC_HEIGHT = Gdx.graphics.getHeight()*0.08f;
    public static final float UNIT_CHOICE_TAB_UNIT_PIC_WIDTH = Gdx.graphics.getWidth()*0.08f;
    public static final float UNIT_CHOICE_TAB_UNIT_PIC_WIDTH_INTERVAL = Gdx.graphics.getWidth()*0.1f;
    public static final String BACKGROUNDS_UNIT_ACTION_CHOICE_TAB_PATH = "backgrounds/textura.jpg";
    public static final String SPRITES_GAMEFIELD_CELL = "sprites/cell.png";
    public static final String SPRITES_WEREWOLF_WOLF_BLUE_PATH = "sprites/werewolf_wolf_blue.png";
    public static final String SPRITES_WEREWOLF_WOLF_RED_PATH = "sprites/werewolf_wolf_red.png";
    public static final String SPRITES_ARCHER_BLUE_PATH = "sprites/archer_blue.png";
    public static final String SPRITES_ARCHER_RED_PATH = "sprites/archer_red.png";
    public static final String SKINS_NUMBER_CRUNCHER_PATH = "skins/number-cruncher/skin/number-cruncher-ui.json";
    public static final String SKINS_UISKIN_PATH = "skins/default/skin/uiskin.json";
}
