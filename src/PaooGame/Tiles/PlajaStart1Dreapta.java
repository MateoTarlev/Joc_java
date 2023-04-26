package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaStart1Dreapta extends Tile{
    public PlajaStart1Dreapta(int idd) {
        super(Assets.plajaStart1Dreapta, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
