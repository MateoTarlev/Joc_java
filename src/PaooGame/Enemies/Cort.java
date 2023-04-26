package PaooGame.Enemies;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Entities.*;


import java.awt.*;

public class Cort extends EnemCharacter{
    RefLinks refLinks;


    public Cort( int life, float speed, int widht, int height, RefLinks refLink, float x1, float y1, int ceRechin) {
        super(refLink, x1, y1, life, speed, 473, 542);
        this.refLinks = refLink;
        bounds.x = -96;
        bounds.y = 27;
        bounds.height = 297;
        bounds.width = 510;
    }

    @Override
    public void Update(int onedinX, int onedinY) {
    }

    @Override
    public void Draw(Graphics g){
        g.drawImage(Assets.cort, (int) (x - refLinks.GetGame().getGameCamera().getxOffset()), (int) ( y  - refLinks.GetGame().getGameCamera().getyOffset() ), 446,319,null );
        /*g.setColor(Color.GRAY);
        g.fillRect((int) (x + bounds.x - refLinks.GetGame().getGameCamera().getxOffset()),   (int) (y + bounds.y - refLinks.GetGame().getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

    }
}
