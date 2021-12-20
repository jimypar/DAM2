package elements;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends Element {

	private Animation<TextureRegion> frente;
	private Animation<TextureRegion> espalda;
	private Animation<TextureRegion> derecha;
	private Animation<TextureRegion> izquierda;
	private float walkingSpeed = 200;

	public Player(float x, float y, Stage s) {
		super(x, y, s);

		this.maxSpeed = 500;
		this.deceleration = 3000;
		
		frente = loadFullAnimation("player/frenteWalk.png", 4, 1, 0.2f, true);
		espalda = loadFullAnimation("player/espaldaWalk.png", 1, 4, 0.2f, true);
		derecha = loadFullAnimation("player/derechawalk.png", 1, 4, 0.2f, true);
		izquierda = loadFullAnimation("player/izquieredawalk.png", 4, 1, 0.2f, true);

		this.setPolygon(7);
		
		this.setScale(10);

	}

	@Override
	public void act(float delta) {
		super.act(delta);

		controles();
		this.applyPhysics(delta);

	}

	private void controles() {

		if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
			this.setAnimation(espalda);
			this.acceleration.add(0,walkingSpeed);
		}

		if (Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)) {
			this.setAnimation(frente);
			this.acceleration.add(0,-walkingSpeed);
		}

		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
			this.setAnimation(izquierda);
			this.acceleration.add(-walkingSpeed,0);

		}

		if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
			this.setAnimation(derecha);
			this.acceleration.add(walkingSpeed,0);
		}

	}

}
