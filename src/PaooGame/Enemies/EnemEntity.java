package PaooGame.Enemies;

import PaooGame.RefLinks;

import java.awt.*;
import java.sql.Ref;

public abstract class EnemEntity {
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    private final RefLinks refLinks;
    protected int life;
    protected boolean viu = true;

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

    public int spriteCount = 0, spriteCount2 = 0;
    public int spriteNr    = 1, spriteNr2      = 1;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public EnemEntity(RefLinks refLinks, float x, float y, int width, int height) {
        this.refLinks = refLinks;
        this.x        = x;
        this.y        = y;
        this.width    = width;
        this.height   = height;
        this.life     = 100;
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
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return true; //da sunt intersetate
            if(getCollisionBoundsOnedin(0f,0f).intersects(getCollisionBounds(xOffset,yOffset))){
                return true;
            }
        }
        return false;
    }
    public Rectangle getCollisionBoundsOnedin(float xOffset, float yOffset) {
        return new Rectangle((int) (refLinks.getX() + 45 + xOffset), (int) (refLinks.getY() + 71 + yOffset), 55, 62) ;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle( (int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public int getLife() {
        return life;
    }

    public abstract void Update(int onedinX, int onedinY);
    public abstract void Draw(Graphics g);
}
