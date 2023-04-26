package PaooGame.Enemies;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.RefLinks;

import java.awt.event.KeyListener;


import java.awt.*;
import java.awt.event.KeyEvent;


public class Rechin extends EnemCharacter{
    private Game game;
    private float x1, y1;
    private int nrRechin;

    public Rechin( int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1, int ceRechin) {
        super(refLink, x1, y1, life, speed, EnemCharacter.Default_height, EnemCharacter.Default_width);
        this.nrRechin = ceRechin;
        this.game = refLink.GetGame();
        this.x1 = x1;
        this.y1 = y1;
        bounds.x = 56;
        bounds.y = 20;
        bounds.height = 144;
        bounds.width = 52;
    }

    @Override
    public void Update(int onedinX, int onedinY)
    {
        getInput();
        Move(1);
    }

    private void getInput() {
        xMove=0;
        yMove=0;

        yMove=speed;


        spriteCount++;
        if (spriteCount > 9)
        {
            if (spriteNr == 1)
            {
                /*System.out.println("Eee");*/
                spriteNr = 2;
            }
            else if (spriteNr == 2)
            {
                spriteNr = 3;
            }
            else if (spriteNr == 3)
            {
                spriteNr = 1;
            }

            spriteCount = 0;
        }
    }

    public void Draw(Graphics g)
    {
        if(nrRechin == 1) {
            if (spriteNr == 1)
                g.drawImage(Assets.rechin[0], (int) x, (int) y, 170, 230, null);
            if (spriteNr == 2) {
                g.drawImage(Assets.rechin[1], (int) x, (int) y, 170, 230, null);
            }
            if (spriteNr == 3) {
                g.drawImage(Assets.rechin[2], (int) x, (int) y, 170, 230, null);
            }
        }
        else if(nrRechin == 2){
            if (spriteNr == 1)
                g.drawImage(Assets.rechinSur[0], (int) x, (int) y, 170, 230, null);
            if (spriteNr == 2) {
                g.drawImage(Assets.rechinSur[1], (int) x, (int) y, 170, 230, null);
            }
            if (spriteNr == 3) {
                g.drawImage(Assets.rechinSur[2], (int) x, (int) y, 170, 230, null);
            }
        }
        else if(nrRechin == 3)
        {
            if (spriteNr == 1)
                g.drawImage(Assets.rechinNemo[0], (int) x, (int) y, 170, 230, null);
            if (spriteNr == 2) {
                g.drawImage(Assets.rechinNemo[1], (int) x, (int) y, 170, 230, null);
            }
            if (spriteNr == 3) {
                g.drawImage(Assets.rechinNemo[2], (int) x, (int) y, 170, 230, null);
            }
        }
        else if(nrRechin == 4)
        {
            if (spriteNr == 1)
                g.drawImage(Assets.rechinVerde[0], (int) x, (int) y, 170, 230, null);
            if (spriteNr == 2) {
                g.drawImage(Assets.rechinVerde[1], (int) x, (int) y, 170, 230, null);
            }
            if (spriteNr == 3) {
                g.drawImage(Assets.rechinVerde[2], (int) x, (int) y, 170, 230, null);
            }
        }

      /*  g.setColor(Color.MAGENTA);
        g.fillRect((int) (x + bounds.x - game.getGameCamera().getxOffset()),   (int) (y + bounds.y - game.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

    }

}
