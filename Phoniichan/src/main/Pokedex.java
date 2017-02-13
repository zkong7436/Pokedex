package main;

import guiPractice.GuiApplication;

/**
 * @author Student8
 *
 */
@SuppressWarnings("serial")
public class Pokedex extends GuiApplication {

	/**
	 * static fields
	 */
	public static Pokedex game;
	public static PokedexScreen screen;
	
	public static void main(String[] args){
		game = new Pokedex();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() {
		screen = new LockScreen(getWidth(), getHeight());
		setScreen(screen);
	}

}
