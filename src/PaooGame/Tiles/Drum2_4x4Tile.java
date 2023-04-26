package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Drum2_4x4Tile extends Tile{
    public Drum2_4x4Tile(int idd) {
        super(Assets.drumPadure12, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
