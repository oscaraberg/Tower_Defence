/**
 * Lode file to constrakt a map and draws it. 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;

public class TileMap {
	
	private int numRow, numCol, tileSize;
	
	private int[][] map;
	private Tile[][] tileMap;
	
	private Color[] colorList;
	
	
	public TileMap(String s) {
		
		colorListInisiat();
		
		//get tile size
		tileSize = new Tile(0,0,Color.RED,0).getObjektSize();
		
		// lodes in map sturktionr from file 
		lodeFile(s);
		creatTileArray();

	}
	/**
	 * lods structior to map to int array 
	 * @param s name to lode file
	 */
	private void lodeFile(String s) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			
			numRow = Integer.parseInt(br.readLine());
			numCol = Integer.parseInt(br.readLine());
			
			map = new int[numRow][numCol];
			tileMap = new Tile[numRow][numCol];
			
			String blank = " ";
			for (int row = 0; row < numRow; row++) {
				String line = br.readLine();
				String[] tokens = line.split(blank);
				for (int col = 0; col < numCol; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
		} 
		catch (Exception e) {
			System.err.println("error lodin map file");
			System.err.println(e);
		}
	}
	
	/**
	 * create a array of tiles 
	 */
	private void creatTileArray() {
		
		for (int row = 0; row < numRow; row++) {
			for (int col = 0; col < numCol; col++) {
				if (map[row][col] == -1) {
					tileMap[row][col] = new Tile(col * tileSize, row * tileSize,
							colorList[1], map[row][col]);
				} else {
					tileMap[row][col] = new Tile(col * tileSize, row * tileSize, 
							colorList[map[row][col]], map[row][col]);
				}
			}
		}
	}
	
	/**
	 * Generate list of colors 
	 */
	
	private void colorListInisiat() {
		colorList = new Color[3];
		colorList[0] = new Color(0,100,0);
		colorList[1] = Color.BLACK;
		colorList[2] = Color.GRAY;
				
	}
	
	// draws the map
	
	public void draw(Graphics g) {
			
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
					tileMap[row][col].draw(g);
			}
		}
	}
	
	public int[][] getMap()	{
		return map;
	}
	
	public Tile[][] getTileMap() {
		return tileMap;
	}

}
