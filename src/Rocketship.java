import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	int moveValue;
	int moveValue2;

	Rocketship(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		speed = 1;
		

	}

	void update() {
		
		x = x + moveValue;
		y = y - moveValue2;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	public void startMoveLeft() {
		moveValue = -speed;

	}

	public void endMoveLeft() {
		moveValue = 0;
		
	}
	public void startMoveRight(){
		moveValue = speed;
	}
	public void endMoveRight(){
		moveValue = 0;
	}
	public void endMoveUp(){
		moveValue2 = 0;
	}
	public void endMoveDown(){
		moveValue2 = 0;
	}
	public void startMoveDown(){
		moveValue2 = -speed;
	}
	public void startMoveUp(){
		moveValue2 = speed;
	}
	
	
	
}
