package com.jdxarmy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jdxarmy.front.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1980;
		config.height = 1080;
//		config.fullscreen = true;
//		config.forceExit = true;
//		config.pauseWhenBackground = true;
//		config.pauseWhenMinimized = true;
//		config.resizable = true;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
