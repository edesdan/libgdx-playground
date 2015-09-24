package com.libgdx.playground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Assets implements Disposable, AssetErrorListener {

	public static final Assets instance = new Assets(); // Singleton
	private static final String TAG = Assets.class.getName();

	private static final String GAME_PACK_ATLAS_NAME = "game-pack.atlas";
	public TextureAtlas gameTextures;
	public Texture logoTexture;
	private AssetManager assetsManager; // Don't make this static!!!
	private boolean isLoadingAssets;

	// singleton: prevent instantiation from other classes
	private Assets() {
		assetsManager = new AssetManager();
		// set asset manager error handler
		assetsManager.setErrorListener(this);
	}

	/**
	 * Initialize all assets like textures, sprites, music, sounds that will be
	 * accessed in the game.
	 * 
	 * Make sure you have called one of the loading assets methods first before
	 * calling this method.
	 */
	public void init() {

		if (isLoadingAssets == true && assetsManager.update() == false) {
			throw new IllegalStateException("AssetsManager not ready.");
		}

		// get game pack texture atlas
		gameTextures = assetsManager.get("data/images/" + GAME_PACK_ATLAS_NAME);
		setTextureFilter(gameTextures, TextureFilter.Linear);
		// get logo texture
		logoTexture = assetsManager.get("libGDX.png");
	}

	/**
	 * Load all assets synchronously. This means it will block until all the
	 * specified assets are loaded in memory.
	 */
	public void loadAllAssetsSync() {

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
	 * Load all assets asynchronously. Suitable for all the cases when you want
	 * to do other stuff while loading: showing a splash image or loading bar on
	 * screen for example.
	 */
	public void loadAllAssetsASync() {

		isLoadingAssets = true;

		// load libGDX logo
		assetsManager.load("libGDX.png", Texture.class);
		// load texture atlas
		assetsManager.load("data/images/" + GAME_PACK_ATLAS_NAME, TextureAtlas.class);
		// load sounds
		// load music

	}

	public boolean isfinishedLoadingAssets() {

		return assetsManager.update();
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
		throw new GdxRuntimeException("Error loading asset " + asset + ". " + throwable.getMessage());

	}

	@Override
	public void dispose() {
		Gdx.app.debug(TAG, " Disposing assets...");
		gameTextures.dispose();
		assetsManager.dispose();

	}

}
