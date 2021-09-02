package com.jdxarmy.front.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdxarmy.front.MyGdxGame;

public class StartScreen extends ScreenAdapter {
    MyGdxGame game;
    SpriteBatch batch;
    Texture background;
    OrthographicCamera camera;
    Table table;
    Stage stage;
    ImageTextButton startButton;

    public StartScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        camera = new OrthographicCamera(stage.getViewport().getScreenWidth(), stage.getViewport().getScreenHeight());
        background = new Texture("backgrounds/hd.jpg");
        startButton = new ImageTextButton("Start game", new Skin(Gdx.files.internal("skins/flat-earth/skin/flat-earth-ui.json")), "default");

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen());
            }
        });

        table = new Table();
        table.setFillParent(true);
        table.setTransform(true);
        table.row();
        table.add(startButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.viewportWidth = width;
        camera.viewportHeight = height;
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        stage.dispose();
    }
}
