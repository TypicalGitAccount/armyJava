package com.jdxarmy.front.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jdxarmy.front.managers.GameManager;

public class GameScreen extends ScreenAdapter {
    SpriteBatch batch;
    Stage stage;
    OrthographicCamera camera;
    GameManager manager;

    public GameScreen() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.setDebugAll(true);
        camera = new OrthographicCamera(stage.getViewport().getScreenWidth(), stage.getViewport().getScreenHeight());
        batch = new SpriteBatch();
        this.manager = new GameManager(stage, batch);
    }

    @Override
    public void show() {
        manager.run();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

        batch.setProjectionMatrix(camera.combined);
        camera.update();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        camera.setToOrtho(false, width, height);
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(stage.getCamera().viewportWidth / 2, stage.getCamera().viewportHeight / 2, 0);
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
