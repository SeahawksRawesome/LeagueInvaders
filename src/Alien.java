import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	Alien(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
void update() {
		y++;
	
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);

	}
}










































































