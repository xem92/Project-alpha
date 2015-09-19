package com.projecta.xem.der;

import com.badlogic.gdx.graphics.Texture;

public class Der {
	
	// Der constants
	private static final float ACCELERATION     = 100f;
	private static final float GRAVITY          = 80f;
	private static final float GROUND           = 50;
	private static final float VELOCITY			= 30; 
	
	//Der propierties
	public Texture body;
	public float x;
	public float y;
	public int height;
	public int width;
	private float jumpAcceleration;
	public Boolean jumpState;
	public Boolean crouch;
	
	// Der constructor
	public Der() {
		body = new Texture("der.png");
		x = 50;
		y = 50;
		height = 52;
		width = 33;
		jumpState = false;
		crouch = false;
	}
	
	public void moveRder(float dt) {
		x += VELOCITY*dt;
	}
	
	public void moveLred(float dt) {
		x -= VELOCITY*dt;
	}
	
	public void crouchDer(){
		if (crouch){
			crouch = false;
			body = new Texture("der.png");
			height = 52;
			width = 33;
		}else{
			crouch = true;
			body = new Texture("crunchDer.png");
			height = 33;
			width = 52;
		}
	}
	
	public void jumpDer(float dt) {
		// jump only if it isn't jumping already or is dow
		if (jumpState == false && crouch == false) {
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
