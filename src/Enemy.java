/**
 * Blueprints for enemy's and/of weary basic enemy. 
 */
import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{
	
	public int life, speed, attack, gold, rowPointer, colPointer, rowOld, colOld, lastRaund;
	private Tile[][] map;

	public Enemy(Tile[][] map, Color c, int life, int speed, int attack, int gold) {
		this.map = map;
		setColor(c);
		this.life = life;
		this.speed = speed;
		this.attack = attack;
		this.gold = gold;
		lastRaund = 0;
		setObjektSize(30);
		
		startPositon();
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, objektSize, objektSize);
	}
	
	public int update() {
		
		nextTile();
		x = map[rowPointer][colPointer].getX() +4; 
		y = map[rowPointer][colPointer].getY() +4;
	
		if (lastRaund == 1) {
			return 1;
		}
		else if (map[rowPointer][colPointer+1].getTileType()==2 && colOld != colPointer+1) {
			lastRaund = 1;
		} 
		
		return 0;
	}
	
	/**
	 * Cheks were the next tile in the lane is.
	 */
	public void nextTile() {
		if (map[rowPointer][colPointer+1].getTileType()==1 && colOld != colPointer+1) {
			colOld = colPointer;
			rowOld = -2;
			colPointer ++;
		}
		else if (rowPointer-1>=0 && map[rowPointer-1][colPointer].getTileType()==1 && rowOld != rowPointer-1) {
			rowOld = rowPointer;
			colOld = -2;
			rowPointer --;
		}
		else if (rowPointer+1<=map.length && map[rowPointer+1][colPointer].getTileType()==1 && rowOld != rowPointer+1) {
			rowOld = rowPointer;
			colOld = -2;
			rowPointer ++;
		}
		else if (colPointer-1>=0 && map[rowPointer][colPointer-1].getTileType()==1 && colOld != colPointer-1) {
			colOld = colPointer;
			rowOld = -2;
			colPointer --;
		}
	}
	
	public void startPositon() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (map[row][col].getTileType() == -1) {
					rowPointer = row;
					colPointer = col;
					setX(map[row][col].getX() + 4); 
					setY(map[row][col].getY() + 4);
					return;
				} 
			}
		}
	}
	
	// get
	public int getLife() {
		return life;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getAttack() {
		return attack;
	}

	public int getGold() {
		return gold;
	}
	// set
	public void setLife(int life) {
		this.life = life;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setAtteck(int attack) {
		this.attack = attack;
	}

	public void setgold(int gold) {
		this.gold = gold;
	}
}
