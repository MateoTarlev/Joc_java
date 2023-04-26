package PaooGame.Entities;
import PaooGame.Game;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public abstract class Character extends Entity{
    //protected int life;
    protected int score;
    protected float speed;
    protected int player;
    protected int actualLife;
    public static int Default_width=64;
    protected Game game2;
    public static int Default_height=64;
    public float xMove;
    public float yMove;

    public int getLife() {
        return life;
    }
    public float getSpeed() {
        return speed;
    }
    public float getxMove() {
        return xMove;
    }
    public float getyMove() {
        return yMove;
    }



    public void Move(){
        if(player==2) {
            if (!checkEntityCollisions(0f, yMove))
                moveY();
            if (!checkEntityCollisions(xMove, 0f))
                moveX();
        }else if(player==1){
            moveY();
            moveX();
        }
    }

    public void moveX(){
        if(xMove > 0) { //miscare la dreapta
            int tempX = (int) ( x + xMove + bounds.x + bounds.width) / 4096 /*Tile.TILE_WIDTH*/  ;
            if(!collisionWithTile(tempX, (int) (y + bounds.y) / 3472 /*Tile.TILE_HEIGHT*/ ) &&
                    !collisionWithTile(tempX, (int) ( y + bounds.y +  bounds.height) / 3472 /*Tile.TILE_HEIGHT*/)){
                x += xMove;
            }
        }else if( xMove < 0 ){ // miscare la stanga
            int tempX = (int) ( x + xMove + bounds.x) / 4096 /*Tile.TILE_WIDTH*/  ;
            if(!collisionWithTile(tempX, (int) (y + bounds.y) / 3472 /*Tile.TILE_HEIGHT*/ ) &&
                    !collisionWithTile(tempX, (int) ( y + bounds.y +  bounds.height) / 3472 /*Tile.TILE_HEIGHT*/)){
                x += xMove;
            }
        }

       /* x+=xMove;*/
    }

    public void moveY(){
        if(yMove < 0){ // mergem in sus
            int tempY = (int) ( y +yMove + bounds.y ) /  3472 /*Tile.TILE_HEIGHT*/;
            System.out.println("yesss sus");
            if(!collisionWithTile( (int) ( x + bounds.x) / 4096 /*Tile.TILE_WIDTH*/, tempY ) &&
                    !collisionWithTile( (int) ( x + bounds.x + bounds.width) / 4096 /*Tile.TILE_WIDTH*/, tempY )  ){
                System.out.println("sus acum");
                y += yMove;
            }
        }else if(yMove >= 0){ // mergem in jos
            int tempY = (int) ( y + yMove + bounds.y + bounds.height) /  3472 /*Tile.TILE_HEIGHT*/;
            System.out.println("yesss jos");
            if(!collisionWithTile((int) ( x + bounds.x) / 4096 /*Tile.TILE_WIDTH*/, tempY ) &&
                    !collisionWithTile((int) ( x + bounds.x + bounds.width) / 4096 /*Tile.TILE_WIDTH*/, tempY )  ){
                System.out.println("jos acum");
                y += yMove;
            }
        }
        /*y += yMove;*/
    }

    protected boolean collisionWithTile(int x, int y){
        return game2.getWorld().getTile(x, y).isSolid();
    }

    public Character(RefLinks refLinks, int playr, Game game, float x, float y, int life, float speed, int widht, int height) {
        super(refLinks, game, x, y, widht, height);
        this.game2 = game;
        this.player = playr;
        /*this.life = life;
        this.speed = speed;
        this.xMove = xMove;
        this.yMove = yMove;*/
        this.life  = 100;
        this.score = 0;
        this.speed = 2.77f;
        this.xMove = 0;
        this.yMove = 0;
    }

    public int getScore() {
        return score;
    }
    public void incScore9(){
        score +=10;
    }
    public void incScore18(){
        score +=20;
    }

    public void incScore45(){
        score+=30;
    }
}
