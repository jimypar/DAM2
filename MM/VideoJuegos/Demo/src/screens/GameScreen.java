package screens;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import elements.Barril;
import elements.Player;
import game.Demo;


public class GameScreen extends BScreen{
	
Stage mainStage;
private Player player;
Array<Barril> barriles;
	   
	public GameScreen(Demo game) {
		
		super(game);
		mainStage=new Stage();
		
		player = new Player(100,100,mainStage);
		
		barriles = new Array<>();
		for (int i = 0; i < 20; i++) {
			barriles.add(new Barril(i*70+20,30,mainStage));
		}
		
	}
	@Override
	public void render(float delta) {
		
		super.render(delta);
	    mainStage.act();
	    colide();
	    mainStage.draw();
	    

	}
	
	public void colide() {
	
		for (Barril barril : barriles) {
			if (barril.getEnabled() && barril.overlaps(player)) {
				barril.preventOverlap(player);
			}
		}
		
	}
	
	
}
