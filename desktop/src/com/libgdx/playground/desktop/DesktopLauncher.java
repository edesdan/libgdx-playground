package com.libgdx.playground.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.playground.PlaygroundMain;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// TARGET RESOLUTION: 1280x720
		config.title = "libGDX playground";
		// SCREEN SIZES:
		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new PlaygroundMain(), config);
	}
}
