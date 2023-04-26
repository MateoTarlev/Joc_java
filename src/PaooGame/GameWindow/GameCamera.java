package PaooGame.GameWindow;
import PaooGame.Game;
import PaooGame.Entities.*;


public class GameCamera {
    private Game game;
    private float xOffset, yOffset;
    public GameCamera(Game game, float xOffset, float yOffset)
    {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnOnedin(Onedin onedin){
        xOffset = onedin.getX() - game.getWidth()/2 + 145/2; //l-am centrat pe Onedin in centru
        yOffset = onedin.getY() - game.getHeight()/2 + 145/2;
    }

    public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
