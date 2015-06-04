package com.libgdx.playground.screens.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.playground.Assets;

public class WaitingAnimation extends AbstractGameObject {

	private static final float FRAME_DURATION = 0.5f;
	private static final Animation.PlayMode PLAYMODE = Animation.PlayMode.LOOP;
	private static final String IMAGE_NAME = "waitingCircles";
	private TextureRegion currentFrame;

	public WaitingAnimation(Viewport viewport) {
		super(viewport);
		Array<AtlasRegion> keyFrames = Assets.instance.gameTextures.findRegions(IMAGE_NAME);
		Animation waitingAnimation = new Animation(FRAME_DURATION, keyFrames, PLAYMODE);
		setAnimation(waitingAnimation);
		currentFrame = animation.getKeyFrame(stateTime);
		dimension.x = currentFrame.getRegionWidth();
		dimension.y = currentFrame.getRegionHeight();
		position.x = viewport.getScreenWidth() * 0.5f - dimension.x * 0.5f;
		position.y = viewport.getScreenHeight() * 0.5f - dimension.y * 0.5f;
	}

	@Override
	public void render(SpriteBatch batch) {
		currentFrame = animation.getKeyFrame(stateTime);
		batch.draw(currentFrame, position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y, 0.0f);
	}

	@Override
	public void dispose() {

	}

}
