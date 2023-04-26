package PaooGame.Word;

import PaooGame.Entities.Entity;
import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Player;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;
import PaooGame.Game;

import java.awt.*;

public class Word {
    private Game game;
    private int width, heigth;
    private int spawnX, spawnY;
    private int[][]tiles;
    private RefLinks refLinks;




    public Word(RefLinks refLink, Game game,String worldMatrice) {
        this.game = game;
        refLinks = refLink;
        /*entityManager = new EntityManager(refLink, new Player(0, 0,100,100,refLinks, 300,300));*/
        LoadMatrice(worldMatrice);
    }

    public void LoadMatrice(String worldMatrice) {

        String file = Utils.loadFile(worldMatrice);
        String tokens[] = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        heigth = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        tiles = new int[width][heigth];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = Utils.parseInt(tokens[(i + j * width) + 4]);

            }
        }


    }
    public void Update(int flag) {
        if(flag==0)
        {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    tiles[i][j] = 0;

                }
            }
        }
        else if(flag==1)
        {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    tiles[i][j] = 1;
                }
            }
        }
        if(flag==2)
        {
            int [][]tils = {
                    { 5,  4,  4 },
                    { 9, 10, 11 },
                    { 4, 4,  12 }

            };
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    tiles[i][j] = tils[i][j];
                }
            }
        }
        else if(flag==3)
        {
            int [][]tils = {
                    { 6,  4,  4 },
                    { 9, 10, 11 },
                    { 4, 4,  12 }
            };
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    tiles[i][j] = tils[i][j];
                }
            }
        }else if(flag==4)
        {
            int [][]tils = {
                    { 7,  4,  4 },
                    { 9, 10, 11 },
                    { 4, 4,  12 }
            };
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < heigth; j++) {
                    tiles[i][j] = tils[i][j];
                }
            }
        }

    }

    public void Draw(Graphics g) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                    if(tiles[0][0] == 1 || tiles[0][0] == 0)
                        getTile(j, i).Draw(g, i * 380, j * 380, 1);
                    else {
                        /*if(tiles[i][j]==9)*/
                            getTile(j, i).Draw(g, (int) (i * 4096 - game.getGameCamera().getxOffset()), (int) (j * 3472 - game.getGameCamera().getyOffset()), 2);
                       /* else
                            getTile(j, i).Draw(g, (int) (i * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int) (j * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()), 0);*/
                    }
            }
        }

    }



    public Tile getTile(int i, int j) {
        if(i<0 || j < 0 || i >= width || j >= heigth)
        {
            return Tile.OceanTile;
        }

        Tile t = Tile.tiles[tiles[i][j]];
        //if (t == null)
        // return Tile.waterTile;     //n am water.Tile
        return t;
    }

}
