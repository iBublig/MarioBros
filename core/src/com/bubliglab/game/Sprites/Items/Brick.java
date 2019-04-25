package com.bubliglab.game.Sprites.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.bubliglab.game.MarioBros;
import com.bubliglab.game.Scenes.Hud;
import com.bubliglab.game.Screens.PlayScreen;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);

        fixture.setUserData(this);

        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick", "Collision");
        setCategoryFilter(MarioBros.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
        MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
    }
}
