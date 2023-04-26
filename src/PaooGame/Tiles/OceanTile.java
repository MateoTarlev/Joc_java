package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class OceanTile extends Tile {
    public OceanTile(int idd) {
        super(Assets.apa, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
