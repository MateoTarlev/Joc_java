package PaooGame.Enemies;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;


import java.awt.*;
import java.util.Random;

public class Salabtic  extends EnemCharacter{
    private Game game;
    private int direction = 0;
    private float x1, y1;
    private int ceSalbatic, atackCounter = 0, spriteAtack = 1;
    private boolean atack = false;
    private RefLinks refLinks;

    public Salabtic(int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1, int ceSalbatic) {
        super(refLink, x1, y1, life, speed, widht, height);
        this.game = refLink.GetGame();
        this.x1 = x1;
        this.y1 = y1;
        this.ceSalbatic = ceSalbatic;
        this.refLinks = refLink;

        bounds.x = 40;
        bounds.y = 57;
        bounds.width = 55;
        bounds.height = 62;
    }

    @Override
    public void Update(int onedinX, int onedinY) {
        getInput();
        Move(2);

        int deltaX = onedinX - (int)(x);
        int deltaY = onedinY - (int)(y);
        if(deltaX*deltaX + deltaY*deltaY < 480*480) {
            if(Math.abs(deltaY) <= Math.abs(deltaX))
            {
                if(deltaX >= 0)
                    direction = 4; // right
                else
                    direction = 3; // left
            }
            else
            {
                if(deltaY >= 0)
                    direction = 2; // down
                else
                    direction = 1; // up
            }

            if(deltaX*deltaX + deltaY*deltaY < 90*90) {
                atack = true;
                atackCounter++;
                if (atackCounter > 1) {
                    if (spriteAtack == 1) {
                        spriteAtack = 2;
                    } else if (spriteAtack == 2) {
                        spriteAtack = 3;

                    } else if (spriteAtack == 3) {
                        spriteAtack = 4;

                        //checkAttacks();

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
            }else{
                atack = false;
            }
        }
        else {
            /*contor++;
            if(contor == 60) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;
                {
                    if (i < 25) {
                        direction = 1;
                    }
                    if (i >= 25 && i < 50) {
                        direction = 4;
                    }
                    if (i >= 50 && i < 75) {
                        direction = 2;
                    }
                    if (i >= 75) {
                        direction = 3;
                    }
                }
                contor = 0;
            }*/
            direction = 0;

        }
    }


    private void checkAttacks(){
        Rectangle cb = getCollisionBounds(0f,0f);
        Rectangle ar = new Rectangle();
        int arSize   = 50;
        ar.width     = 50;
        ar.height    = 50;

        if(direction == 1 ){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(direction == 2){
            ar.x = cb.x + cb.width/2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(direction == 3 ){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else if(direction == 4 ){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize / 2;
        }else{
            return;
        }

        for (EnemEntity e : game.getLevel2State().getEntityManager().getEntities()) {
            if (getCollisionBoundsOnedin(0f, 0f).intersects(ar)) {
                refLinks.returnOnedin().damage(1);
                return;
            }
        }

    }

    protected void drawLife(Graphics g){
        Font fnt1 = new Font("TimesRoman", Font.BOLD, 19);
        String text = Integer.toString(getLife());
        String txt  = "%";
        String concat = text.concat(txt);
        int text_width = g.getFontMetrics().stringWidth(text);
        //g.setColor(Color.getHSBColor(0.92f,10,0.6f));
        g.setColor(Color.getHSBColor(0.99f,1,0.64f));   // un rosu la fel potrivit apei
       // g.setColor(Color.magenta);
        g.setFont(fnt1);
        g.drawString(concat, (int) (x - 11 - refLinks.GetGame().getGameCamera().getxOffset() + bounds.x + bounds.width/2 - text_width/2), (int) (y + 3 - refLinks.GetGame().getGameCamera().getyOffset()));
    }

    private void getInput() {
        xMove=0;
        yMove=0;

        switch(direction)
        {
            case 1:
                yMove += -10;
                break;
            case 2:
                yMove += 10;
                break;
            case 3:
                xMove += -10;
                break;
            case 4:
                xMove += 10;
                break;
        }
       // yMove=speed;
       // direction = 2;
        spriteCount2++;

        if (spriteCount2 > 1)
        {
            if (spriteNr2 == 1)
            {
                /*System.out.println("Eee");*/
                spriteNr2 = 2;
            }
            else if (spriteNr2 == 2)
            {
                spriteNr2 = 3;
            }
            else if (spriteNr2 == 3)
            {
                spriteNr2 = 4;
            }else if (spriteNr2 == 4)
            {
                spriteNr2 = 5;
            }
            else if (spriteNr2 == 5)
            {
                spriteNr2 = 6;
            }else if (spriteNr2 == 6)
            {
                spriteNr2 = 7;
            }else if (spriteNr2 == 7)
            {
                spriteNr2 = 8;
            }else if (spriteNr2 == 8)
            {
                spriteNr2 = 9;
            }
            else if (spriteNr2 == 9)
            {
                spriteNr2 = 1;
            }

            spriteCount2 = 0;
        }




    }

    @Override
    public void Draw(Graphics g)
    {

        drawLife(g);
        //g.drawImage(Assets.copac,(int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
       // System.out.println("xxxxx = " + x + "yyyyyy = " + y);
        if(ceSalbatic == 1) {
            if (getLife() > 0) {
                if (atack == false) {
                    switch (direction) {
                        case 0:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            break;
                        case 1:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.SalbaticWalk[0][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.SalbaticWalk[0][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.SalbaticWalk[0][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.SalbaticWalk[0][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.SalbaticWalk[0][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.SalbaticWalk[0][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.SalbaticWalk[0][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.SalbaticWalk[0][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.SalbaticWalk[0][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 2:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.SalbaticWalk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.SalbaticWalk[2][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.SalbaticWalk[2][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.SalbaticWalk[2][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.SalbaticWalk[2][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.SalbaticWalk[2][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.SalbaticWalk[2][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.SalbaticWalk[2][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.SalbaticWalk[2][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 3:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.SalbaticWalk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.SalbaticWalk[1][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.SalbaticWalk[1][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.SalbaticWalk[1][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.SalbaticWalk[1][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.SalbaticWalk[1][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.SalbaticWalk[1][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.SalbaticWalk[1][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.SalbaticWalk[1][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 4:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.SalbaticWalk[3][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.SalbaticWalk[3][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.SalbaticWalk[3][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.SalbaticWalk[3][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.SalbaticWalk[3][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.SalbaticWalk[3][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.SalbaticWalk[3][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.SalbaticWalk[3][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.SalbaticWalk[3][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;

                    }
                } else {

                    switch (direction) {
                        case 0:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.SalbaticAtack[2][0], (int) (x - game.getGameCamera().getxOffset() - 46), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.SalbaticAtack[2][1], (int) (x - game.getGameCamera().getxOffset() - 46 - 23), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.SalbaticAtack[2][2], (int) (x - game.getGameCamera().getxOffset() - 46 - 41), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.SalbaticAtack[2][3], (int) (x - game.getGameCamera().getxOffset() - 94 - 53), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.SalbaticAtack[2][4], (int) (x - game.getGameCamera().getxOffset() - 46 - 67), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.SalbaticAtack[2][5], (int) (x - game.getGameCamera().getxOffset() - 46 - 82), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            break;
                        case 1:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.SalbaticAtack[0][0], (int) (x - game.getGameCamera().getxOffset() - 41), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.SalbaticAtack[0][1], (int) (x - game.getGameCamera().getxOffset() - 41 - 18), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.SalbaticAtack[0][2], (int) (x - game.getGameCamera().getxOffset() - 41 - 40), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.SalbaticAtack[0][3], (int) (x - game.getGameCamera().getxOffset() - 41 - 61), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.SalbaticAtack[0][4], (int) (x - game.getGameCamera().getxOffset() - 41 - 81), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.SalbaticAtack[0][5], (int) (x - game.getGameCamera().getxOffset() - 41 - 105), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            break;
                        case 2:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.SalbaticAtack[2][0], (int) (x - game.getGameCamera().getxOffset() - 46), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.SalbaticAtack[2][1], (int) (x - game.getGameCamera().getxOffset() - 46 - 23), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.SalbaticAtack[2][2], (int) (x - game.getGameCamera().getxOffset() - 46 - 41), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.SalbaticAtack[2][3], (int) (x - game.getGameCamera().getxOffset() - 94 - 53), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.SalbaticAtack[2][4], (int) (x - game.getGameCamera().getxOffset() - 46 - 67), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.SalbaticAtack[2][5], (int) (x - game.getGameCamera().getxOffset() - 46 - 82), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            break;
                        case 3:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.SalbaticAtack[1][0], (int) (x - game.getGameCamera().getxOffset() - 48), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.SalbaticAtack[1][1], (int) (x - game.getGameCamera().getxOffset() - 48 - 12), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.SalbaticAtack[1][2], (int) (x - game.getGameCamera().getxOffset() - 48 - 36), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.SalbaticAtack[1][3], (int) (x - game.getGameCamera().getxOffset() - 48 - 56), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.SalbaticAtack[1][4], (int) (x - game.getGameCamera().getxOffset() - 48 - 75), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.SalbaticAtack[1][5], (int) (x - game.getGameCamera().getxOffset() - 48 - 88), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            break;
                        case 4:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.SalbaticAtack[3][0], (int) (x - game.getGameCamera().getxOffset() - 51), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.SalbaticAtack[3][1], (int) (x - game.getGameCamera().getxOffset() - 51 - 25), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.SalbaticAtack[3][2], (int) (x - game.getGameCamera().getxOffset() - 51 - 29 - 11), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.SalbaticAtack[3][3], (int) (x - game.getGameCamera().getxOffset() - 51 - 37 - 21), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.SalbaticAtack[3][4], (int) (x - game.getGameCamera().getxOffset() - 51 - 45 - 34), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.SalbaticAtack[3][5], (int) (x - game.getGameCamera().getxOffset() - 51 - 46 - 47), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            break;
                    }
                }


            } else {

                g.drawImage(Assets.mort1, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
            }
        }else if(ceSalbatic == 2){
            if (getLife() > 0) {
                if (atack == false) {
                    switch (direction) {
                        case 0:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            break;
                        case 1:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.Salbatic2Walk[0][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.Salbatic2Walk[0][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.Salbatic2Walk[0][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.Salbatic2Walk[0][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.Salbatic2Walk[0][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.Salbatic2Walk[0][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.Salbatic2Walk[0][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.Salbatic2Walk[0][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.Salbatic2Walk[0][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 2:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.Salbatic2Walk[2][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.Salbatic2Walk[2][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.Salbatic2Walk[2][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.Salbatic2Walk[2][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.Salbatic2Walk[2][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.Salbatic2Walk[2][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.Salbatic2Walk[2][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.Salbatic2Walk[2][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.Salbatic2Walk[2][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 3:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.Salbatic2Walk[1][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.Salbatic2Walk[1][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.Salbatic2Walk[1][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.Salbatic2Walk[1][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.Salbatic2Walk[1][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.Salbatic2Walk[1][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.Salbatic2Walk[1][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.Salbatic2Walk[1][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.Salbatic2Walk[1][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;
                        case 4:
                            if (spriteNr2 == 1)
                                g.drawImage(Assets.Salbatic2Walk[3][0], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 2)
                                g.drawImage(Assets.Salbatic2Walk[3][1], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 3)
                                g.drawImage(Assets.Salbatic2Walk[3][2], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 4)
                                g.drawImage(Assets.Salbatic2Walk[3][3], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 5)
                                g.drawImage(Assets.Salbatic2Walk[3][4], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 6)
                                g.drawImage(Assets.Salbatic2Walk[3][5], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 7)
                                g.drawImage(Assets.Salbatic2Walk[3][6], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 8)
                                g.drawImage(Assets.Salbatic2Walk[3][7], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
                            if (spriteNr2 == 9)
                                g.drawImage(Assets.Salbatic2Walk[3][8], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);

                            break;

                    }
                } else {

                    switch (direction) {
                        case 0:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.Salbatic2Atack[2][0], (int) (x - game.getGameCamera().getxOffset() - 46), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.Salbatic2Atack[2][1], (int) (x - game.getGameCamera().getxOffset() - 46 - 23), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.Salbatic2Atack[2][2], (int) (x - game.getGameCamera().getxOffset() - 46 - 41), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.Salbatic2Atack[2][3], (int) (x - game.getGameCamera().getxOffset() - 94 - 53), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.Salbatic2Atack[2][4], (int) (x - game.getGameCamera().getxOffset() - 46 - 67), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.Salbatic2Atack[2][5], (int) (x - game.getGameCamera().getxOffset() - 46 - 82), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            break;
                        case 1:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.Salbatic2Atack[0][0], (int) (x - game.getGameCamera().getxOffset() - 41), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.Salbatic2Atack[0][1], (int) (x - game.getGameCamera().getxOffset() - 41 - 18), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.Salbatic2Atack[0][2], (int) (x - game.getGameCamera().getxOffset() - 41 - 40), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.Salbatic2Atack[0][3], (int) (x - game.getGameCamera().getxOffset() - 41 - 61), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.Salbatic2Atack[0][4], (int) (x - game.getGameCamera().getxOffset() - 41 - 81), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.Salbatic2Atack[0][5], (int) (x - game.getGameCamera().getxOffset() - 41 - 105), (int) (y - game.getGameCamera().getyOffset() + 25 - 96 - 9), 425, 400, null);
                            break;
                        case 2:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.Salbatic2Atack[2][0], (int) (x - game.getGameCamera().getxOffset() - 46), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.Salbatic2Atack[2][1], (int) (x - game.getGameCamera().getxOffset() - 46 - 23), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.Salbatic2Atack[2][2], (int) (x - game.getGameCamera().getxOffset() - 46 - 41), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.Salbatic2Atack[2][3], (int) (x - game.getGameCamera().getxOffset() - 94 - 53), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.Salbatic2Atack[2][4], (int) (x - game.getGameCamera().getxOffset() - 46 - 67), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.Salbatic2Atack[2][5], (int) (x - game.getGameCamera().getxOffset() - 46 - 82), (int) (y - game.getGameCamera().getyOffset() - 194 + 25), 425, 400, null);
                            break;
                        case 3:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.Salbatic2Atack[1][0], (int) (x - game.getGameCamera().getxOffset() - 48), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.Salbatic2Atack[1][1], (int) (x - game.getGameCamera().getxOffset() - 48 - 12), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.Salbatic2Atack[1][2], (int) (x - game.getGameCamera().getxOffset() - 48 - 36), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.Salbatic2Atack[1][3], (int) (x - game.getGameCamera().getxOffset() - 48 - 56), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.Salbatic2Atack[1][4], (int) (x - game.getGameCamera().getxOffset() - 48 - 75), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.Salbatic2Atack[1][5], (int) (x - game.getGameCamera().getxOffset() - 48 - 88), (int) (y - game.getGameCamera().getyOffset() - 142 + 25), 425, 400, null);
                            break;
                        case 4:
                            if (spriteAtack == 1)
                                g.drawImage(Assets.Salbatic2Atack[3][0], (int) (x - game.getGameCamera().getxOffset() - 51), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 2)
                                g.drawImage(Assets.Salbatic2Atack[3][1], (int) (x - game.getGameCamera().getxOffset() - 51 - 25), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 3)
                                g.drawImage(Assets.Salbatic2Atack[3][2], (int) (x - game.getGameCamera().getxOffset() - 51 - 29 - 11), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 4)
                                g.drawImage(Assets.Salbatic2Atack[3][3], (int) (x - game.getGameCamera().getxOffset() - 51 - 37 - 21), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 5)
                                g.drawImage(Assets.Salbatic2Atack[3][4], (int) (x - game.getGameCamera().getxOffset() - 51 - 45 - 34), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            if (spriteAtack == 6)
                                g.drawImage(Assets.Salbatic2Atack[3][5], (int) (x - game.getGameCamera().getxOffset() - 51 - 46 - 47), (int) (y - game.getGameCamera().getyOffset() - 244 + 25), 425, 400, null);
                            break;
                    }
                }


            } else {

                g.drawImage(Assets.mort2, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), 145, 145, null);
            }
        }

       /* g.setColor(Color.red);
        g.fillRect((int) (x *//*-5*//* + bounds.x - game.getGameCamera().getxOffset()),   (int) (y + bounds.y - game.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }
}
