import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	Projectile(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		speed = 10;

	}

	void update() {
		super.update();
		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}

	}

	void draw(Graphics g) {
		
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}
}
