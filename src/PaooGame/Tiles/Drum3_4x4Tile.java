package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Drum3_4x4Tile extends Tile{
    public Drum3_4x4Tile(int idd) {
        super(Assets.drumPadure13, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
