package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaContinuare extends Tile{
    public PlajaContinuare(int idd) {
        super(Assets.plajaContinue, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
