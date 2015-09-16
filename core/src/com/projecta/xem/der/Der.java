package com.projecta.xem.der;

import com.badlogic.gdx.graphics.Texture;

public class Der {
	
	// Der constants
	private static final float ACCELERATION     = 100f;
	private static final float GRAVITY          = 80f;
	private static final float GROUND           = 50;
	private static final float VELOCITY			= 30; 
	
	public Texture body;
	public float x;
	public float y;
	private float jumpAcceleration;
	public Boolean jumpState;
	
	// Der constructor
	public Der() {
		body = new Texture("der.png");
		x = 50;
		y = 50;
		jumpState = false;
	}
	
	public void moveRder(float dt) {
		x += VELOCITY*dt;
	}
	
	public void moveLred(float dt) {
		x -= VELOCITY*dt;
	}
	
	public void jumpDer(float dt) {
		if (jumpState == false) {
			jumpState = true;
			jumpAcceleration = 0;
		}
	}

	public void updateJump(float dt) {
		if (jumpState == true) {
			y += (ACCELERATION - jumpAcceleration)*dt;
			jumpAcceleration += GRAVITY*dt;
			if (y <= GROUND) {
				jumpState = false;
				y = GROUND;
			}
		}
	}
}
