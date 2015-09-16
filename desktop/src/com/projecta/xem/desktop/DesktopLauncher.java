package com.projecta.xem.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.projecta.xem.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Project-alpha";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new MyGame(), config);
	}
}
