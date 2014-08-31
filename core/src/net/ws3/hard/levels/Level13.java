package net.ws3.hard.levels;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import net.ws3.hard.BlueCircleAccessor;
import net.ws3.hard.model.HardModel.MapState;
import net.ws3.hard.model.HardModel;
import net.ws3.hard.model.Level;

public class Level13 implements Level{

	@Override
	public void setStartPosition(Rectangle position) {
		position.x = 400;
		position.y = 100;
		position.width = 25;
		position.height = 25;
	}

	@Override
	public void setMap(Array<Rectangle> map) {
		Rectangle rect;
		
		rect = new Rectangle();
		rect.x = 225;
		rect.y = 135;
		rect.width = 350;
		rect.height = 210;
		map.add(rect);
		//start
		rect = new Rectangle();
		rect.x = 365;
		rect.y = 65;
		rect.width = 70;
		rect.height = 70;
		map.add(rect);
		//finish
		rect = new Rectangle();
		rect.x = 365;
		rect.y = 345;
		rect.width = 70;
		rect.height = 70;
		map.add(rect);
		
	}

	@Override
	public void setBlueCircles(Array<Circle> blueCircles, TweenManager manager) {
		Circle circle;
		float baseTime = 1f;
		float r = 7f;
		float temp = 17.5f;
		
		for (int i = 0 ; i < 5 ; i++)
		{		
			circle = new Circle();
			circle.x = 225 + temp + 70 * i;
			circle.y = 135 + temp;
			circle.radius = r;
			Tween.to(circle, BlueCircleAccessor.Y, baseTime)
				.target(345 - temp)
				.repeatYoyo(-1, 0f)
				.start(manager);
			blueCircles.add(circle);
		}
		
		for (int i = 0 ; i < 5 ; i++)
		{		
			circle = new Circle();
			circle.x = 260 + temp + 70 * i;
			circle.y = 345 - temp;
			circle.radius = r;
			Tween.to(circle, BlueCircleAccessor.Y, baseTime)
				.target(135 + temp)
				.repeatYoyo(-1, 0f)
				.start(manager);
			blueCircles.add(circle);
		}
		
		circle = new Circle();
		circle.x = 225 + temp;
		circle.y = 275 - temp;
		circle.radius = r;
		Tween.to(circle, BlueCircleAccessor.X, baseTime)
			.target(575 - temp)
			.repeatYoyo(-1, 0f)
			.start(manager);
		blueCircles.add(circle);
		
		circle = new Circle();
		circle.x = 575 - temp;
		circle.y = 205 + temp;
		circle.radius = r;
		Tween.to(circle, BlueCircleAccessor.X, baseTime)
			.target(225 + temp)
			.repeatYoyo(-1, 0f)
			.start(manager);
		blueCircles.add(circle);
	}

	@Override
	public void setYellowCircles(Array<Circle> yellowCircles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMapState(Array<MapState> mapState) {
		mapState.add(HardModel.MapState.PLAIN);
		mapState.add(HardModel.MapState.START);
		mapState.add(HardModel.MapState.FINISH);
		
		
	}

}