package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Drum4_4x4Tile extends Tile{
    public Drum4_4x4Tile(int idd) {
        super(Assets.drumPadure14, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
