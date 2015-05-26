package com.libgdx.playground.screens.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public abstract class AbstractGameObject implements Disposable {

	protected Vector2 position;
	protected Vector2 dimension;
	protected Vector2 origin;
	protected Vector2 scale;
	protected float rotation;
	protected float stateTime;
	protected Animation animation;

	public AbstractGameObject() {
		position = new Vector2();
		dimension = new Vector2(1, 1);
		origin = new Vector2();
		scale = new Vector2(1, 1);

	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
		stateTime = 0;
	}

	public void update(float deltaTime) {
		stateTime += deltaTime;
	}

	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
	}

	public float getWidth() {
		return dimension.x;
	}

	public float getHeight() {
		return dimension.y;
	}

	public abstract void render(SpriteBatch batch);

}
