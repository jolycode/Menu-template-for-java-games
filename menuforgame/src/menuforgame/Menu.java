package menuforgame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
public class Menu extends MouseAdapter implements KeyListener, ActionListener,MouseMotionListener {
	
	private Game game;

	public Menu(Game game) {
		this.game = game;
		
	}


	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu) {
		//	Music.sound2.play();  //menu music
			if(mouseOver(mx, my, 210, 150, 330, 64)) {
				Music.sound1.play();
				System.out.println("New Game");
				game.gameState = STATE.NewGame;
			}
			if(mouseOver(mx, my, 210, 300, 330, 64)) {
				Music.sound1.play();
				System.out.println("History");
				game.gameState = STATE.History;
			}
			if(mouseOver(mx, my, 210, 450, 330, 64)) {
				Music.sound1.play();
				System.out.println("Help");
				game.gameState = STATE.Help;
			}
			if(mouseOver(mx, my, 210, 600, 330, 64)) {
				Music.sound1.play();
				System.out.println("About");
				game.gameState = STATE.About;
			}
			if (mouseOver(mx, my, 210, 750, 330, 64)) {
				Music.sound1.play();
				System.out.println("quit");
				System.exit(1);
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed (KeyEvent e ){
		
	
	if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q) { 
		System.exit(1);
        }
	if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) { 
		game.gameState = STATE.Menu;

	}
	}
	public void mouseReleased(MouseEvent e) {}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < (x + width)) {
			if (my > y && my < (y + height)) {
				return true;
			} else
				return false;
		} else
			return false;
	}



	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 35);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 310, 50);

			g.setFont(fnt2);

			g.drawRect(210, 150, 330, 64);
			g.drawString("New Game", 275, 200);
			
			g.drawRect(210, 300, 330, 64);
			g.drawString("History", 310, 340);
			
			g.drawRect(210, 450, 330, 64);
			g.drawString("Help", 330, 490);
			
			g.drawRect(210, 600, 330, 64);
			g.drawString("About", 320, 640);
			
			g.drawRect(210, 750, 330, 64);
			g.drawString("Quit Game", 300, 790);
		}
		if (game.gameState4 == STATE.About) {
			Font fnt1= new Font("arial", 1, 100);
			Font fnt2 = new Font("arial", 1, 60);
			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawString("About", 310, 50);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Test about", 320, 640);
			
			
		}
	
		/*
		public STATE gameState = STATE.Menu;
		public STATE gameState1 = STATE.NewGame;
		public STATE gameState2 = STATE.History;
		public STATE gameState3 = STATE.Help;
		public STATE gameState4 = STATE.About;
		public STATE gameState5 = STATE.Scores;
		//quit 6
		*/
		
		}
		
}