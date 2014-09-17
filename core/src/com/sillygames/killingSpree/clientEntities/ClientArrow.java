package com.sillygames.killingSpree.clientEntities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.sillygames.killingSpree.managers.WorldRenderer;
import com.sillygames.killingSpree.pool.AssetLoader;
import com.sillygames.killingSpree.serverEntities.ServerArrow;
import com.sillygames.killingSpree.serverEntities.ServerBlob;

public class ClientArrow extends ClientEntity {
    
    private Sprite sprite;
    boolean markForDispose;
    
    public ClientArrow(short id, float x, float y) {
        super(id, x, y);
        markForDispose = false;
        sprite = new Sprite(AssetLoader.instance.getTexture("sprites/arrow.png"));
        sprite.setSize(ServerArrow.RADIUS * 16 * WorldRenderer.SCALE, 
                ServerArrow.RADIUS * 4 * WorldRenderer.SCALE);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(x * WorldRenderer.SCALE - sprite.getWidth() / 2,
                y * WorldRenderer.SCALE - sprite.getHeight() / 2);
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
//        Gdx.app.log("Angle", Float.toString(angle * MathUtils.radiansToDegrees));
        sprite.setPosition(position.x * WorldRenderer.SCALE - sprite.getWidth() / 2,
                position.y * WorldRenderer.SCALE - sprite.getHeight() / 2);
        sprite.setRotation(angle * MathUtils.radiansToDegrees);
        sprite.draw(batch);
    }

    @Override
    public void dispose() {
    }

}
