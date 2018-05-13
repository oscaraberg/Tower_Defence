/**
 * Blueprints for all objects.  
 */
import java.awt.Color;

public class Object {
	
	protected int objektSize, x, y, width, height;
	protected Color c;
	
	//get methods
	
	public int getObjektSize() {
		return objektSize;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	//set methods
	
	public void setObjektSize(int objektSize) {
		this.objektSize = objektSize;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public void setColor(Color c) {
		this.c = c;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}
