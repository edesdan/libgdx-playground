package com.libgdx.playground.screens.objects;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Extending the AbstractGameObject class with some additional attributes and
 * general functionalities for our physics and collision detection code.
 * velocity: This is the object's current speed in m/s. terminalVelocity: This
 * is the object's positive and negative maximum speed in m/s. friction: This is
 * an opposing force that slows down the object until its velocity equals zero.
 * This value is given as a coefficient which is dimensionless. A value of zero
 * means no friction, and thus the object's velocity will not decrease.
 * acceleration: This is the object's constant acceleration in m/s2. bounds: The
 * object's bounding box describes the physical body that will be used for
 * collision detection with other objects. The bounding box can be set to any
 * size and is completely independent of the actual dimension of the object in
 * the game world.
 * 
 * 
 */
abstract public class AbstractGameObjectWithPhysicsBody extends AbstractGameObject {

    protected Vector2 velocity;
    protected Vector2 terminalVelocity;
    protected Vector2 friction;
    protected Vector2 acceleration;
    protected Rectangle bounds;
    public Body body;

    public AbstractGameObjectWithPhysicsBody() {

	velocity = new Vector2();
	terminalVelocity = new Vector2(1, 1);
	friction = new Vector2();
	acceleration = new Vector2();
	bounds = new Rectangle();
    }

    protected void updateMotionX(float deltaTime) {
	if (velocity.x != 0) {
	    // Apply friction
	    if (velocity.x > 0) {
		velocity.x = Math.max(velocity.x - friction.x * deltaTime, 0);
	    } else {
		velocity.x = Math.min(velocity.x + friction.x * deltaTime, 0);
	    }
	}
	// Apply acceleration
	velocity.x += acceleration.x * deltaTime;
	// Make sure the object's velocity does not exceed the
	// positive or negative terminal velocity
	velocity.x = MathUtils.clamp(velocity.x, -terminalVelocity.x, terminalVelocity.x);
    }

    protected void updateMotionY(float deltaTime) {
	if (velocity.y != 0) {
	    // Apply friction
	    if (velocity.y > 0) {
		velocity.y = Math.max(velocity.y - friction.y * deltaTime, 0);
	    } else {
		velocity.y = Math.min(velocity.y + friction.y * deltaTime, 0);
	    }
	}
	// Apply acceleration
	velocity.y += acceleration.y * deltaTime;
	// Make sure the object's velocity does not exceed the
	// positive or negative terminal velocity
	velocity.y = MathUtils.clamp(velocity.y, -terminalVelocity.y, terminalVelocity.y);
    }

    @Override
    public void update(float deltaTime) {
	super.update(deltaTime);

	if (body == null) {
	    updateMotionX(deltaTime);
	    updateMotionY(deltaTime);
	    // Move to new position
	    position.x += velocity.x * deltaTime;
	    position.y += velocity.y * deltaTime;
	} else {
	    position.set(body.getPosition());
	    rotation = body.getAngle() * MathUtils.radiansToDegrees;
	}
    }
}
