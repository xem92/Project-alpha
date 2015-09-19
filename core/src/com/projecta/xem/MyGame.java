package com.projecta.xem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projecta.xem.der.Der;

public class MyGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Der der;
	private OrthographicCamera camera;
	
	// Debuggin 
	private BitmapFont fontY;
	private BitmapFont fontX;
	private BitmapFont fontCrunch;
	
	//Key pressing control
	private Boolean keyC;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		der = new Der();
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
	    fontY = new BitmapFont();
	    fontX = new BitmapFont();
	    fontCrunch = new BitmapFont();
	    
	    keyC = true;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// DeltaTime
		float dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
		
		// tell the camera to update its matrices.
	    camera.update();
	    
	    // tell the SpriteBatch to render in the
	    // coordinate system specified by the camera.
	    batch.setProjectionMatrix(camera.combined);
	    
	    gameLogic(dt);
		
		batch.begin();
		batch.draw(der.body, der.x, der.y);
		
		//Debugin text
		fontY.draw(batch, ""+der.y, 0, 30);
		fontX.draw(batch, ""+der.x, 40, 30);
		fontCrunch.draw(batch, ""+der.crouch, 0, 60);
		batch.end();
	}

	private void gameLogic(float dt) {
		der.updateJump(dt);
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			der.moveLred(dt);
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) 
			der.moveRder(dt);
		if(Gdx.input.isKeyPressed(Keys.SPACE))
			der.jumpDer(dt);
		if(Gdx.input.isKeyPressed(Keys.C)){
			if (keyC)
				der.crouchDer();
			keyC = false;
		} else {
			keyC = true;
		}
	}
}
