package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaStart2 extends Tile {
    public PlajaStart2(int idd) {
        super(Assets.plajaStart2, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}