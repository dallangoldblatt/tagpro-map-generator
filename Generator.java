import java.io.*;
import java.util.*;
import java.awt.Color;
import java.awt.image.*;

import javax.imageio.ImageIO;

public class Generator {
	public static BufferedImage ximg = null;
	public static BufferedImage img = null;
	public static int v = new Color(0,0,0).getRGB(),
					  wall = new Color(120,120,120).getRGB(),
					  tile = new Color(212,212,212).getRGB(),
					  gate = new Color(0,117,0).getRGB(),
					  spike = new Color(55,55,55).getRGB();

	public static void main(String args[])throws IOException{

	    try{
	      ximg = ImageIO.read(new File("C:\\Coding\\Eclipse\\workspace\\TagProMapGen\\src\\base.png"));
	    }catch(IOException e){
	      System.out.println(e);
	    }
	    img = new BufferedImage(ximg.getWidth(), ximg.getHeight(), BufferedImage.TYPE_INT_BGR);
	    img.getGraphics().drawImage(ximg, 0, 0, null);

	    // section 1
	    fillSection(5, 3, 8, 28);
	    // section 2
	    fillSection(4, 3, 14, 15);
	    // section 3
	    fillSection(5, 3, 19, 18);
	    // section 4
	    fillSection(9, 3, 25, 12);
	    // section 5
	    fillSection(5, 33, 8, 58);
	    // section 6
	    fillSection(5, 23, 19, 38);
	    // section 7
	    fillSection(9, 17, 25, 28);
	    // section 8
	    fillSection(4, 20, 14, 41);
	    // section 9
	    fillSection(9, 33, 25, 44);
	    // section 10
	    fillSection(4, 46, 14, 58);
	    // section 11
	    fillSection(5, 43, 19, 58);
	    // section 12
	    fillSection(9, 49, 25, 58);
	    // section 13
	    fillSection(3, 3, 35, 58);

	    try{
	    	ImageIO.write(img, "png", new File("C:\\Users\\justdal1\\Desktop\\Randomly Generated Map.png"));
	    	File afile = new File("C:\\Coding\\Eclipse\\workspace\\TagProMapGen\\src\\base.json");
			File bfile = new File("C:\\Users\\justdal1\\Desktop\\Randomly Generated Map.json");
			InputStream inStream = new FileInputStream(afile);
			OutputStream outStream = new FileOutputStream(bfile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inStream.read(buffer)) > 0){outStream.write(buffer, 0, length);}
			inStream.close();
			outStream.close();
	    }catch(IOException e){
	        System.out.println(e);
	    }
	}

	public static int draw(int[][] tiles, int x, int y) {
		int startX = x;
		for ( int[] row: tiles ) {
			for ( int tile: row ){
				img.setRGB(x,y,tile);
				x++;
			}
			y++;
			x = startX;
		}
		return tiles[0].length;
	}

	public static void fillSection(int height, int x, int y, int max ) {
		int[][] element;
		while (x <= max) {
			element = getXHigh(height);
			if ( x + element[0].length > max+1 )
				element = getXHigh(height);
			if ( x + element[0].length > max+1 )
				element = getXHigh(height);
			if ( x + element[0].length > max+1 )
				break;
			x += draw(element,x,y);
		}
	}

	public static int[][] getXHigh(int x) {
		int [][] tiles = {{}};
		switch (x) {
		case 3: tiles = get3High();
				break;
		case 4: tiles = get4High();
				break;
		case 5: tiles = get5High();
				break;
		case 9: tiles = get9High();
		}
		return tiles;
	}

	public static int[][] get3High() {
		List<int[][]> list = new ArrayList<int[][]>();
		int[][] option1 = {{v},
						{v},
						{v}};
		list.add(option1);
		int[][] option2 = {{v, v, v, gate},
						{v, v, v, v},
						{v, gate, v, v}};
		list.add(option2);
		int[][] option3 = {{v, v, v, gate, v, v, v, gate},
						{v, v, v, v, v, v, v, v},
						{v, gate, v, v, v, gate, v, v}};
		list.add(option3);
		int[][] option4 = {{v, v, v, v, spike},
						{v, v, v, v, v},
						{v, v, spike, v, v}};
		list.add(option4);
		int [][] option5 = {{v, v, v, v, v},
						{v, v, v, v, v},
						{v, gate, gate, gate, v}};
		list.add(option5);
		return list.get(new Random().nextInt(list.size()));
	}

	public static int[][] get4High() {
		List<int[][]> list = new ArrayList<int[][]>();
		int[][] option1 = {{v},
						{v},
						{v},
						{v}};
		list.add(option1);
		int[][] option2 = {{v, v, gate},
						{v, v, v},
						{v, v, v},
						{v, v, gate}};
		list.add(option2);
		int[][] option3 = {{v, v, v},
						{v, v, v},
						{v, v, gate},
						{v, v, gate}};
		list.add(option3);
		int[][] option4 = {{v, gate, v, v, v, gate},
						{v, v, v, v, v, v},
						{v, v, v, gate, v, v},
						{v, v, v, gate, gate, v}};
		list.add(option4);
		int[][] option5 = {{v, v, v},
						{v, v, spike},
						{v, v, spike},
						{v, v, spike}};
		list.add(option5);
		int[][] option6 = {{v, v, v, v, gate, v, v},
						{v, v, v, v, gate, v, v},
						{v, v, v, v, v, v, v},
						{v, v, gate, v, v, v, gate}};
		list.add(option6);
		int[][] option7 = {{v, v, v, v, v, gate, v},
						{v, v, v, v, v, v, gate},
						{v, v, v, gate, v, v, v},
						{v, v, gate, v, gate, v, v}};
		list.add(option7);
		int[][] option8 = {{v, v, v, v, v, spike, v},
						{v, v, v, v, v, v, v},
						{v, v, v, spike, v, v, v},
						{v, v, spike, v, spike, v, spike}};
		list.add(option8);
		int[][] option9 = {{v, v, spike, v, spike},
						{v, v, spike, v, v},
						{v, v, spike, v, v},
						{v, v, v, v, spike}};
		list.add(option9);
		return list.get(new Random().nextInt(list.size()));
	}

	public static int[][] get5High() {
		List<int[][]> list = new ArrayList<int[][]>();
		int[][] option1 = {{v},
						{v},
						{v},
						{v},
						{v}};
		list.add(option1);
		int[][] option2 = {{v, v, gate },
						{v, v, v},
						{v, v, v},
						{v, v, gate},
						{v, v, gate}};
		list.add(option2);
		int[][] option3 = {{v, v, gate },
						{v, v, gate},
						{v, v, v},
						{v, v, v},
						{v, v, gate}};
		list.add(option3);
		int[][] option4 = {{v, v, v, v, gate, gate },
						{v, v, v, v, v, gate},
						{v, v, gate, v, v, gate},
						{v, v, gate, v, v, v},
						{v, v, gate, gate, v, v}};
		list.add(option4);
		int[][] option5 = {{spike, spike, spike, spike},
						{v, v, v, spike},
						{v, v, v, v},
						{v, v, spike, v},
						{v, v, spike, v}};
		list.add(option5);
		int[][] option6 = {{v, v, v, v, gate, v, gate},
						{v, v, v, v, v, v, v},
						{v, v, gate, v, v, v, v},
						{v, v, v, v, v, v, v},
						{v, v, v, v, gate, v, gate}};
		list.add(option6);
		int[][] option7 = {{v, v, v, gate, v, v, v, v},
						{v, v, gate, v, v, v, v, v},
						{v, v, v, v, v, gate, v, v},
						{v, v, v, v, gate, v, v, v},
						{v, v, spike, v, v, v, v, gate}};
		list.add(option7);
		int[][] option8 = {{v, v, gate, v, v, v, gate},
						{v, v, v, v, v, v, v},
						{v, v, v, v, gate, v, v},
						{v, v, v, v, v, v, v},
						{v, v, gate, v, v, v, gate}};
		list.add(option8);
		int[][] option9 = {{v, v, spike, v, v, v, spike, v, v, v, spike},
						{v, v, v, v, spike, v, v, v, v, v, v},
						{v, v, wall, wall, wall, v, v, v, spike, v, v},
						{v, v, v, v, v, wall, v, v, spike, v, v},
						{v, v, spike, spike, spike, spike, spike, spike, spike, v, spike}};
		list.add(option9);
		return list.get(new Random().nextInt(list.size()));
	}

	public static int[][] get9High() {
		List<int[][]> list = new ArrayList<int[][]>();
		int[][] option1 = {{v},
						{v},
						{v},
						{v},
						{v},
						{v},
						{v},
						{v},
						{v}};
		list.add(option1);
		int[][] option2 = {{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, v},
						{v, v, v},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate}};
		list.add(option2);
		int[][] option3 = {{v, v, gate},
						{v, v, gate},
						{v, v, v},
						{v, v, v},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate}};
		list.add(option3);
		int[][] option4 = {{v, v, v},
						{v, v, v},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate},
						{v, v, gate}};
		list.add(option4);
		int[][] option5 = {{v, v, v, v, gate, v},
						{v, v, v, v, gate, v},
						{v, v, v, v, gate, v},
						{v, v, v, v, v, gate},
						{v, v, gate, v, v, v},
						{v, v, v, gate, v, v},
						{v, v, v, gate, v, v},
						{v, v, v, gate, v, v},
						{v, v, v, gate, v, v}};
		list.add(option5);
		int[][] option6 = {{v, v, v, gate, v, v},
						{v, v, gate, v, v, v},
						{v, v, v, v, v, gate},
						{v, v, v, v, v, v},
						{v, v, gate, v, v, gate},
						{v, v, v, wall, gate, v},
						{v, v, v, v, v, v},
						{v, v, gate, v, v, v},
						{v, v, gate, v, gate, v}};
		list.add(option6);
		int[][] option7 = {{v, v, spike, v, spike},
						{v, v, spike, v, spike},
						{v, v, v, v, spike},
						{v, v, v, v, spike},
						{v, v, spike, v, spike},
						{v, v, spike, v, spike},
						{v, v, spike, v, spike},
						{v, v, spike, v, spike},
						{v, v, spike, v, v}};
		list.add(option7);
		return list.get(new Random().nextInt(list.size()));
	}
}
