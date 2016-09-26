import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame f1;
	static final int height = 500;
	static final int width = 800;
	GamePanel invader;
	//League Invaders Pt.1 
	//Runner Class and Window

	//*NOTE* 
	//For every class you create, you should automatically make a constructor. If you don't know what that means, refer to level 1. 
	
	public static void main(String[] args) 
	{
	
	LeagueInvaders m = new LeagueInvaders();
	

	}

LeagueInvaders(){
	
	f1 = new JFrame();
	f1.setVisible(true);
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f1.setSize(height, width);
	 invader = new GamePanel();
	 f1.add(invader);	
	 invader.startGame();
	 f1.addKeyListener(invader);
	 
}
	
}
