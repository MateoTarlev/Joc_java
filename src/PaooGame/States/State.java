package PaooGame.States;

import java.awt.*;
import java.sql.SQLException;

import PaooGame.Enemies.EnemEntity;
import PaooGame.Entities.EntityManager;
import PaooGame.Game;
import PaooGame.RefLinks;

public abstract class State {
    protected Game game;
    private static State currentState = null;
    protected final RefLinks refLink;
    public EntityManager entityManager;

    public State(RefLinks refLink) {
        this.refLink = refLink;
        this.game = refLink.GetGame();
    }

    public boolean flagPoveste = false, flagPoveste2 = false, flagLevel1 = false;
    public static void setCurrentState(State state) {
        currentState = state;
    }
    public static State getCurrentState() {
        return currentState;
    }


    public abstract void Update();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public abstract void Draw(Graphics g) throws SQLException;

    /*public void insertScoreIntoDB(int score) throws SQLException {
        Statement stmt = null;
        Connection connection = dbConnection.getConnection();
        stmt = connection.createStatement();
        String query = "INSERT INTO SCORE VALUES(?,?,?,?,?)";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, score);
        pstmt.executeUpdate();

    }*/
   /* public EnemEntity[] getEntityManager() {
    }*/
}
