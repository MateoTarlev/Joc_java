package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];
    public static Tile OceanTile        = new OceanTile(0);
    public static Tile OceanTile2       = new OceanTile2(1);
    public static Tile plajaContinue    = new PlajaContinuare(8);
    public static Tile PlajaStart1Dreapta  = new PlajaStart1Dreapta(2);
    public static Tile PlajaContinue1Dreapta   = new PlajaContinuareDreapta(3);
    public static Tile iarba               = new iarbaTile(4);
    public static Tile plajaStart1      = new PlajaStart1(5);
    public static Tile plajaStart2      = new PlajaStart2(6);
    public static Tile plajaStart3      = new PlajaStart3(7);
    public static Tile drumPadure1      = new Drum1_4x4Tile(9);
    public static Tile drumPadure2      = new Drum2_4x4Tile(10);
    public static Tile drumPadure3      = new Drum3_4x4Tile(11);
    public static Tile drumPadure4      = new Drum4_4x4Tile(12);

    public static  int TILE_WIDTH  = 1024;
    public static  int TILE_HEIGHT = 908;

    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;
    }


    public void Update()
    {

    }
    public void Draw(Graphics g, int x, int y, int flag)
    {
        if(flag == 0)
            g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
        else if(flag == 1){
            g.drawImage(img, x, y, 380, 380, null);
        }else if(flag==2){
            g.drawImage(img, x, y, 4096, 3472, null);
        }

    }
    public boolean isSolid()
    {
        return false;
    }
    public int GetId()
    {
        return id;
    }

}
