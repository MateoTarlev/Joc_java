package PaooGame.Graphics;

import PaooGame.Entities.Onedin;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{

    public static BufferedImage apa, apa2, cort, YL, YL_Re, YL_Ex, Options, Options_pressed, mort1, mort2;
    public static BufferedImage plajaStart1, plajaStart1Dreapta, plajaStart2, plajaStart3, plajaContinue, plajaContinueDreapta, iarba, copac, copac2;
    public static BufferedImage drumPadure11, drumPadure12, drumPadure13, drumPadure14;
    public static BufferedImage []menu;
    public static BufferedImage []conexLv12;
    public static BufferedImage []rechin;
    public static BufferedImage []rechinSur;
    public static BufferedImage []rechinNemo;
    public static BufferedImage []rechinVerde;
    public static BufferedImage[] OnedinBarca;
    public static BufferedImage[][] OnedinWalk;
    public static BufferedImage[][] SalbaticWalk;
    public static BufferedImage[][] SalbaticAtack;
    public static BufferedImage[][] Salbatic2Walk;
    public static BufferedImage[][] Salbatic2Atack;
    public static BufferedImage[][] OnedinAtack;
    public static Sound Level1StateMusic, ahBer, MenuMusic, LoseMusic, BattleOfGods;
        /// Referinte catre elementele grafice (dale) utilizate in joc.


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        //*************************************__MENU__***************************************************
        MenuMusic = new Sound("res/textures/MusicLev/pirate-theme_5min.wav");
        LoseMusic = new Sound("res/textures/MusicLev/YouLoseMusic.wav");
        ahBer     = new Sound("res/textures/MusicLev/ahBerAtas.wav");
        BattleOfGods = new Sound("res/textures/MusicLev/Hunt.wav");

        menu = new BufferedImage[8];
        menu[0] = ImageLoader.LoadImage("/textures/Menu/menu_curat.jpg");
        menu[1] = ImageLoader.LoadImage("/textures/Menu/Menu_Play_Game.jpg");
        menu[2] = ImageLoader.LoadImage("/textures/Menu/menu_Options(1).jpg");
        menu[3] = ImageLoader.LoadImage("/textures/Menu/menu_Exit(1).jpg");
        menu[4] = ImageLoader.LoadImage("/textures/Menu/menu_start_skip.jpg");
        menu[5] = ImageLoader.LoadImage("/textures/Menu/menu_start_SKIP_press.jpg");
        menu[6] = ImageLoader.LoadImage("/textures/Menu/menu_start2_Skip2.jpg");
        menu[7] = ImageLoader.LoadImage("/textures/Menu/menu_start2_SKIP2_press.jpg");

        Options = ImageLoader.LoadImage("/textures/Menu/Options.jpg");
        Options_pressed = ImageLoader.LoadImage("/textures/Menu/Options_pressed.jpg");
        //************************************************************************************************
        //**************************************LEVEL_1***************************************************
        OnedinBarca = new BufferedImage[11];
        OnedinBarca[0] = ImageLoader.LoadImage("/textures/OnedinBarca/one1.png");
        OnedinBarca[2] = ImageLoader.LoadImage("/textures/OnedinBarca/one11.png");
        OnedinBarca[3] = ImageLoader.LoadImage("/textures/OnedinBarca/one111.png");
        OnedinBarca[4] = ImageLoader.LoadImage("/textures/OnedinBarca/one1111.png");

        OnedinBarca[1] = ImageLoader.LoadImage("/textures/OnedinBarca/one11(dreapta).png");
        OnedinBarca[5] = ImageLoader.LoadImage("/textures/OnedinBarca/one1(dreapta).png");
        OnedinBarca[6] = ImageLoader.LoadImage("/textures/OnedinBarca/one1(dreapta)(1).png");
        OnedinBarca[7] = ImageLoader.LoadImage("/textures/OnedinBarca/one111(dreapta).png");

        OnedinBarca[8] = ImageLoader.LoadImage("/textures/OnedinBarca/one1(stanga).png");
        OnedinBarca[9] = ImageLoader.LoadImage("/textures/OnedinBarca/one11(stanga).png");
        OnedinBarca[10] = ImageLoader.LoadImage("/textures/OnedinBarca/one111(stanga).png");

        YL             = ImageLoader.LoadImage("/textures/Menu/YouLose_clasic.png");
        YL_Ex          = ImageLoader.LoadImage("/textures/Menu/YouLose_Exit.png");
        YL_Re          = ImageLoader.LoadImage("/textures/Menu/YouLose_Retry.png");

        rechin = new BufferedImage[3];
        rechin[0] = ImageLoader.LoadImage("/textures/rechin/rechin_albb.png");
        rechin[1] = ImageLoader.LoadImage("/textures/rechin/rechin_albb2.png");
        rechin[2] = ImageLoader.LoadImage("/textures/rechin/rechin_albb3.png");

        rechinSur = new BufferedImage[3];
        rechinSur[0] = ImageLoader.LoadImage("/textures/rechin/rechin_sur1.png");
        rechinSur[1] = ImageLoader.LoadImage("/textures/rechin/rechin_sur2.png");
        rechinSur[2] = ImageLoader.LoadImage("/textures/rechin/rechin_sur3.png");

        rechinNemo = new BufferedImage[3];
        rechinNemo[0] = ImageLoader.LoadImage("/textures/rechin/rechin_nemo1.png");
        rechinNemo[1] = ImageLoader.LoadImage("/textures/rechin/rechin_nemo2.png");
        rechinNemo[2] = ImageLoader.LoadImage("/textures/rechin/rechin_nemo3.png");

        rechinVerde = new BufferedImage[3];
        rechinVerde[0] = ImageLoader.LoadImage("/textures/rechin/rechin_verde1.png");
        rechinVerde[1] = ImageLoader.LoadImage("/textures/rechin/rechin_verde2.png");
        rechinVerde[2] = ImageLoader.LoadImage("/textures/rechin/rechin_verde3.png");

        apa = ImageLoader.LoadImage("/textures/Ocean/bk_water2.jpg");
        apa2 = ImageLoader.LoadImage("/textures/Ocean/bk_water22.jpg");

        conexLv12 = new BufferedImage[2];
        conexLv12[0] = ImageLoader.LoadImage("/textures/Level2/ConexLevel1Level2_.png");
        conexLv12[1] = ImageLoader.LoadImage("/textures/Level2/ConexLevel1Level2_Pressed.png");

        Level1StateMusic = new Sound("res/textures/MusicLev/ocean-waves-1_uHLhTEwz.wav");

        //************************************************************************************************
        //**************************************LEVEL_2***************************************************

        plajaStart1   = ImageLoader.LoadImage("/textures/Level2/Plaja_padure4x4.png");
        plajaStart2   = ImageLoader.LoadImage("/textures/Level2/Plaja2_padure4x4.png");
        plajaStart3   = ImageLoader.LoadImage("/textures/Level2/Plaja3_padure4x4.png");
        plajaContinue = ImageLoader.LoadImage("/textures/Level2/plaja22.png");
        plajaContinueDreapta = ImageLoader.LoadImage("/textures/Level2/plaja22_dreapta.png");
        plajaStart1Dreapta   = ImageLoader.LoadImage("/textures/Level2/start_Onedin_valyriDreapta1.jpg");
        iarba                = ImageLoader.LoadImage("/textures/Level2/Tile_iarba1024.png");
        drumPadure11  = ImageLoader.LoadImage("/textures/Level2/PadureCarare2_4x4.png");
        drumPadure12  = ImageLoader.LoadImage("/textures/Level2/PadureCarare3_4x4.png");
        drumPadure13  = ImageLoader.LoadImage("/textures/Level2/PadureCarare4_4x4.png");
        drumPadure14  = ImageLoader.LoadImage("/textures/Level2/PadureCarare5_4x4.png");

        copac         = ImageLoader.LoadImage("/textures/Level2/_tree_01_prev_0.png");
        copac2        = ImageLoader.LoadImage("/textures/Level2/_tree_11_prev.png");
        mort1  = ImageLoader.LoadImage("/textures/SclaviSprites/sclav1_moare.png");
        mort2  = ImageLoader.LoadImage("/textures/SclaviSprites/sclav2_moare.png");

        cort          = ImageLoader.LoadImage("/textures/Level2/cort_femelaSicopil.png");
        Salbatic2Atack = new BufferedImage[4][6];
        Salbatic2Walk  = new BufferedImage[4][9];
        SalbaticAtack = new BufferedImage[4][6];
        SalbaticWalk  = new BufferedImage[4][9];
        OnedinAtack   = new BufferedImage[4][6];
        OnedinWalk    = new BufferedImage[4][9];



        int i, j;



        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Onedin/onedin_sabieWalk.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/Onedin/onedin_sabieAtack.png"));



        for(i=0;i<4;i++)
        {
            for (j = 0; j < 9; j++)
            {
                OnedinWalk[i][j] = sheet.crop( j, i, 0);
            }
        }

        for(i=0;i<4;i++)
        {
            for (j = 0; j < 6; j++)
            {
                OnedinAtack[i][j] = sheet2.crop( j, i, 1);
            }
        }

        SpriteSheet sheet3   = new SpriteSheet(ImageLoader.LoadImage("/textures/SclaviSprites/sclav1Walk.png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.LoadImage("/textures/SclaviSprites/sclav1Atack.png"));

        for(i=0;i<4;i++)
        {
            for (j = 0; j < 6; j++)
            {
                SalbaticAtack[i][j] = sheet4.crop( j, i, 1);
            }
        }

        for(i=0;i<4;i++)
        {
            for (j = 0; j < 9; j++)
            {
                SalbaticWalk[i][j] = sheet3.crop( j, i, 0);
            }
        }

        SpriteSheet sheet5   = new SpriteSheet(ImageLoader.LoadImage("/textures/SclaviSprites/sclav2Walk.png"));
        SpriteSheet sheet6 = new SpriteSheet(ImageLoader.LoadImage("/textures/SclaviSprites/sclav2Atack.png"));

        for(i=0;i<4;i++)
        {
            for (j = 0; j < 6; j++)
            {
                Salbatic2Atack[i][j] = sheet6.crop( j, i, 1);
            }
        }

        for(i=0;i<4;i++)
        {
            for (j = 0; j < 9; j++)
            {
                Salbatic2Walk[i][j] = sheet5.crop( j, i, 0);
            }
        }

        /*OnedinWalk[0][1] = sheet.crop(0,0);
        OnedinWalk[0][2] = sheet.crop(0,1);
        OnedinWalk[0][3] = sheet.crop(0,2);
        OnedinWalk[0][4] = sheet.crop(0,3);
        OnedinWalk[0][5] = sheet.crop(0,4);
        OnedinWalk[0][6] = sheet.crop(0,5);
        OnedinWalk[0][7] = sheet.crop(0,6);
        OnedinWalk[0][8] = sheet.crop(0,7);
        OnedinWalk[0][9] = sheet.crop(0,8);

        OnedinWalk[1][1] = sheet.crop(1,0);
        OnedinWalk[1][2] = sheet.crop(1,1);
        OnedinWalk[1][3] = sheet.crop(1,2);
        OnedinWalk[1][4] = sheet.crop(1,3);
        OnedinWalk[1][5] = sheet.crop(1,4);
        OnedinWalk[1][6] = sheet.crop(1,5);
        OnedinWalk[1][7] = sheet.crop(1,6);
        OnedinWalk[1][8] = sheet.crop(1,7);
        OnedinWalk[1][9] = sheet.crop(1,8);*/

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        //menu = sheet.crop(0,0);

        /*grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        playerLeft = sheet.crop(0, 2);
        playerRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);*/
    }
}
