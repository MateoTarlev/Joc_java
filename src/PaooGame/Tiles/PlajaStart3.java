package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaStart3 extends Tile {
    public PlajaStart3(int idd) {
        super(Assets.plajaStart3, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
