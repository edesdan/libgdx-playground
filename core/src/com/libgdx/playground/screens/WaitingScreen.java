package com.libgdx.playground.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.playground.screens.objects.WaitingAnimation;

public class WaitingScreen extends AbstractGameScreen {

	private WaitingAnimation waitAnimation;
	private SpriteBatch batch;

	public WaitingScreen(DirectedGame game) {
		super(game);
		waitAnimation = new WaitingAnimation(viewport);
		batch = new SpriteBatch();
	}

	@Override
	public void render(float deltaTime) {
		// Sets the clear screen color to: Cornflower Blue
		Gdx.gl.glClearColor(0 / 255.0f, 146 / 255.0f, 203 / 255.0f, 255 / 255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		waitAnimation.update(deltaTime);
		batch.begin();
		waitAnimation.render(batch);
		batch.end();
	}

	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
