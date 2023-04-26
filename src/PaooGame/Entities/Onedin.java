package PaooGame.Entities;


import PaooGame.Enemies.EnemEntity;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.RefLinks;

import java.awt.event.KeyListener;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Onedin extends Character {
    private Game game;
    private int direction = 0, spriteAtack = 1, atackCounter = 0, flag = 0;
    private float x1, y1;
    private RefLinks refLink;

    public Onedin(int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1) {
        super(refLink, 2, refLink.GetGame(), x1, y1, life, speed, Character.Default_height, Character.Default_width);
        this.game = refLink.GetGame();
        this.x1 = x1;
        this.y1 = y1;

        bounds.x = 45;
        bounds.y = 71;
        bounds.width = 55;
        bounds.height = 62;
    }

    protected void drawLife(Graphics g){
        Font fnt1 = new Font("TimesRoman", Font.BOLD, 19);
        String text = Integer.toString(life);
        String txt  = "%";
        String concat = text.concat(txt);
        int text_width = g.getFontMetrics().stringWidth(text);
        g.setColor(Color.getHSBColor(0.92f,10,0.6f));
       // g.setColor(Color.getHSBColor(0.92f,1,0.6f));   // un rosu la fel potrivit apei
        g.setFont(fnt1);
        g.drawString(concat, (int) (x - 9 - game.getGameCamera().getxOffset() + bounds.x + bounds.width/2 - text_width/2), (int) (y + 6 - game.getGameCamera().getyOffset()));
    }


    public void growX(){
        x = x+4;
    }
    public void scadeX(){
        x = x-4;
    }
    /*public void growY() { y = y + 4; }*/
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
        /*if(y>789)*/
        //checkAttacks();
        game.getGameCamera().centerOnOnedin(this);
    }

    private void checkAttacks(){
        Rectangle cb = getCollisionBounds(0f,0f);
        Rectangle ar = new Rectangle();
        int arSize   = 40;
        ar.width     = 40;
        ar.height    = 40;

        if(game.getKeyManager().up ){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(game.getKeyManager().down ){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(game.getKeyManager().left ){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else if(game.getKeyManager().right ){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else{
            return;
        }

            for (EnemEntity e : game.getLevel2State().getEntityManager().getEntities()) {
                if (e.getCollisionBounds(0f, 0f).intersects(ar)) {
                    //System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    e.damage(5);
                    return;
                }
            }

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(y>=50 && y <1657 && !game.getKeyManager().space && flag==0)
        {   //speed = 2.9f
           /* if (game.getKeyManager().up && direction == 1 )
                yMove = -7.9f;*/
            if (game.getKeyManager().down && direction == 2 )
                yMove = 19f;
        }else if(!game.getKeyManager().space && flag==0){
            if (game.getKeyManager().up && direction == 1 )
                yMove = -19f;
            if (game.getKeyManager().down && direction == 2 )
                yMove = 19f;
            if (game.getKeyManager().left && game.getKeyManager().right && direction == 3) {
                xMove = -19f;
            } else if (game.getKeyManager().right && game.getKeyManager().left && direction == 4) {
                xMove = 19f;
            } else if (game.getKeyManager().left ) {
                xMove = -19f;
            } else if (game.getKeyManager().right ) {
                xMove = 19f;
            }
        }
        //*********next

        if(y>=1657 && x>=448 && !game.getKeyManager().space) {
            if (game.getKeyManager().up && direction == 1 )
                yMove = -19f;
            if (game.getKeyManager().down && direction == 2)
                yMove = 19f;

            if (game.getKeyManager().left && game.getKeyManager().right && direction == 3 && x>=448) {
                xMove = -19f;
                direction = 3;
            } else if (game.getKeyManager().right && game.getKeyManager().left && direction == 4 && x>=448) {
                xMove = 19f;
                direction = 4;
            } else if (game.getKeyManager().left && x>=448 && direction == 3) {
                direction = 4;
                xMove = -19f;
            } else if (game.getKeyManager().right && direction == 4) {
                direction = 3;
                xMove = 19f;
            }
        }

        spriteCounter++;
        if(game.getKeyManager().space) {
            atackCounter++;
            if (atackCounter > 1) {
                if (spriteAtack == 1) {
                    spriteAtack = 2;
                } else if (spriteAtack == 2) {
                    spriteAtack = 3;
                } else if (spriteAtack == 3) {
                    spriteAtack = 4;
                } else if (spriteAtack == 4) {
                    spriteAtack = 5;

                    checkAttacks();

                } else if (spriteAtack == 5) {
                    spriteAtack = 6;

                    checkAttacks();

                } else if (spriteAtack == 6) {
                    spriteAtack = 1;
                }

                atackCounter = 0;
            }
        }

        if (spriteCounter > 1) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2) {
                spriteNum = 3;
            }
            else if (spriteNum == 3) {
                spriteNum = 4;
            }
            else if (spriteNum == 4) {
                spriteNum = 5;
            }
            else if (spriteNum == 5) {
                spriteNum = 6;
            }
            else if (spriteNum == 6) {
                spriteNum = 7;
            }
            else if (spriteNum == 7) {
                spriteNum = 8;
            }
            else if (spriteNum == 8) {
                spriteNum = 9;
            }
            else if (spriteNum == 9) {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        drawLife(g);
        if(!game.getKeyManager().space) {
            if (direction == 3 && game.getKeyManager().left && game.getKeyManager().right) {
                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[1][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[1][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[1][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[1][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[1][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[1][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[1][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[1][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);


                direction = 3;
            } else if (game.getKeyManager().right && direction == 4 && game.getKeyManager().right) {

                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[3][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[3][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[3][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[3][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[3][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[3][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[3][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[3][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[3][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);


                direction = 4;

            } else if (game.getKeyManager().left) {
                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[1][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[1][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[1][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[1][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[1][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[1][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[1][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[1][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                direction = 3;
            } else if (game.getKeyManager().right) {

                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[3][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[3][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[3][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[3][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[3][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[3][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[3][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[3][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[3][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);


                direction = 4;

            }

            //****************************
            if (direction == 1 && game.getKeyManager().up && game.getKeyManager().down && !game.getKeyManager().left && !game.getKeyManager().right) {
                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[0][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[0][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[0][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[0][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[0][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[0][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[0][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[0][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[0][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);


                direction = 1;
            } else if (game.getKeyManager().down && direction == 2 && game.getKeyManager().up && !game.getKeyManager().left && !game.getKeyManager().right) {

                if (spriteNum == 1)
                    g.drawImage(Assets.OnedinWalk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 2)
                    g.drawImage(Assets.OnedinWalk[2][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 3)
                    g.drawImage(Assets.OnedinWalk[2][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 4)
                    g.drawImage(Assets.OnedinWalk[2][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 5)
                    g.drawImage(Assets.OnedinWalk[2][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 6)
                    g.drawImage(Assets.OnedinWalk[2][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 7)
                    g.drawImage(Assets.OnedinWalk[2][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 8)
                    g.drawImage(Assets.OnedinWalk[2][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                if (spriteNum == 9)
                    g.drawImage(Assets.OnedinWalk[2][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                direction = 2;

            } else if (game.getKeyManager().down) {
                if (direction == 3 || direction == 4) {
                    if (direction == 3) {
                        direction = 3;
                    } else {
                        direction = 4;
                    }
                } else {
                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinWalk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinWalk[2][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinWalk[2][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinWalk[2][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 5)
                        g.drawImage(Assets.OnedinWalk[2][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 6)
                        g.drawImage(Assets.OnedinWalk[2][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 7)
                        g.drawImage(Assets.OnedinWalk[2][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 8)
                        g.drawImage(Assets.OnedinWalk[2][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 9)
                        g.drawImage(Assets.OnedinWalk[2][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                }
                direction = 2;
            } else if (game.getKeyManager().up) {
                if (direction == 3 || direction == 4) {
                    if (direction == 3) {
                        direction = 3;
                    } else {
                        direction = 4;
                    }
                } else {

                    if (spriteNum == 1)
                        g.drawImage(Assets.OnedinWalk[0][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 2)
                        g.drawImage(Assets.OnedinWalk[0][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 3)
                        g.drawImage(Assets.OnedinWalk[0][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 4)
                        g.drawImage(Assets.OnedinWalk[0][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 5)
                        g.drawImage(Assets.OnedinWalk[0][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 6)
                        g.drawImage(Assets.OnedinWalk[0][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 7)
                        g.drawImage(Assets.OnedinWalk[0][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 8)
                        g.drawImage(Assets.OnedinWalk[0][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                    if (spriteNum == 9)
                        g.drawImage(Assets.OnedinWalk[0][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                }

                direction = 1;

            }



            if (!game.getKeyManager().right && !game.getKeyManager().left && !game.getKeyManager().up && !game.getKeyManager().down) {
                switch (direction) {
                    case 0:
                        g.drawImage(Assets.OnedinWalk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                        break;
                    case 1:
                        g.drawImage(Assets.OnedinWalk[0][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                        break;

                    case 2:
                        g.drawImage(Assets.OnedinWalk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                        break;
                    case 3:
                        g.drawImage(Assets.OnedinWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                        break;
                    case 4:
                        g.drawImage(Assets.OnedinWalk[3][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                        break;
                }

            }
        }else {


            switch (direction) {
                case 0:
                    if (spriteAtack == 1)
                        g.drawImage(Assets.OnedinAtack[2][0], (int)(x - game.getGameCamera().getxOffset() - 46), (int)(y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                    if (spriteAtack == 2)
                        g.drawImage(Assets.OnedinAtack[2][1], (int)(x - game.getGameCamera().getxOffset() - 46 - 23), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 3)
                        g.drawImage(Assets.OnedinAtack[2][2], (int)(x - game.getGameCamera().getxOffset() - 46 - 41), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 4)
                        g.drawImage(Assets.OnedinAtack[2][3], (int)(x - game.getGameCamera().getxOffset() - 94 - 53), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 5)
                        g.drawImage(Assets.OnedinAtack[2][4], (int)(x - game.getGameCamera().getxOffset() - 46 - 67), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 6)
                        g.drawImage(Assets.OnedinAtack[2][5], (int)(x - game.getGameCamera().getxOffset() - 46 - 82), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    break;
                case 1:
                    if (spriteAtack == 1)
                        g.drawImage(Assets.OnedinAtack[0][0], (int)(x - game.getGameCamera().getxOffset()-41), (int)(y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                    if (spriteAtack == 2)
                        g.drawImage(Assets.OnedinAtack[0][1], (int)(x - game.getGameCamera().getxOffset()-41 - 18), (int)(y - game.getGameCamera().getyOffset()+ 25 - 96 - 9), 425, 400, null);
                    if (spriteAtack == 3)
                        g.drawImage(Assets.OnedinAtack[0][2], (int)(x - game.getGameCamera().getxOffset()-41 - 40), (int)(y - game.getGameCamera().getyOffset()+ 25 - 96 - 9), 425, 400, null);
                    if (spriteAtack == 4)
                        g.drawImage(Assets.OnedinAtack[0][3], (int)(x - game.getGameCamera().getxOffset()-41 - 61), (int)(y - game.getGameCamera().getyOffset()+ 25 - 96 - 9), 425, 400, null);
                    if (spriteAtack == 5)
                        g.drawImage(Assets.OnedinAtack[0][4], (int)(x - game.getGameCamera().getxOffset()-41 - 81), (int)(y - game.getGameCamera().getyOffset()+ 25 - 96 - 9), 425, 400, null);
                    if (spriteAtack == 6)
                        g.drawImage(Assets.OnedinAtack[0][5], (int)(x - game.getGameCamera().getxOffset()-41 - 105), (int)(y - game.getGameCamera().getyOffset()+ 25 - 96 - 9), 425, 400, null);
                    break;
                case 2:
                    if (spriteAtack == 1)
                        g.drawImage(Assets.OnedinAtack[2][0], (int)(x - game.getGameCamera().getxOffset() - 46), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 2)
                        g.drawImage(Assets.OnedinAtack[2][1], (int)(x - game.getGameCamera().getxOffset() - 46 - 23), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 3)
                        g.drawImage(Assets.OnedinAtack[2][2], (int)(x - game.getGameCamera().getxOffset()- 46 - 41), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 4)
                        g.drawImage(Assets.OnedinAtack[2][3], (int)(x - game.getGameCamera().getxOffset()- 94 - 53), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 5)
                        g.drawImage(Assets.OnedinAtack[2][4], (int)(x - game.getGameCamera().getxOffset()- 46 - 67), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    if (spriteAtack == 6)
                        g.drawImage(Assets.OnedinAtack[2][5], (int)(x - game.getGameCamera().getxOffset()- 46 - 82), (int)(y - game.getGameCamera().getyOffset() - 194+ 25), 425, 400, null);
                    break;
                case 3:
                    if (spriteAtack == 1)
                        g.drawImage(Assets.OnedinAtack[1][0], (int)(x - game.getGameCamera().getxOffset()-48), (int)(y - game.getGameCamera().getyOffset() - 142  +25), 425, 400, null);
                    if (spriteAtack == 2)
                        g.drawImage(Assets.OnedinAtack[1][1], (int)(x - game.getGameCamera().getxOffset()-48 - 12), (int)(y - game.getGameCamera().getyOffset()- 142+25), 425, 400, null);
                    if (spriteAtack == 3)
                        g.drawImage(Assets.OnedinAtack[1][2], (int)(x - game.getGameCamera().getxOffset()-48 -36), (int)(y - game.getGameCamera().getyOffset()- 142+25), 425, 400, null);
                    if (spriteAtack == 4)
                        g.drawImage(Assets.OnedinAtack[1][3], (int)(x - game.getGameCamera().getxOffset()-48 - 56), (int)(y - game.getGameCamera().getyOffset()- 142+25), 425, 400, null);
                    if (spriteAtack == 5)
                        g.drawImage(Assets.OnedinAtack[1][4], (int)(x - game.getGameCamera().getxOffset()-48 - 75), (int)(y - game.getGameCamera().getyOffset()- 142+25), 425, 400, null);
                    if (spriteAtack == 6)
                        g.drawImage(Assets.OnedinAtack[1][5], (int)(x - game.getGameCamera().getxOffset()-48 - 88), (int)(y - game.getGameCamera().getyOffset()- 142+25), 425, 400, null);
                    break;
                case 4:
                    if (spriteAtack == 1)
                        g.drawImage(Assets.OnedinAtack[ 3][0], (int)(x - game.getGameCamera().getxOffset() - 51), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    if (spriteAtack == 2)
                        g.drawImage(Assets.OnedinAtack[3][1], (int)(x - game.getGameCamera().getxOffset() - 51 - 25), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    if (spriteAtack == 3)
                        g.drawImage(Assets.OnedinAtack[3][2], (int)(x - game.getGameCamera().getxOffset() - 51 - 29 - 11), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    if (spriteAtack == 4)
                        g.drawImage(Assets.OnedinAtack[3][3], (int)(x - game.getGameCamera().getxOffset() - 51 - 37 - 21), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    if (spriteAtack == 5)
                        g.drawImage(Assets.OnedinAtack[3][4], (int)(x - game.getGameCamera().getxOffset() - 51 - 45 - 34), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    if (spriteAtack == 6)
                        g.drawImage(Assets.OnedinAtack[3][5], (int)(x - game.getGameCamera().getxOffset() - 51 - 46 - 47), (int)(y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                    break;
            }
        }
        //***###

       /* g.setColor(Color.yellow);
        g.fillRect((int) (x + bounds.x - game.getGameCamera().getxOffset()),   (int) (y + bounds.y - game.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

       /* Rectangle cb = getCollisionBounds(0f,0f);
        Rectangle ar = new Rectangle();
        int arSize   = 70;
        ar.width     = 140;
        ar.height    = 140;

        if(game.getKeyManager().up ){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(game.getKeyManager().down ){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(game.getKeyManager().left ){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else if(game.getKeyManager().right ){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else{
            return;
        }
        g.setColor(Color.MAGENTA);
        g.fillRect((int) ( ar.x - game.getGameCamera().getxOffset()),   (int) (ar.y - game.getGameCamera().getyOffset()),
                40, 40);*/


    }
}
