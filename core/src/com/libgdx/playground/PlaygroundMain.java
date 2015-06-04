package com.libgdx.playground;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.libgdx.playground.screens.DirectedGame;
import com.libgdx.playground.screens.PlaygroundScreen;
import com.libgdx.playground.screens.transitions.ScreenTransition;
import com.libgdx.playground.screens.transitions.ScreenTransitionFade;

public class PlaygroundMain extends DirectedGame {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load all assets
		Assets.instance.init();
		// Start game with Playground Screen
		ScreenTransition transition = ScreenTransitionFade.init(3.0f);
		setScreen(new PlaygroundScreen(this), transition);

	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.instance.dispose();
	}

}
