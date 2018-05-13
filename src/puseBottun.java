/**
 *	bottun to pase enemy and tower from update
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class puseBottun extends Object{
	
	private boolean puse = false;

	public puseBottun() {
		x = 1400;
		y = 5;
		width = 100;
		height = 30;
	}

	public void draw(Graphics g) {
		// botton
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		// text
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", 1, 20)); 
		g.drawString("puse", x + 25, y + height -7);
		
	}
	
	public void klick() {
		if (puse == false) {
			puse = true;
		} else {
			puse = false;
		}
	}
	
	public boolean getPuse() {
		return puse;
	}
}
