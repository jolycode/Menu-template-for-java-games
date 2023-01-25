package menuforgame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 800, HEIGHT = WIDTH / 8 * 9;
	private Thread thread;
	private boolean running = false;
	private Menu menu;


	
	public STATE gameState = STATE.Menu;
	public STATE gameState1 = STATE.NewGame;
	public STATE gameState2 = STATE.History;
	public STATE gameState3 = STATE.Help;
	public STATE gameState4 = STATE.About;
	public STATE gameState5 = STATE.Scores;
	//quit 6

	
	
	/*.....*/
	
	public Game() {
		menu = new Menu(this);
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "2D Simple Game", this);
	}

	public synchronized void start() {
		try {
		thread = new Thread(this);
		thread.start();
		running = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		while(running) {
			render();
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);//set backgrounds
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		 if(gameState == STATE.Menu || gameState1 == STATE.NewGame  || gameState2 == STATE.History  || gameState3 == STATE.Help  || gameState4 == STATE.About ||gameState == STATE.Quit ) {
			menu.render(g);

		}
		 /*....*/
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}
