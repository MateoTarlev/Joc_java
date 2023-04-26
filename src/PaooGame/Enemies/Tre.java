package PaooGame.Enemies;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Entities.*;


import java.awt.*;

public class Tre extends EnemCharacter{
    RefLinks refLinks;


    public Tre(int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1, int ceRechin) {
        super(refLink, x1, y1, life, speed, 602, 556);
        this.refLinks = refLink;
        bounds.x = 26;
        bounds.y = 27;
        bounds.height = 437;
        bounds.width = 460;
    }

    @Override
    public void Update(int onedinX, int onedinY) {
    }

    @Override
    public void Draw(Graphics g){
        g.drawImage(Assets.copac2, (int) (x - refLinks.GetGame().getGameCamera().getxOffset()), (int) ( y  - refLinks.GetGame().getGameCamera().getyOffset() ), 602,556,null );
        /*g.setColor(Color.pink);
        g.fillRect((int) (x + bounds.x - refLinks.GetGame().getGameCamera().getxOffset()),   (int) (y + bounds.y - refLinks.GetGame().getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

    }
}
