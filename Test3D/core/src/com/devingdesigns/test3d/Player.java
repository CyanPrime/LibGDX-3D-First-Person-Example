package com.devingdesigns.test3d;

import com.badlogic.gdx.math.Vector3;

public class Player {
	private Vector3 position;
	private float yaw = 0;
	private float speed = 0.3f;
	private float rotSpeed = 2f;
	
	public Player(){
		position = Vector3.Zero;
	}
	
	public Vector3 getPos(){
		return position;
	}
	
	public float getYaw(){
		return yaw;
	}
	
	public void moveForward(){
		Vector3 move = Vector3.Zero;
		move.x = (float) Math.sin(Math.toRadians(yaw));
		move.z = (float) -Math.cos(Math.toRadians(yaw));
		move.scl(speed);
		position.add(move);
	}
	
	public void moveBackward(){
		Vector3 move = Vector3.Zero;
		move.x = (float) -Math.sin(Math.toRadians(yaw));
		move.z = (float) Math.cos(Math.toRadians(yaw));
		move.scl(speed);
		position.add(move);
	}
	
	public void moveLeft(){
		Vector3 move = Vector3.Zero;
		move.x = (float) Math.sin(Math.toRadians(yaw - 90));
		move.z = (float) -Math.cos(Math.toRadians(yaw - 90));
		move.scl(speed);
		position.add(move);
	}
	
	public void moveRight(){
		Vector3 move = Vector3.Zero;
		move.x = (float) Math.sin(Math.toRadians(yaw + 90));
		move.z = (float) -Math.cos(Math.toRadians(yaw + 90));
		move.scl(speed);
		position.add(move);
	}
	
	public void turnLeft(){
		yaw -= rotSpeed;
	}
	
	public void turnRight(){
		yaw += rotSpeed;
	}
}
