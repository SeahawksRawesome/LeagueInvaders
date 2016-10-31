import java.awt.Graphics;

public class Rocketship extends GameObject {

	int moveValue;
	int moveValue2;

	Rocketship(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		speed = 3;

	}

	void update() {
		super.update();
		x = x + moveValue; 
		y = y - moveValue2;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

	public void startMoveLeft() {
		moveValue = -speed;

	}

	public void endMoveLeft() {
		moveValue = 0;

	}

	public void startMoveRight() {
		moveValue = speed;
	}

	public void endMoveRight() {
		moveValue = 0;
	}

	public void endMoveUp() {
		moveValue2 = 0;
	}

	public void endMoveDown() {
		moveValue2 = 0;
	}

	public void startMoveDown() {
		moveValue2 = -speed;
	}

	public void startMoveUp() {
		moveValue2 = speed;
	}

}
