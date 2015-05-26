package com.libgdx.playground.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.playground.screens.objects.AbstractGameObject;
import com.libgdx.playground.screens.objects.LibgdxLogo;

public class PlaygroundScreen extends AbstractGameScreen {

	SpriteBatch batch;
	LibgdxLogo libgdxLogo;

	public PlaygroundScreen(DirectedGame game) {
		super(game);
		batch = new SpriteBatch();
		libgdxLogo = new LibgdxLogo();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		setObjectPosition(libgdxLogo);
	};

	private void setObjectPosition(AbstractGameObject object) {
		
		float x = viewport.getWorldWidth() * 0.5f;
		float y = viewport.getWorldHeight() * 0.5f;
		object.setPosition(x, y);	
	}

	@Override
	public void render(float deltatime) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		libgdxLogo.render(batch);
	}

	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		libgdxLogo.dispose();
	}

}
