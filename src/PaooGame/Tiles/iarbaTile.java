package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class iarbaTile extends Tile{
    public iarbaTile(int idd) {
        super(Assets.iarba, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
