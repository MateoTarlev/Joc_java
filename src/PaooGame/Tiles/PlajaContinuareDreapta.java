package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlajaContinuareDreapta extends Tile{
    public PlajaContinuareDreapta(int idd) {
        super(Assets.plajaContinueDreapta, idd);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }
}
