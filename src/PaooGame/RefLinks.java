package PaooGame;
import PaooGame.Entities.Onedin;
import PaooGame.Input.MouseManager;


import PaooGame.Input.KeyManager;
import PaooGame.States.State;

public class RefLinks
{
    private final Game game;
    private int x, y;
    private Onedin onedin;
    private int score;

    public RefLinks(Game game)
    {
        this.game = game;
    }

    public void setScore(int score ) { this.score = score; }
    public int getScore(){ return score; }

    public void SetOnedin(Onedin onedin) { this.onedin = onedin; }
    public Onedin returnOnedin(){ return onedin;}
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }



    public KeyManager GetKeyManager()
    {
        return game.getKeyManager();
    }

    public State getCurentState(){ return State.getCurrentState(); }

    public MouseManager GetMouseManager(){ return game.GetMouseManager();}

    public Game GetGame()
    {
        return game;
    }
}


