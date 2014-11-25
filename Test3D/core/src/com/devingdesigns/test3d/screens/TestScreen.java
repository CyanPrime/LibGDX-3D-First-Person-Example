package com.devingdesigns.test3d.screens;

import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.devingdesigns.test3d.Player;

public class TestScreen implements Screen{
	private PerspectiveCamera camera;
	
	private Mesh mesh;
	private Texture texture;
	private Texture transTex;
	
	
	private Vector<Decal> decal;
	private DecalBatch decalBatch;
	private TextureRegion textureRegion;
	private TextureRegion transTextureRegion;
	
	private ShaderProgram shaderProgram;
	
	private Player player;
	
	public void update(){
		//Desktop controls - I guess they could be used with a BlueTooth keyboard on Android.
		if(Gdx.input.isKeyPressed(Input.Keys.W)) player.moveForward();
		if(Gdx.input.isKeyPressed(Input.Keys.S)) player.moveBackward();
		if(Gdx.input.isKeyPressed(Input.Keys.A)) player.moveLeft();
		if(Gdx.input.isKeyPressed(Input.Keys.D)) player.moveRight();
		
		if(Gdx.input.isKeyPressed(Input.Keys.Q)) Gdx.app.exit();
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))  player.turnLeft();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) player.turnRight();
	}
	
	@Override
	public void render(float delta) {
		update();
		
<<<<<<< HEAD
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	
		//Do all your basic OpenGL ES setup to start the screen render.
		Gdx.gl20.glClearColor(0.0f, 0.3f, 0.5f, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl20.glEnable(GL20.GL_TEXTURE_2D);
		Gdx.gl20.glEnable(GL20.GL_BLEND);
		Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl20.glCullFace(GL20.GL_NONE);
		Gdx.gl20.glEnable(GL20.GL_DEPTH_TEST);
		
		
		//set the camera to the players position and rotation.
		camera.position.set(player.getPos());
		camera.lookAt( player.getPos().x + (float) Math.sin(Math.toRadians(player.getYaw())), 0,  player.getPos().z - (float) Math.cos(Math.toRadians(player.getYaw())));
		camera.update();
		
		texture.bind();
		shaderProgram.begin();
		    shaderProgram.setUniformMatrix("u_projTrans", camera.combined);
		    shaderProgram.setUniformi("u_texture", 0);
		    mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();
		
		//set decals up for visual testing.
		decal.get(0).setPosition(0,0,0);
		decal.get(1).setPosition(-1,0,-1);
		decal.get(2).setPosition(-1,0,1);
		decal.get(3).setPosition(1,0,1);
		decal.get(4).setPosition(1,0,-1);
		
		for(Decal d : decal){
			d.lookAt(camera.position, camera.up);
			decalBatch.add(d);
		}
		
		//draw decals.
		decalBatch.flush();
=======
	 	Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
 	
	 	//Do all your basic OpenGL ES setup to start the screen render.
	 	Gdx.gl20.glClearColor(0.0f, 0.3f, 0.5f, 1);
	        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	        Gdx.gl20.glEnable(GL20.GL_TEXTURE_2D);
	        Gdx.gl20.glEnable(GL20.GL_BLEND);
	        Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	        Gdx.gl20.glCullFace(GL20.GL_NONE);
	        Gdx.gl20.glEnable(GL20.GL_DEPTH_TEST);
        

	        //set the camera to the players position and rotation.
	        camera.position.set(player.getPos());
	        camera.lookAt( player.getPos().x + (float) Math.sin(Math.toRadians(player.getYaw())), 0,  player.getPos().z - (float) Math.cos(Math.toRadians(player.getYaw())));
		 	camera.update();
		 	
	        texture.bind();
	        shaderProgram.begin();
		        shaderProgram.setUniformMatrix("u_projTrans", camera.combined);
		        shaderProgram.setUniformi("u_texture", 0);
		        mesh.render(shaderProgram, GL20.GL_TRIANGLES);
	        shaderProgram.end();
	        
	        //set decals up for visual testing.
	        decal.get(0).setPosition(0,0,0);
	        decal.get(1).setPosition(-1,0,-1);
	        decal.get(2).setPosition(-1,0,1);
	        decal.get(3).setPosition(1,0,1);
	        decal.get(4).setPosition(1,0,-1);
	        
	        for(Decal d : decal){
	        	d.lookAt(camera.position, camera.up);
	        	decalBatch.add(d);
	        }
	        
	        //draw decals.
	        decalBatch.flush();
>>>>>>> origin/master
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void show() {
		decal = new Vector<Decal>();
		
		float aspectRatio = (float) 800 / (float) 480;
<<<<<<< HEAD
		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
=======
        	camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
>>>>>>> origin/master
		camera.near = 0.1f;

		texture = new Texture("badlogic.jpg");
		texture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		textureRegion = new TextureRegion(texture);
		
		transTex = new Texture("transtest.png");
		transTextureRegion = new TextureRegion(transTex);
		
		VertexAttribute[] vaa = new VertexAttribute[3];
		vaa[0] =  new VertexAttribute(Usage.Position, 3, ShaderProgram.POSITION_ATTRIBUTE );
		vaa[1] = new VertexAttribute(Usage.TextureCoordinates, 2, ShaderProgram.TEXCOORD_ATTRIBUTE+"0" ) ;
		vaa[2] = new VertexAttribute(Usage.TextureCoordinates, 4, ShaderProgram.COLOR_ATTRIBUTE );
		
		//set up floor (It's a single quad Mesh).
		mesh = new Mesh(true, 4, 6, vaa);
		
		mesh.setVertices(new float[] {
				//x,y,z				//u, v		//r,g,b,a
				-10f, -1f, -10,		0,10,      1,0,0,0.1f, //define counter clock wise vertices
				10f,  -1f, -10,		10,10,	   1,0,0,0.7f,
				10f,  -1f, 10,		10,0,	   1,0,0,0.5f,
				-10f, -1f, 10, 		0,0,	   1,0,0,1
			});
		
		mesh.setIndices(new short[] { 0, 1, 2, 2, 3, 0});
		
		mesh.getVertexAttribute(Usage.Position).alias = "a_position";
		
		String vertexShader = Gdx.files.internal("vert.glsl").readString();
		String  fragmentShader = Gdx.files.internal("frag.glsl").readString();
<<<<<<< HEAD
		shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
		
		decalBatch = new DecalBatch(new CameraGroupStrategy(camera));
		
		decal.add(Decal.newDecal(1, 1, textureRegion, false));
		for(int i = 0; i < 4; i++){
			decal.add(Decal.newDecal(1, 1, transTextureRegion, true));
		}
		
		player = new Player();
=======
        	shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
        
	        decalBatch = new DecalBatch(new CameraGroupStrategy(camera));
	        
	        decal.add(Decal.newDecal(1, 1, textureRegion, false));
	        for(int i = 0; i < 4; i++){
	        	decal.add(Decal.newDecal(1, 1, transTextureRegion, true));
	        }
	        
	        player = new Player();
>>>>>>> origin/master
	}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {
		shaderProgram.dispose();
		decalBatch.dispose();
		decal.clear();
		transTex.dispose();
		texture.dispose();
		mesh.dispose();
	}

}
