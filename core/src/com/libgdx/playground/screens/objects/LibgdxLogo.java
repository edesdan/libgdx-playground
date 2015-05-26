package com.libgdx.playground.screens.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxLogo extends AbstractGameObject {

	Texture logo;

	public LibgdxLogo() {
		super();
		logo = new Texture("libGDX.png");
		dimension.x = logo.getWidth();
		dimension.y = logo.getHeight();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(logo, position.x - (dimension.x / 2), position.y - (dimension.y / 2)); //put it in the middle of the screen (relative to viewport)
		batch.end();

	}

	@Override
	public void dispose() {
		logo.dispose();
	}

}
