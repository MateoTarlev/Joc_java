package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Drum1_4x4Tile extends Tile{
    public Drum1_4x4Tile(int idd) {
        super(Assets.drumPadure11, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
