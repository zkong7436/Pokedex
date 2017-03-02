package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import guiPractice.components.Component;
import guiPractice.components.Graphic;

/**
 * @author Student 8
 *
 */
public class MyDemo extends Component {
	public MyDemo(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

	@Override
	public void update(Graphics2D g) {
		int[][]a = new int[4][4];
//		a[0][0] = 2;
//		a[0][3] = 2;
		SpawnDemo.start(a);
		int y = 1;
		int z = 1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		String pics[] = { "resources/images2048/grass.jpg" , "resources/images2048/bulbasaur.png",
		"resources/images2048/ivysaur.jpg" }; // this is filler.. we don't have ivysaur sprite in images2048 yet
		//changeImages();
		int height = 80,width = 80;
//		Graphic picture1 = new Graphic(0,0,80,80,"resources/images2048/grass.jpg");

		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				y = a[row][col];
					if( y> 0){
						 z= (int) (Math.log(y)/Math.log(2));
					}
					else{
						z = 0;
					}
				 
					Graphic picture2 = new Graphic(col*width,row*height,80,80,pics[z]);
					g.drawImage(picture2.getImage(), picture2.getX(), picture2.getY(), null);
					g.drawRect(col*width,row*height, width, height);
		
		}	
		}
	}
}	


	
//	public void changeImages(){
//		// checks array values.
//		// if its 2 then it will be bulbasaur
//		// default (0) = grass img
//		for (int row = 0; row < board.length; row++) {
//			for (int col = 0; col < board[row].length; col++) {
//				changeBoard[row][col] = (int) Math.sqrt(board[row][col]);
// 			}
//		}
////		// if values of chaneBoard[row][col] == 0  -> img is grass
////		== 1 image is bulbasaur
////				 == 2 is ivysaur
//	}

	
	

//	public void start(){
//		ArrayList<Integer> Nrow = new ArrayList<Integer>();
//		ArrayList<Integer> Ncol = new ArrayList<Integer>();
//		for (int row = 0; row < board.length; row++) {
//			for (int col= 0; col < board.length; col++) {
//				if(board[row][col] == 0){
//					Nrow.add(row);
//					Ncol.add(col);
//					//will add row and col of all unfilled squares
//				}
//			}
//			for (int i = 0; i < 2; i++) {
//				int rndX = (int)(Nrow.size()*Math.random());
//				int rndY = (int)(Ncol.size()*Math.random());
//				int expo = (int) ((1 * Math.random()) + 1); // (0 or 1) + 1;
//				// 
//				// 2 ^1 = 2; 2^2 = 4;  it will random 
//				board[rndX][rndY] = (int) Math.pow(2, expo);
//				Nrow.remove(rndX);
//				Nrow.remove(rndY);
//				
//			}
//		}
//		
//	}
	

