package PaooGame.Enemies;

import PaooGame.RefLinks;

public abstract class EnemCharacter extends EnemEntity{
    protected float speed;
    protected int actualLife;
    public static int Default_width=64;
    public static int Default_height=64;
    public float xMove;
    public float yMove;


    public float getSpeed() {
        return speed;
    }
    public float getxMove() {
        return xMove;
    }
    public float getyMove() {
        return yMove;
    }

    public void Move(int level){
        /*x+=xMove;
        y+=yMove;*/
        if(level == 2) {
            if (!checkEntityCollisions(0f, yMove))
                y += yMove;
            if (!checkEntityCollisions(xMove, 0f))
                x += xMove;
        }else if(level == 1){
            x+=xMove;
            y+=yMove;
        }
    }



    public EnemCharacter(RefLinks refLinks,float x, float y, int life, float speed, int widht, int height) {
        super(refLinks, x, y, widht, height);
        this.speed = speed;
        this.xMove = 0;
        this.yMove = 0;
    }
}
