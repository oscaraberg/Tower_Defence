/**
 * colle and control all lin game.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameControler extends JPanel implements Runnable, MouseListener, MouseMotionListener{
	
	private TileMap tileMap;
	private ArrayList<Enemy> enemy;
	private Player player;
	private puseBottun puseBottun;
	
	//game loop
	private Thread thread;
	private boolean runGame = false, gameOver = false;
	private int FPS = 5;
	private long targetTime = 1000 / FPS;
	
	public GameControler() {
		
		init();
	}
	
	public void init() {
		tileMap = new TileMap("maps/tilemap2.txt");
		enemy = new ArrayList<Enemy>();
		player = new Player();
		puseBottun = new puseBottun();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	/**
	 * Game run loop
	 */
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			runGame = true;
			thread = new Thread(this);
			thread.start();
		}
		
	}
	
	/**
	 * Game run loop
	 */
	public void run() {
		long start, elapsed, wait, timerNewEnemy;
		
		timerNewEnemy = 9;
		
		while(runGame) {
			start = System.nanoTime();
			
			if (puseBottun.getPuse() == false) {
				update();
				
				// span new enemy
				if (timerNewEnemy >= 10) {
					sponEnemy(new Color(120, 13, 34),20,1,50);
					timerNewEnemy = 0;
				}
			}
			
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			timerNewEnemy++;
			
			if (wait < 0) {
				wait = 5;
			}
			// stops game if player life <= 0
			if (player.getLife() <= 0) {
				runGame = false;
				gameOver = true;
			}
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sponEnemy(Color c, int life, int speed, int attack) {
		enemy.add(new Enemy(tileMap.getTileMap(), c, life, speed, attack, new Random().nextInt(30)+20));
	}
	
	/**
	 * Calls and controls all the update metheds
	 */
	public void update() {
		for (int i = 0; i < enemy.size(); i++) {
			if(enemy.get(i).update() == 1) {
				enemy.remove(i);
				player.takeDamage(enemy.get(i).getAttack());
			}
		}
	}
	
	/**
	 * Calls and controls all the draw metheds
	 */
	
	public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2 = (Graphics2D) g;
	        tileMap.draw(g2);
	        player.draw(g2);
	        puseBottun.draw(g2);
	        for (int i = 0; i < enemy.size(); i++) {
				enemy.get(i).draw(g2);
			}
	        if (gameOver) {
				player.gameOver(g2);
			}
	        
	}
	
	/**
	 * mouse
	 */
	// mouse lisener
	@Override
	public void mouseClicked(MouseEvent e) {
		int mx, my;
		mx = e.getX();
		my = e.getY();
		
		if (mx >= puseBottun.getX() && mx <= puseBottun.getX() + puseBottun.getWidth() && 
				my >= puseBottun.getY() && my <=puseBottun.getY() + puseBottun.getHeight()) {
			puseBottun.klick();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	//Mouse motion 
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int mx, my;
		mx = e.getX();
		my = e.getY();
		//System.out.println("x: "+ mx + " y: " + my);
	}
	
}
