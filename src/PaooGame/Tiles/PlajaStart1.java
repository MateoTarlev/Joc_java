package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaStart1 extends Tile {
    public PlajaStart1(int idd) {
        super(Assets.plajaStart1, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}