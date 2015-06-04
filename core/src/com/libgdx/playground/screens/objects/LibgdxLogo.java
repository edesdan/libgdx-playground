package com.libgdx.playground.screens.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.playground.Assets;

public class LibgdxLogo extends AbstractGameObject {

	private Texture logo;

	public LibgdxLogo(Viewport viewport) {
		super(viewport);
		logo = Assets.instance.logoTexture;
		dimension.x = logo.getWidth();
		dimension.y = logo.getHeight();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(logo, position.x - (dimension.x / 2), position.y - (dimension.y / 2)); 
		batch.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
}
