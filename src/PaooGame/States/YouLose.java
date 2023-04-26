package PaooGame.States;

import PaooGame.Enemies.EnemEntity;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class YouLose extends State{
    private int ceLevel;

    public YouLose(RefLinks refLink, int ceLevel) {
        super(refLink);
        Assets.LoseMusic.play();
        Assets.LoseMusic.setVolume(0.7);
        this.ceLevel = ceLevel;
        //music
    }

    @Override
    public void Update(){

    }

    @Override
    public void Draw(Graphics g){
        System.out.println("LEVELUL = " + ceLevel);
        if(ceLevel == 1) {
            g.drawImage(Assets.YL, 0, 0, 1024, 868, null);
            System.out.println("x = " + game.GetMouseManager().getMouseX() + "   y = " + game.GetMouseManager().getMouseY());
            if (game.GetMouseManager().getMouseX() >= 423 && game.GetMouseManager().getMouseX() <= 580) {
                if (game.GetMouseManager().getMouseY() >= 375 && game.GetMouseManager().getMouseY() <= 424) {
                    g.drawImage(Assets.YL_Re, 0, 0, 1024, 868, null);
                    if (game.GetMouseManager().leftClickPressed()) {
                   /*     Assets.Level1StateMusic.stop();
                        Assets.ahBer.stop();
*/
                        Assets.LoseMusic.stop();
                        Assets.Level1StateMusic.play();
                        Assets.Level1StateMusic.setVolume(0.45);
                        Assets.ahBer.play();
                        Assets.ahBer.setVolume(0.49);
                        State.setCurrentState(refLink.GetGame().returnNewLevel1State(refLink));
                    }
                }
                if (game.GetMouseManager().getMouseX() >= 442 && game.GetMouseManager().getMouseX() <= 553) {
                    if (game.GetMouseManager().getMouseY() >= 466 && game.GetMouseManager().getMouseY() <= 516) {
                        g.drawImage(Assets.YL_Ex, 0, 0, 1024, 868, null);
                        if (game.GetMouseManager().leftClickPressed())
                            System.exit(0);

                    }
                }
            }
        }else if(ceLevel == 2){
            g.drawImage(Assets.YL, 0, 0, 1024, 868, null);
            System.out.println("x = " + game.GetMouseManager().getMouseX() + "   y = " + game.GetMouseManager().getMouseY());
            if (game.GetMouseManager().getMouseX() >= 423 && game.GetMouseManager().getMouseX() <= 580) {
                if (game.GetMouseManager().getMouseY() >= 375 && game.GetMouseManager().getMouseY() <= 424) {
                    g.drawImage(Assets.YL_Re, 0, 0, 1024, 868, null);
                    if (game.GetMouseManager().leftClickPressed()) {
                   /*     Assets.Level1StateMusic.stop();
                        Assets.ahBer.stop();
*/
                        //refLink.GetGame().getLevel2State().getEntityManager().getEntities().removeAll(refLink.GetGame().getLevel2State().getEntityManager().getEntities());
                        Assets.LoseMusic.stop();
                        /*Assets.LevelStateMusic.play();
                        Assets.Level2StateMusic.setVolume(0.45);*/
                        /*Assets.ahBer.play();
                        Assets.ahBer.setVolume(0.49);*/
                        Assets.BattleOfGods.play();
                        Assets.BattleOfGods.setVolume(0.50);
                        State.setCurrentState(refLink.GetGame().returnNewLevel2State(refLink));
                    }
                }
                if (game.GetMouseManager().getMouseX() >= 442 && game.GetMouseManager().getMouseX() <= 553) {
                    if (game.GetMouseManager().getMouseY() >= 466 && game.GetMouseManager().getMouseY() <= 516) {
                        g.drawImage(Assets.YL_Ex, 0, 0, 1024, 868, null);
                        if (game.GetMouseManager().leftClickPressed())
                            System.exit(0);

                    }
                }
            }

        }
        /*if()*/
    }
}
