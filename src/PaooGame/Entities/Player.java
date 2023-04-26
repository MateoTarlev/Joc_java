package PaooGame.Entities;


import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.RefLinks;

import java.awt.event.KeyListener;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Character {
    private Game game;
    private int direction = 0;
    private float x1, y1;

    public Player(int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1) {
        super(refLink, 1, refLink.GetGame(), x1, y1, life, speed, Character.Default_height, Character.Default_width);
        this.game = refLink.GetGame();
        this.x1 = x1;
        this.y1 = y1;

        bounds.x = 77;
        bounds.y = 31;
        bounds.width = 63;
        bounds.height = 150;


    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }
    @Override
    public void Update()
    {
        getInput();
        Move();
    }
    protected void drawScore(Graphics g){
        Font fnt1 = new Font("TimesRoman", Font.BOLD, 38);
        String txt  = "SCORE  ";
        String text = Integer.toString(score);
        String concat = txt.concat(text);
        int text_width = g.getFontMetrics().stringWidth(text);
        g.setColor(Color.getHSBColor(0.92f,10,0.6f));
        /*g.setColor(Color.getHSBColor(0.92f,1,0.6f));   // un rosu la fel potrivit apei*/
        g.setFont(fnt1);
        g.drawString(concat, (int) (45), (int) (81));
    }
    private void getInput() {
        xMove = 0;
        yMove = 0;
        /*if (game.getKeyManager().up)
            yMove = -speed;*/
        /*if (game.getKeyManager().down)
            yMove = speed;*/
        if (game.getKeyManager().left && game.getKeyManager().right && x >= -40 && direction == 3)
        {
            xMove = -speed;
        }
        else if(game.getKeyManager().right && game.getKeyManager().left && x <= 827 && direction == 4) {
            xMove = speed;
        }
        else if (game.getKeyManager().left && x >=-40) {
            xMove = -speed;
        }
        else if (game.getKeyManager().right && x <= 827) {
            xMove = speed;
        }
        /*if (game.getKeyManager().space)
            x1+=speed;*/


        spriteCounter++;
        if (spriteCounter > 14)
        {
            if (spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if (spriteNum == 2)
            {
                spriteNum = 3;
            }
            else if (spriteNum == 3)
            {
                spriteNum = 4;
            }
            else if (spriteNum == 4)
            {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        System.out.println("Score " + score);
        drawScore(g);
        /*if (game.getKeyManager().up && !game.getKeyManager().right && !game.getKeyManager().left) {
            if (spriteNum == 1)
                g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
            if (spriteNum == 2)
                g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);

            if (spriteNum == 3)
                g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
            if (spriteNum == 4)
                g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);
            direction = 1;
        }*/
        /*if (game.getKeyManager().down && !game.getKeyManager().right && !game.getKeyManager().left) {
            g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 2504, null);
            direction = 2;
        }*/
        if(direction == 3 && game.getKeyManager().left && game.getKeyManager().right)
        {
            if(spriteNum == 1 && game.getKeyManager().left)
                g.drawImage(Assets.OnedinBarca[8], (int) x, (int) y, 250, 250, null);
            if(spriteNum == 2 && game.getKeyManager().left) {
                g.drawImage(Assets.OnedinBarca[9], (int) x, (int)y, 250, 250, null);
            }
            if(spriteNum == 3 && game.getKeyManager().left)
            {
                g.drawImage(Assets.OnedinBarca[10], (int) x, (int) y, 250, 250, null);
            }
            if(spriteNum == 4 && game.getKeyManager().left)
            {
                g.drawImage(Assets.OnedinBarca[10], (int) x, (int) y, 250, 250, null);
                spriteCounter = 0;
            }

            direction = 3;
        }
        else if (game.getKeyManager().right && direction == 4 && game.getKeyManager().right) {

            if (spriteNum == 1 && game.getKeyManager().right)
                g.drawImage(Assets.OnedinBarca[6], (int) x, (int) y, 250, 250, null);
            if (spriteNum == 2 && game.getKeyManager().right) {
                g.drawImage(Assets.OnedinBarca[5], (int) x, (int) y, 250, 250, null);
            }
            if (spriteNum == 3 && game.getKeyManager().right) {
                g.drawImage(Assets.OnedinBarca[1], (int) x, (int) y, 250, 250, null);

            }
            if (spriteNum == 4 && game.getKeyManager().right) {
                g.drawImage(Assets.OnedinBarca[7], (int) x, (int) y, 250, 250, null);
                spriteCounter = 0;
            }

            direction = 4;

        }
        else if (game.getKeyManager().left) {
            if(spriteNum == 1 && game.getKeyManager().left)
                g.drawImage(Assets.OnedinBarca[8], (int) x, (int) y, 250, 250, null);
            if(spriteNum == 2 && game.getKeyManager().left) {
                g.drawImage(Assets.OnedinBarca[9], (int) x, (int)y, 250, 250, null);
            }
            if(spriteNum == 3 && game.getKeyManager().left)
            {
                g.drawImage(Assets.OnedinBarca[10], (int) x, (int) y, 250, 250, null);
            }
            if(spriteNum == 4 && game.getKeyManager().left)
            {
                g.drawImage(Assets.OnedinBarca[10], (int) x, (int) y, 250, 250, null);
                spriteCounter = 0;
            }

            direction = 3;
        }
        else if (game.getKeyManager().right) {

                if (spriteNum == 1 && game.getKeyManager().right)
                    g.drawImage(Assets.OnedinBarca[6], (int) x, (int) y, 250, 250, null);
                if (spriteNum == 2 && game.getKeyManager().right) {
                    g.drawImage(Assets.OnedinBarca[5], (int) x, (int) y, 250, 250, null);
                }
                if (spriteNum == 3 && game.getKeyManager().right) {
                    g.drawImage(Assets.OnedinBarca[1], (int) x, (int) y, 250, 250, null);
                }
                if (spriteNum == 4 && game.getKeyManager().right) {
                    g.drawImage(Assets.OnedinBarca[7], (int) x, (int) y, 250, 250, null);
                    spriteCounter = 0;
                }

                direction = 4;

        }


        if  (!game.getKeyManager().right && !game.getKeyManager().left ) {
            switch (direction) {
                case 0:
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);
                    break;
                case 1:
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);
                    break;

                case 2:
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);
                    break;
                case 3:
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);

                    break;
                case 4:
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinBarca[0], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinBarca[2], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinBarca[3], (int)x, (int)y, 250, 250, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinBarca[4], (int)x, (int)y, 250, 250, null);
                    break;
            }

        }



        /*g.setColor(Color.yellow);
        g.fillRect((int) (x + bounds.x - game.getGameCamera().getxOffset()),   (int) (y + bounds.y - game.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }
}
