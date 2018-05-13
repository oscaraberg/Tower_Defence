/**
 * class to create tile. Draws a rectangle and set.  
 */
import java.awt.Color;
import java.awt.Graphics;

public class Tile extends Object{

	private int tileType;
	
	public Tile(int x, int y , Color c, int tileType) {
        setX(x);
        setY(y);
        setColor(c);
        this.tileType = tileType;
        setObjektSize(40); 
    }
	 
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, objektSize, objektSize);
	}
	
	public int getTileType() {
		return tileType;
	}
	
	public void setTileType(int tileType) {
		this.tileType = tileType;
	}
}
