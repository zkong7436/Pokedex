/**
 * 
 */
package TwentyFortyEight;

import java.awt.Color;
import java.util.ArrayList;


import guiPractice.GuiApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student 8
 *
 */
public class JimmyDemo extends GuiApplication {

	static int[][] game;
	static int temp;
	
	
	
	public static Reward reward;

	/**
	 * 
	 */
	public JimmyDemo() {
		reward = new Reward();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JimmyDemo d = new JimmyDemo();
		Thread app = new Thread(d);
		app.start();
		
		game = new int[4][4];
		int x = 0;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				game[i][j] = x;

			}
		}
		game[0][0] = 2;
		game[0][1] = 2;
		game[0][2] = 4;
		game[0][3] = 64;
		game[1][0] = 16;
		game[1][1] = 32;
		game[1][2] = 4;
		game[1][3] = 2;
		game[2][0] = 8;
		game[2][1] = 2;
		game[2][2] = 16;
		game[2][3] = 2;
		game[3][0] = 32;
		game[3][1] = 2;
		game[3][2] = 8;
		game[3][3] = 2;

		printGame(game);

	}

	// nested inner class
	private class DemoScreen extends ClickableScreen {
		private TextLabel rewardDisplay;
		private Button slideUp;
		private Button slideDown;
		private Button slideLeft;
		private Button slideRight;

		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			rewardDisplay = new TextLabel(20, 40, 1000, 25, "");
			slideUp = new Button(100, 75, 90, 40, "Up", Color.blue, new Action() {

				@Override
				public void act() {
					rotate(game, 1);
					moveTilesMinus(game);
					rotate(game, 3);
					printGame(game);
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideDown = new Button(100, 225, 90, 40, "Down", Color.blue, new Action() {

				@Override
				public void act() {
					rotate(game, 1);
					moveTilesPlus(game);
					rotate(game, 3);
					printGame(game);
					
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideRight = new Button(160, 150, 90, 40, "Right", Color.blue, new Action() {

				@Override
				public void act() {
					moveTilesMinus(game);
					printGame(game);
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideLeft = new Button(40, 150, 90, 40, "Left", Color.blue, new Action() {

				@Override
				public void act() {
					moveTilesPlus(game);
					printGame(game);
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			view.add(rewardDisplay);
			view.add(slideUp);
			view.add(slideDown);
			view.add(slideRight);
			view.add(slideLeft);
		}

	}

	

	public static void rotate(int[][] game, int numberOfRotations) {
		// rotates clockwise
		int[][] newArr = new int[4][4];
		while (numberOfRotations >= 1) {
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					newArr[j][3 - i] = game[i][j];
				}
			}
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					game[i][j] = newArr[i][j];
				}
			}
			numberOfRotations--;
		}

	}

	private static void combineTiles(int[] row) {
		for (int k = 0; k < row.length - 1; k++) {
			if (row[k] == row[k + 1]) {
				row[k] = row[k] + row[k + 1];
				row[k + 1] = 0;
			}
		}
	}

	public static void moveTilesPlus(int[][] game) {
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 0;
					while (row[temp] != 0) {
						temp++;
					}
					row[temp] = game[i][j];
				}
			}
			combineTiles(row);

			game[i] = row;
		}
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 0;
					while (row[temp] != 0) {
						temp++;
					}
					row[temp] = game[i][j];
				}
			}
			game[i] = row;
		}

	}

	public static void moveTilesMinus(int[][] game) {
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 3;
					while (row[temp] != 0) {
						temp--;
					}
					row[temp] = game[i][j];
				}
			}
			combineTiles(row);

			game[i] = row;
		}
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 3;
					while (row[temp] != 0) {
						temp--;
					}
					row[temp] = game[i][j];
				}
			}
			game[i] = row;
		}

	}

	public static void printGame(int[][] game) {
		for (int[] row : game) {
			for (int i : row) {
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();

		}
	}

}