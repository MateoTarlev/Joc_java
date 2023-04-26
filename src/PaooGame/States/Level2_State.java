package PaooGame.States;

import PaooGame.Entities.Entity;
import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Onedin;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Word.Word;
import PaooGame.Input.KeyManager;
import PaooGame.Enemies.*;

import java.awt.*;

public class Level2_State extends State {
    private Onedin onedin;
    private Word world;
    private Tree copac1[];
    private Tre copac[];
    private Salabtic salbatic[];
    private Cort cort, cort2, cort3, cort4, cort5, cort6;

    /*public EntityManager entityManager ;*/

    public int contor = 0, flag = 2, fg = 0;

    public Level2_State(RefLinks refLink) {
        super(refLink);

        world    = new Word(refLink, refLink.GetGame(),"res/textures/World/world2.txt");
        onedin   = new Onedin(40, 2, 130, 130, refLink, 449,335); //spown ul lui Onedin: x:449,y:335
        refLink.SetOnedin(onedin);

        entityManager = new EntityManager(refLink);
        copac1   = new Tree[20];
        copac    = new Tre[20];
        salbatic = new Salabtic[4];

        salbatic[0] = new Salabtic(40,3, 130, 130, refLink, 720,2290, 1);
        salbatic[1] = new Salabtic(40,3, 130, 130, refLink, 2520,5710, 2);
        entityManager.addEntity(salbatic[0]);
        entityManager.addEntity(salbatic[1]);

        /*Assets.BattleOfGods.play();
        Assets.BattleOfGods.setVolume(0.70);*/
        refLink.GetGame().setCurentWorld(world);
        game.getGameCamera().move(0, 0);
    }

    public void Update()
    {

        if(onedin.getLife()>0) {
            if (onedin.getY() < 900) {
                refLink.GetGame().setLevel(2);
                contor++;
                if (contor < 6) {
                    flag = 2;
                } else if (contor < 22) {
                    flag = 3;
                } else if (contor < 38) {
                    flag = 4;
                }

                if (contor == 38) {
                    contor = 0;
                }
                world.Update(flag);
                onedin.Update();
            } else {
                if (onedin.getX() < 9722 && onedin.getX() > 449) {
                    world.Update(flag);
                    onedin.Update();
                } else {
                    if (onedin.getX() <= 449)
                        onedin.growX();
                    else if (onedin.getX() >= 9722)
                        onedin.scadeX();


                }
            }
            if (fg == 0) {
                fg = 1;
                cort = new Cort(0, 0, 236, 167, refLink, 4978, 5047, 1);
                entityManager.addEntity(cort);
                cort2 = new Cort(0, 0, 236, 167, refLink, 6295, 5407, 1);
                entityManager.addEntity(cort2);
                cort3 = new Cort(0, 0, 236, 167, refLink, 5071, 6221, 1);
                entityManager.addEntity(cort3);
                cort4 = new Cort(0, 0, 236, 167, refLink, 7750, 5279, 1);
                entityManager.addEntity(cort4);
                cort5 = new Cort(0, 0, 236, 167, refLink, 7940, 4112, 1);
                entityManager.addEntity(cort5);
                cort6 = new Cort(0, 0, 236, 167, refLink, 6272, 4458, 1);
                entityManager.addEntity(cort6);


                copac1[0] = new Tree(0, 0, 373, 342, refLink, 985, 1893, 1);
                copac1[1] = new Tree(0, 0, 373, 342, refLink, 1135, 2300, 1);
                copac1[2] = new Tree(0, 0, 373, 342, refLink, 1490, 2460, 1);
                copac1[3] = new Tree(0, 0, 373, 342, refLink, 1916, 2890, 1);
                copac1[3] = new Tree(0, 0, 373, 342, refLink, 1916, 2890, 1);
                copac1[4] = new Tree(0, 0, 373, 342, refLink, 1970, 3320, 1);
                copac1[5] = new Tree(0, 0, 373, 342, refLink, 2049, 3737, 1);
                copac1[6] = new Tree(0, 0, 373, 342, refLink, 2408, 4970, 1);
                copac1[7] = new Tree(0, 0, 373, 342, refLink, 3070, 4970, 1);
                copac1[8] = new Tree(0, 0, 373, 342, refLink, 4210, 4901, 1);
                copac1[9] = new Tree(0, 0, 373, 342, refLink, 5254, 4626, 1);
                copac1[10] = new Tree(0, 0, 373, 342, refLink, 6945, 3961, 1);
                copac1[11] = new Tree(0, 0, 373, 342, refLink, 9473, 3942, 1);
                for (int i = 0; i <= 11; i++)
                    entityManager.addEntity(copac1[i]);

                copac[0] = new Tre(0, 0, 373, 342, refLink, 1680, 4170, 1);
                copac[1] = new Tre(0, 0, 373, 342, refLink, 1990, 4600, 1);
                copac[2] = new Tre(0, 0, 373, 342, refLink, 2720, 4900, 1);
                copac[3] = new Tre(0, 0, 373, 342, refLink, 3320, 4910, 1);
                copac[4] = new Tre(0, 0, 373, 342, refLink, 3770, 4970, 1);
                copac[5] = new Tre(0, 0, 373, 342, refLink, 4570, 4720, 1);
                copac[6] = new Tre(0, 0, 373, 342, refLink, 5691, 4436, 1);
                copac[7] = new Tre(0, 0, 373, 342, refLink, 6565, 4112, 1);
                copac[8] = new Tre(0, 0, 373, 342, refLink, 7360, 3866, 1);
                copac[9] = new Tre(0, 0, 373, 342, refLink, 8200, 3677, 1);
                copac[10] = new Tre(0, 0, 373, 342, refLink, 8655, 3904, 1);
                copac[11] = new Tre(0, 0, 373, 342, refLink, 9111, 4114, 1);
                copac[12] = new Tre(0, 0, 373, 342, refLink, 1061, 1646, 1);
                for (int i = 0; i <= 12; i++)
                    entityManager.addEntity(copac[i]);

                //salbatic[0] = new Salabtic(40,3, 130, 130, refLink, 449,500, 1);

            }

            refLink.setX((int) (onedin.getX()));
            refLink.setY((int) (onedin.getY()));
            if (salbatic[0].getLife() > 0)
                salbatic[0].Update((int) (onedin.getX()), (int) (onedin.getY()));
            else
                entityManager.removeEntity(salbatic[0]);

            if (salbatic[1].getLife() > 0)
                salbatic[1].Update((int) (onedin.getX()), (int) (onedin.getY()));
            else
                entityManager.removeEntity(salbatic[1]);

        }else{
            Assets.BattleOfGods.stop();
            State.setCurrentState( game.returnNewYouLoseState(refLink) );
        }
    }

    public void Draw(Graphics g)
    {
        System.out.println("Xmouse = " + game.GetMouseManager().getMouseX() + "  ;Ymoouse =  " + game.GetMouseManager().getMouseY() );
        System.out.println("X = " +  onedin.getX() + "  ;Y = " + onedin.getY() );
        /*g.fillRect(5120,8680,1024,868);*/

        world.Draw(g);
        copac[12].Draw(g);
        copac1[0].Draw(g);
        copac1[1].Draw(g);
        copac1[2].Draw(g);
        copac1[3].Draw(g);
        copac1[4].Draw(g);
        copac1[5].Draw(g);

        copac[0].Draw(g);
        copac[1].Draw(g);


        copac[2].Draw(g);
        copac1[6].Draw(g);
        copac[3].Draw(g);
        copac1[7].Draw(g);
        copac[5].Draw(g);
        copac1[8].Draw(g);
        copac[4].Draw(g);
        copac[6].Draw(g);
        copac1[9].Draw(g);
        copac[8].Draw(g);
        copac1[10].Draw(g);
        copac[7].Draw(g);
        copac[9].Draw(g);
        copac[10].Draw(g);
        copac1[11].Draw(g);
        copac[11].Draw(g);

        cort.Draw(g);
        cort2.Draw(g);
        cort3.Draw(g);
        cort4.Draw(g);
        cort5.Draw(g);
        cort6.Draw(g);


        if(salbatic[0].getLife() >0) {
            if (salbatic[0].getY() < onedin.getY()) {
                if (salbatic[0].getLife() > 0)
                    salbatic[0].Draw(g);

                onedin.Draw(g);
            } else {
                onedin.Draw(g);
                salbatic[0].Draw(g);
            }
        }
        if(salbatic[0].getLife() <= 0 && salbatic[1].getLife() > 0){
            salbatic[0].Draw(g);
        /*    onedin.Draw(g);*/

            if (salbatic[1].getY() < onedin.getY()) {
                if (salbatic[1].getLife() > 0)
                    salbatic[1].Draw(g);

                onedin.Draw(g);
            } else {
                onedin.Draw(g);
                salbatic[1].Draw(g);
            }
        } else if (salbatic[0].getLife() <= 0 && salbatic[1].getLife() <= 0){

            salbatic[1].Draw(g);
            onedin.Draw(g);
        }

    }

    public void dmg(int hp){
        onedin.damage(hp);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
