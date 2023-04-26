package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class OceanTile2 extends Tile {
    public OceanTile2(int idd) {
        super(Assets.apa2, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}