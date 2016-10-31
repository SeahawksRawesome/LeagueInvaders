import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	int xspeed = 2;
	int yspeed = 3;
	int counter = 0;

	Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	void update() {
		super.update();
		y += yspeed;
		x += xspeed;
		counter++;
		if (counter > 20) {
			counter = 0;
			xspeed = -xspeed;
		}
		// if (counter == .6) {
		// xspeed = xspeed;
		// counter = 0;
		// }

	}

	void draw(Graphics g) {
		
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}
}
