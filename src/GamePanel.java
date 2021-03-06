import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	GameObject Player;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font titleFont2;
	Rocketship league;
	ObjectManager manage = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	GamePanel() {

		
		  try { 
			  alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
	rocketImg =  ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		  bulletImg =  ImageIO.read(this.getClass().getResourceAsStream("bullet.png")); }
		  catch (IOException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 

		league = new Rocketship(250, 700, 50, 50);

		
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFont2 = new Font("Arial", Font.PLAIN, 20);

		manage.addObject(league);
		time = new Timer(1000 / 60, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		time.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manage.checkCollision();
		manage.update();
		manage.manageEnemies();
		if (!league.isAlive) {
			currentState = END_STATE;
			manage.reset();
			league = new Rocketship(250, 700, 50, 50);
			manage.addObject(league);
			
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.height, LeagueInvaders.width);
		g.setColor(Color.GREEN);
		g.setFont(titleFont);
		g.drawString("LEAGUEINVADERS!", 40, 100);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to start", 130, 300);
		g.drawString("Press SPACE for instructions!!", 100, 500);
	}

	void drawGameState(Graphics g) {
		manage.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.height, LeagueInvaders.width);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("GAME OVER!!", 60, 100);
		g.setFont(titleFont2);
		g.drawString("You Killed " + manage.getScore() + " aliens", 130, 300);
		g.drawString("Press BACKSPACE to Resart", 100, 500);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = GAME_STATE;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			currentState = MENU_STATE;
			manage.setScore(0);
		}
		if (currentState == GAME_STATE) {
			switch (key) {
			case KeyEvent.VK_LEFT:
				league.startMoveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				league.startMoveRight();
				break;
			case KeyEvent.VK_UP:
				league.startMoveUp();
				break;
			case KeyEvent.VK_DOWN:
				league.startMoveDown();
				break;
			case KeyEvent.VK_SPACE:
				manage.addObject(new Projectile(league.x + 20, league.y - 10, 10, 10));

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (currentState == GAME_STATE) {
			switch (key) {
			case KeyEvent.VK_LEFT:
				league.endMoveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				league.endMoveRight();
				break;
			case KeyEvent.VK_UP:
				league.endMoveUp();
				break;
			case KeyEvent.VK_DOWN:
				league.endMoveDown();

			}

		}

	}
}
