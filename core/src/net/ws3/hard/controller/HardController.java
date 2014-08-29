package net.ws3.hard.controller;

import java.util.HashMap;
import java.util.Map;

import net.ws3.hard.model.HardModel;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HardController {
	public enum Keys {
		LEFT, RIGHT, UP, DOWN
	}
	
	private HardModel model;
	private static Map<Keys, Boolean> keys;
	private float touchpadX, touchpadY;
	
	public HardController(HardModel model){
		this.model = model;
		
		touchpadX = 0f;
		touchpadY = 0f;
		
		keys = new HashMap<Keys, Boolean>();
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
	}
	
	public void setTouchpadPercents(float x, float y){
		touchpadX = x;
		touchpadY = y;
	}
	
	public void leftPressed(){
		keys.put(Keys.LEFT, true);
	}
	public void leftReleased(){
		keys.put(Keys.LEFT, false);
	}
	
	public void rightPressed(){
		keys.put(Keys.RIGHT, true);
	}
	public void rightReleased(){
		keys.put(Keys.RIGHT, false);
	}
	
	public void upPressed(){
		keys.put(Keys.UP, true);
	}
	public void upReleased(){
		keys.put(Keys.UP, false);
	}
	
	public void downPressed(){
		keys.put(Keys.DOWN, true);
	}
	public void downReleased(){
		keys.put(Keys.DOWN, false);
	}
	
	private void processInput(float delta, Vector2 v){
		if(keys.get(Keys.LEFT))
			v.x -= 200 * delta;
		
		if(keys.get(Keys.RIGHT))
			v.x += 200 * delta;
		
		if(keys.get(Keys.UP))
			v.y += 200 * delta;
		
		if(keys.get(Keys.DOWN))
			v.y -= 200 * delta;
		
		v.x += touchpadX * 240 * delta;
		v.y += touchpadY * 240 * delta;
	}
	
	public void update(float delta){
		Vector2 destination = new Vector2(0f, 0f);
		Rectangle player = model.getPlayer();
		processInput(delta, destination);
		
		if(!model.isOutOfMap(player.x + destination.x, player.y, player.width, player.height))
			player.x += destination.x;
		if(!model.isOutOfMap(player.x, player.y + destination.y, player.width, player.height))
			player.y += destination.y;
	}
}