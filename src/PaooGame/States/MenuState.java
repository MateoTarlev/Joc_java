package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import java.awt.*;

import PaooGame.Entities.Player;
import PaooGame.RefLinks;

public class MenuState extends State {
   // private State level1State;
   //aa private Game game;
    public boolean flagOptions = false;

    public MenuState(RefLinks refLink) {
        super(refLink);
        Assets.MenuMusic.setVolume(0.37);
        Assets.MenuMusic.play();
    }

    @Override
    public void Update() {
        if(flagLevel1==true)
        {
            //System.out.println("asd");
            try {
                Thread.sleep(1200);
                Assets.MenuMusic.stop();
                State.setCurrentState(refLink.GetGame().getLevel1State());
                //Game.returnNewLevel1State(refLink);
                Assets.Level1StateMusic.play();
                Assets.Level1StateMusic.setVolume(0.45);
                Assets.ahBer.play();
                Assets.ahBer.setVolume(0.40);
                //Assets.LoseMusic.play();
                //Assets.Level1StateMusic.setVolume(0.15);
            }
            catch (InterruptedException e)
            {
                System.err.println("Error: MenuState: Thread Sleep");
            }
        }

    }

    @Override
    public void Draw(Graphics g){
        //System.out.println("Ssdfs");

        if(flagPoveste==false && !flagLevel1 && flagOptions==false) {
            g.drawImage(Assets.menu[0], 0, 0, 1024, 868, null);
            if (game.GetMouseManager().getMouseX() >= 89 && game.GetMouseManager().getMouseX() <= 353)
            {
                if (game.GetMouseManager().getMouseY() >= 140 && game.GetMouseManager().getMouseY() <= 195)
                {
                    g.drawImage(Assets.menu[1], 0, 0, 1024, 868, null);
                    if(game.GetMouseManager().leftClickPressed())
                    {
                        flagPoveste = true;
                    }
                }
            }
            if (game.GetMouseManager().getMouseX() >= 89 && game.GetMouseManager().getMouseX() <= 353) {
                if (game.GetMouseManager().getMouseY() >= 250 && game.GetMouseManager().getMouseY() <= 308) {
                    g.drawImage(Assets.menu[2], 0, 0, 1024, 868, null);
                    if(game.GetMouseManager().leftClickPressed())
                    {
                        flagOptions = true;
                        /*g.drawImage(Assets.Options,0,0,1024,868,null);*/

                    }
                }
            }
            if (game.GetMouseManager().getMouseX() >= 89 && game.GetMouseManager().getMouseX() <= 353) {
                if (game.GetMouseManager().getMouseY() >= 340 && game.GetMouseManager().getMouseY() <= 396) {
                    g.drawImage(Assets.menu[3], 0, 0, 1024, 868, null);
                    if (game.GetMouseManager().leftClickPressed())
                        System.exit(0);
                }
            }
        }
        else if(flagOptions){
            g.drawImage(Assets.Options,0,0,1024,868,null);
            if(game.GetMouseManager().getMouseX()>=498 && game.GetMouseManager().getMouseX()<=886)
            {
                if(game.GetMouseManager().getMouseY()>=756 && game.GetMouseManager().getMouseY()<=809)
                {
                    g.drawImage(Assets.Options_pressed,0,0,1024,868,null);
                    if(game.GetMouseManager().leftClickPressed())
                    {
                        flagOptions = false;
                    }
                }
            }
        }
        else
        {
            if(flagPoveste2==false)
            {
                g.drawImage(Assets.menu[4], 0, 0, 1024, 868, null);
                if (game.GetMouseManager().getMouseX() >= 770 && game.GetMouseManager().getMouseX() <= 917) {
                    if (game.GetMouseManager().getMouseY() >= 84 && game.GetMouseManager().getMouseY() <= 139) {
                        g.drawImage(Assets.menu[5], 0, 0, 1024, 868, null);
                        if (game.GetMouseManager().leftClickPressed())
                            flagPoveste2 = true;
                    }
                }
            }
            else
            {
                g.drawImage(Assets.menu[6], 0, 0, 1024, 868, null);
                if (game.GetMouseManager().getMouseX() >= 165 && game.GetMouseManager().getMouseX() <= 326) {
                    if (game.GetMouseManager().getMouseY() >= 670 && game.GetMouseManager().getMouseY() <= 719) {
                        g.drawImage(Assets.menu[7], 0, 0, 1024, 868, null);
                        if (game.GetMouseManager().leftClickPressed())
                            flagLevel1 = true;
                    }
                }
            }
        }




       System.out.println("X = " + game.GetMouseManager().getMouseX() + "  ;Y =  " + game.GetMouseManager().getMouseY() );

       /* if(game.GetMouseManager().leftClickPressed())
        {
            System.out.println("S a apasat mouse ul");
        }*/

    }

}
