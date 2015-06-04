package com.libgdx.playground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

	public static final Assets instance = new Assets(); // Singleton
	private static final String TAG = Assets.class.getName();

	private static final String GAME_PACK_ATLAS_NAME = "game-pack.atlas";
	public TextureAtlas gameTextures; // Don't make this static!!!
	public Texture logoTexture;
	private AssetManager assetsManager;

	// singleton: prevent instantiation from other classes
	private Assets() {
		assetsManager = new AssetManager();
		// set asset manager error handler
		assetsManager.setErrorListener(this);
	}

	/**
	 * Load all assets using the {@link AssetManager#load}. It blocks until all
	 * loading is finished. This method must be called before accessing any
	 * asset.
	 */
	public void init() {
		Gdx.app.debug(TAG, " Init assets...");
		loadAssetsSync();

		// get game pack texture atlas
		gameTextures = assetsManager.get("data/images/" + GAME_PACK_ATLAS_NAME);
		setTextureFilter(gameTextures, TextureFilter.Linear);
		// get logo texture
		logoTexture = assetsManager.get("libGDX.png");
	}

	private void loadAssetsSync() {

		// load libGDX logo
		assetsManager.load("libGDX.png", Texture.class);
		// load texture atlas
		assetsManager.load("data/images/" + GAME_PACK_ATLAS_NAME, TextureAtlas.class);
		// load sounds
		// load music

		// start loading assets and wait until finished
		assetsManager.finishLoading();

	}

	/**
	 * // enable texture filtering for pixel smoothing
	 * 
	 * @param atlas
	 * @param typeOfFilter
	 */
	private void setTextureFilter(TextureAtlas atlas, TextureFilter typeOfFilter) {

		for (Texture t : atlas.getTextures())
			t.setFilter(typeOfFilter, typeOfFilter); // min=mag

	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		Gdx.app.debug(TAG, " Disposing assets...");
		gameTextures.dispose();
		assetsManager.dispose();

	}

}
