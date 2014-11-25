package com.devingdesigns.test3d;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.devingdesigns.test3d.screens.TestScreen;

public class Test3D extends Game implements ApplicationListener {
	TestScreen testScreen;
	
	@Override
	public void create () {
		testScreen = new TestScreen();
		setScreen(testScreen);
	}

	@Override
	public void render () {
		super.render();
	}
}
