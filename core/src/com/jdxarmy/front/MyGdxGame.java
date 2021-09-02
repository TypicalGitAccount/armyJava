package com.jdxarmy.front;

import com.badlogic.gdx.Game;
import com.jdxarmy.front.screens.StartScreen;

public class MyGdxGame extends Game {
	@Override
	public void create () {
		setScreen(new StartScreen(this));
	}

	@Override
	public void render () {
		super.render();
		this.screen.render(0);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		this.screen.resize(width, height);
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
