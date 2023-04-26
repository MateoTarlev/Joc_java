package PaooGame.Entities;
import PaooGame.Enemies.EnemEntity;
import PaooGame.Game;
import PaooGame.RefLinks;

import java.awt.*;

public abstract class Entity {
    protected Game game;
    protected float x, y;
    protected int life;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean viu = true;
    private final RefLinks refLinks;

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int spriteCounter = 0;
    public int spriteNum     = 1;

    public boolean isViu() {
        return viu;
    }

    public Entity(RefLinks refLink, Game game, float x, float y, int width, int height) {
        this.refLinks = refLink;
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public void damage(int hp){
        life -= hp;
        if(life <=0) {
            viu = false;

        }
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(EnemEntity e : refLinks.getCurentState().getEntityManager().getEntities()){

            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return true; //da sunt intersetate
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle( (int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    /*public float getx()
    {
        return x;
    }
    public float gety()
    {
        return y;
    }*/
    public abstract void Update();
    public abstract void Draw(Graphics g);
}
