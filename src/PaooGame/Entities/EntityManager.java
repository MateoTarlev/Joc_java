package PaooGame.Entities;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import PaooGame.Enemies.Cort;
import PaooGame.Enemies.EnemEntity;
import PaooGame.Enemies.Tre;
import PaooGame.Enemies.Tree;
import PaooGame.RefLinks;

public class EntityManager {
    private RefLinks refLink;
    private Tree tree;
    private Tre tre;
    private Cort cort;
    private ArrayList<EnemEntity> entities;

    public EntityManager(RefLinks refLink/*, Tree tree, Tre tre, Cort cort*/){
        this.refLink = refLink;
        /*this.tree = tree;
        this.tre  = tre;
        this.cort = cort;*/
        entities = new ArrayList<EnemEntity>();
        /*addEntity(player);*/
    }

    public void Update(){
        for(int i = 0;i < entities.size();i++){
            EnemEntity e = entities.get(i);
            e.Update(1, 1);
        }
        //player.Update();
    }

    public void Draw(Graphics g){
        for(int i = 0;i < entities.size();i++){
            EnemEntity e = entities.get(i);
            e.Draw(g);
        }
        //player.Draw(g);
    }

    public void addEntity(EnemEntity e){
        entities.add(e);
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) { this.refLink=refLink; }

    /*public Tree getTree() {
        return tree;
    }

    public Tre getTre() {
        return tre;
    }

    public Cort getCort() {
        return cort;
    }*/

    public void setPlayer(Player player) {
        this.tre = tre;
    }

    public void removeEntity(EnemEntity entity) { entities.remove(entity); }

    public ArrayList<EnemEntity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<EnemEntity> items) {
        this.entities = items;
    }

}
