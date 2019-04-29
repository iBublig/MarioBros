package com.bubliglab.game.Sprites.TileObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import com.bubliglab.game.MarioBros;
import com.bubliglab.game.Scenes.Hud;
import com.bubliglab.game.Screens.PlayScreen;
import com.bubliglab.game.Sprites.Mario;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);

        fixture.setUserData(this);

        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}
