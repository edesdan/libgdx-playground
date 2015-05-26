package com.libgdx.playground.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class AbstractGameScreen extends InputAdapter implements Screen {

	protected DirectedGame game;
	protected static Viewport viewport;
	protected static Camera camera;

	protected static final float TARGET_SCREEN_WIDTH = 1280.0f;
	protected static final float TARGET_SCREEN_HEIGHT = 720.0f;
	private static final float MAX_SCENE_WIDTH = 1920.0f;
	private static final float MAX_SCENE_HEIGHT = 1080.0f;

	public AbstractGameScreen(DirectedGame game) {
		this.game = game;
		if (camera == null) {
			camera = new OrthographicCamera();
		}
		if (viewport == null) {
			viewport = new ExtendViewport(TARGET_SCREEN_WIDTH, TARGET_SCREEN_HEIGHT, MAX_SCENE_WIDTH, MAX_SCENE_HEIGHT, camera);
		}
		Gdx.input.setCatchBackKey(false); // will be set to true only when the
											// child override the InputAdapter
											// class methods
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
	}

	@Override
	public void resize(int width, int height) {
		// Whenever a resize event occurs, the viewport needs to be informed
		// about it and updated. This will automatically recalculate the
		// viewport parameters and update the camera (centered to the screen)
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public abstract InputProcessor getInputProcessor();

}
