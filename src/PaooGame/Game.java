package PaooGame;

import PaooGame.GameWindow.GameCamera;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;

import PaooGame.Tiles.Tile;
import PaooGame.Word.*;

/*! \class Game
    \brief Clasa principala a intregului proiect. Implementeaza Game - Loop (Update -> Draw)

                ------------
                |           |
                |     ------------
    60 times/s  |     |  Update  |  -->{ actualizeaza variabile, stari, pozitii ale elementelor grafice etc.
        =       |     ------------
     16.7 ms    |           |
                |     ------------
                |     |   Draw   |  -->{ deseneaza totul pe ecran
                |     ------------
                |           |
                -------------
    Implementeaza interfata Runnable:

        public interface Runnable {
            public void run();
        }

    Interfata este utilizata pentru a crea un nou fir de executie avand ca argument clasa Game.
    Clasa Game trebuie sa aiba definita metoda "public void run()", metoda ce va fi apelata
    in noul thread(fir de executie). Mai multe explicatii veti primi la curs.

    In mod obisnuit aceasta clasa trebuie sa contina urmatoarele:
        - public Game();            //constructor
        - private void init();      //metoda privata de initializare
        - private void update();    //metoda privata de actualizare a elementelor jocului
        - private void draw();      //metoda privata de desenare a tablei de joc
        - public run();             //metoda publica ce va fi apelata de noul fir de executie
        - public synchronized void start(); //metoda publica de pornire a jocului
        - public synchronized void stop()   //metoda publica de oprire a jocului
 */
public class Game implements Runnable
{
    private GameWindow      wnd;        /*!< Fereastra in care se va desena tabla jocului*/
    private boolean         runState;   /*!< Flag ce starea firului de executie.*/
    private Thread          gameThread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/
    private BufferStrategy  bs;         /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/

    ///                         |------------------------------------------------>|
    ///                         |                                                 |
    ///                 ****************          *****************        ***************
    ///                 *              *   Show   *               *        *             *
    /// [ Ecran ] <---- * Front Buffer *  <------ * Middle Buffer * <----- * Back Buffer * <---- Draw()
    ///                 *              *          *               *        *             *
    ///                 ****************          *****************        ***************

    private Graphics        g;          /*!< Referinta catre un context grafic.*/

    private int Width;
    private int Height;
    private State menuState;
    private State settingsState;
    private State pauseState;
    private State level1State;
    private State level2State;
    private State level3State;
    private State YouLose;
    private int ceLevel = 1;
    //runState = false;
    private KeyManager keyManager = new KeyManager();
    private MouseManager mouseManager = new MouseManager();
    private RefLinks refLink;

    private Tile tile; /*!< variabila membra temporara. Este folosita in aceasta etapa doar pentru a desena ceva pe ecran.*/


    public Word world;
    public KeyManager getKeyManager(){ return keyManager; }
    public MouseManager GetMouseManager(){ return mouseManager;}

    //Camera
    private GameCamera gameCamera;

    public Game(String title, int width, int height)
    {
        this.Width  = width;
        this.Height = height;
        wnd = new GameWindow(title, width, height);
    }

    private void InitGame()
    {
        wnd = new GameWindow("Revelation", 1024, 868);
        wnd.BuildGameWindow();
        wnd.getFrame().addKeyListener(keyManager);
        wnd.getFrame().addMouseListener(mouseManager);
        wnd.getFrame().addMouseMotionListener(mouseManager);
        wnd.GetCanvas().addMouseListener(mouseManager);
        wnd.GetCanvas().addMouseListener(mouseManager);
        wnd.GetCanvas().addMouseMotionListener(mouseManager);


        Assets.Init();

        gameCamera = new GameCamera(this,0,0);

        refLink         = new RefLinks(this);
        menuState       = new MenuState(refLink);
        level1State     = new Level1_State(refLink);
        level2State     = new Level2_State(refLink);
        //YouLose         = new YouLose(refLink);

      // State.setCurrentState(level1State);

     // State.setCurrentState(level2State);
        State.setCurrentState(menuState);

    }

    public State getYouLose() {
        return YouLose;
    }

    public void run()
    {

        InitGame();
        long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
        long curentTime;                    /*!< Retine timpul curent de executie.*/

            /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
            /// sau mai bine spus de 60 ori pe secunda.

        final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
        final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

            /// Atat timp timp cat threadul este pornit Update() & Draw()
        while (runState == true)
        {
                /// Se obtine timpul curent
            curentTime = System.nanoTime();
                /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
            if((curentTime - oldTime) > timeFrame)
            {
                Update();
                try {
                    Draw();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                oldTime = curentTime;
            }
        }

    }

    public synchronized void StartGame()
    {
        if(runState == false)
        {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            runState = false;
            try
            {
                    /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                    /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }

        else
        {
                /// Thread-ul este oprit deja.
            return;
        }
    }

    private void Update()
    {
        keyManager.Update();
        if (State.getCurrentState() != null){
            State.getCurrentState().Update();
            wnd.getFrame().requestFocusInWindow();
        }
    }

    private void Draw() throws SQLException {
        bs = wnd.GetCanvas().getBufferStrategy();
        if(bs == null)
        {
            try
            {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();


        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());
        if (State.getCurrentState() != null){
            State.getCurrentState().Draw(g);
        }

        bs.show();
        g.dispose();
    }

    public static State returnNewLevel1State(RefLinks refLink) { return new Level1_State(refLink); }
    public static State returnNewLevel2State(RefLinks refLink) { return new Level2_State(refLink); }
    public static State returnNewMenuState(RefLinks refLink) { return new MenuState(refLink); }
    public State returnNewYouLoseState(RefLinks refLink) { return new YouLose(refLink, getCeLevel()); }
    public int getCeLevel() {
        return ceLevel;
    }
    public void setLevel(int lvel){ this.ceLevel = lvel; }

    public int getWidth() {
        return Width;
    }
    public int getHeight() {
        return Height;
    }
    public void setCurentWorld( Word word)
    {
        world = word;
    }
    public Word getWorld(){  return world; }
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
    public State getLevel1State() { return level1State; }
    public State getLevel2State() { return level2State; }

}

