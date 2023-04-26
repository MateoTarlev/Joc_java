package PaooGame.States;

import PaooGame.BazaDate.Singleton;
import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Player;
import PaooGame.Enemies.Rechin;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Word.Word;
import PaooGame.Input.KeyManager;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class Level1_State extends State{
    private Player player;
    private Rechin []rechin;
    private Word world;
    private RefLinks refLinks;



    public int fg16 = 0,flag=0, flagR = 0, flagRA = 0, flagV = 0, flag5 = 0, flag6 = 0, flag7 = 0, flag8 = 0,flag9 =0, flag10=0, flag11 = 0, flagPoveste = 0;
    public int cnt=0, contor = 0, contor2 = 0, contoRechin = 0, contoRechinA = 0, contoRechinNemo = 0, contorRechinV = 0, contorF = 0;
    protected boolean youLose = false;
    Singleton dbConnection = Singleton.getInstance();


    public Level1_State(RefLinks refLink) {
        super(refLink);
        this.refLinks = refLink;

       refLink.GetGame().setLevel(1);
        player = new Player(40, 2, 260, 240, refLink, 411,621); //spown ul lui Onedin: x:442,y:518 speed = 2
        entityManager = new EntityManager(refLink);
        world=new Word( refLink, refLink.GetGame(), "res/textures/World/world1.txt");
        rechin = new Rechin[20];
        rechin[0] = new Rechin(30, 2, 200, 200, refLink, (int) (Math.random() * 900), -200, 1);
        entityManager.addEntity(rechin[0]);
        refLink.GetGame().setCurentWorld(world); //*******ADD
        //Assets.Level1StateMusic.setVolume(0.5);
        //Assets.Level1StateMusic.play();
    }

    @Override
    public void Update()
    {
        if(flagPoveste==0 && !youLose) {
            cnt++;
            contor2++;
            contorF++;
            contoRechin++;
            contoRechinA++;
            contorRechinV++;
            contoRechinNemo++;
            if (contorF == 500) {
                //System.out.println("ee " + player.getX());
                rechin[7] = new Rechin(30, 9f, 200, 200, refLink, player.getX(), -200, 1);
                entityManager.addEntity(rechin[7]);
                //player.incScore18();



                flag7 = 1;
                contorF = 0;
            }

            if(cnt==300){
                rechin[16] = new Rechin(30,9f,200,200,refLink, player.getX()+49,-200,3 );
                rechin[17] = new Rechin(30,9f,200,200,refLink, player.getX()-49,-200,4 );
                entityManager.addEntity(rechin[16]);
                entityManager.addEntity(rechin[17]);

                fg16 = 1;
                cnt = 0;
            }



            switch (contor) {
                case 5000:
                    rechin[7] = new Rechin(30, 9f, 200, 200, refLink, player.getX() + 80, -200, 1);
                    entityManager.addEntity(rechin[7]);
                    rechin[8] = new Rechin(30, 9f, 200, 200, refLink, player.getX() - 80, -200, 1);
                    entityManager.addEntity(rechin[8]);

                    flag8 = 1;
                    break;
                case 10000:
                    rechin[7] = new Rechin(30, 9f, 200, 200, refLink, player.getX() + 70, -200, 1);
                    entityManager.addEntity(rechin[7]);
                    rechin[8] = new Rechin(30, 9f, 200, 200, refLink, player.getX() - 70, -200, 1);
                    flag8 = 1;

                    break;
                case 1501:
                    rechin[11] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX() + 80, -200, 1);
                    entityManager.addEntity(rechin[11]);
                    rechin[8] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX() - 80, -200, 1);
                    entityManager.addEntity(rechin[8]);
                    rechin[9] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX(), -220, 2);
                    entityManager.addEntity(rechin[9]);


                    flag11 = 1;
                    flag9 = 1;
                    flag8 = 1;
                    break;
                case 500:
                    rechin[5] = new Rechin(30, 6.9f, 200, 200, refLink, 400, -200, 1);
                    entityManager.addEntity(rechin[5]);


                    flag5 = 1;
                    break;
                case 1500:
                    rechin[5] = new Rechin(30, 6.9f, 200, 200, refLink, 400, -200, 1);
                    entityManager.addEntity(rechin[5]);


                    break;
                case 3500:
                    rechin[6] = new Rechin(30, 4.66f, 200, 200, refLink, 600, -200, 4);
                    entityManager.addEntity(rechin[6]);


                    flag6 = 1;
                    break;
                case 6000:
                    rechin[6] = new Rechin(30, 7.66f, 200, 200, refLink, 750, -200, 4);
                    entityManager.addEntity(rechin[6]);


                    flag6 = 1;
                    break;
                case 9000:
                    rechin[5] = new Rechin(30, 3.9f, 200, 200, refLink, 350, -200, 1);
                    entityManager.addEntity(rechin[5]);


                    break;
                case 1000:
                    rechin[11] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX() + 80, -200, 1);
                    entityManager.addEntity(rechin[11]);
                    rechin[8] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX() - 80, -200, 1);
                    entityManager.addEntity(rechin[8]);
                    rechin[9] = new Rechin(30, 8.5f, 200, 200, refLink, player.getX(), -220, 2);
                    entityManager.addEntity(rechin[9]);


                    if(player.getX()+77+63  + 180 > rechin[9].getX() +36 || player.getX()+77 -180 < rechin[9].getX()+36+90 && 840 == rechin[9].getY())
                    {
                        player.incScore9();

                    }else if(player.getX()+77+63  + 45 > rechin[9].getX() +36 || player.getX()+77 -45 < rechin[9].getX()+36+90 && 840 == rechin[9].getY())
                    {
                        player.incScore18();
                    }else if(player.getX()+77+63  + 9 > rechin[9].getX() +36 || player.getX()+77 -9 < rechin[9].getX()+36+90 && 840 == rechin[9].getY()){
                        player.incScore45();
                    }

                    if(player.getX()+77+63  + 180 > rechin[11].getX() +36 || player.getX()+77 -180 < rechin[11].getX()+36+90 && 840 == rechin[11].getY())
                    {
                        player.incScore9();

                    }else if(player.getX()+77+63  + 45 > rechin[11].getX() +36 || player.getX()+77 -45 < rechin[11].getX()+36+90 && 840 == rechin[11].getY())
                    {
                        player.incScore18();
                    }else if(player.getX()+77+63  + 9 > rechin[11].getX() +36 || player.getX()+77 -9 < rechin[11].getX()+36+90 && 840 == rechin[11].getY()){
                        player.incScore45();
                    }

                    if(player.getX()+77+63  + 180 > rechin[8].getX() +36 || player.getX()+77 -180 < rechin[8].getX()+36+90 && 840 == rechin[8].getY())
                    {
                        player.incScore9();

                    }else if(player.getX()+77+63  + 45 > rechin[8].getX() +36 || player.getX()+77 -45 < rechin[8].getX()+36+90 && 840 == rechin[8].getY())
                    {
                        player.incScore18();
                    }else if(player.getX()+77+63  + 9 > rechin[8].getX() +36 || player.getX()+77 -9 < rechin[8].getX()+36+90 && 840 == rechin[8].getY()){
                        player.incScore45();
                    }
                    flag11 = 1;
                    flag9 = 1;
                    flag8 = 1;
                    break;
                case 16000:
                    rechin[5] = new Rechin(30, 6.9f, 200, 200, refLink, 350, -200, 3);
                    entityManager.addEntity(rechin[5]);


                    break;

                case 14400:
                    rechin[5] = new Rechin(30, 6f, 200, 200, refLink, 400, -200, 1);
                    entityManager.addEntity(rechin[5]);


                    flag5 = 1;
                    break;
                case 15000:
                    rechin[5] = new Rechin(30, 6.9f, 200, 200, refLink, 550, -200, 1);
                    entityManager.addEntity(rechin[5]);



                    break;
                case 15600:
                    rechin[6] = new Rechin(30, 9f, 200, 200, refLink, player.getX() - 100, -200, 3);
                    entityManager.addEntity(rechin[6]);
                    rechin[10] = new Rechin(30, 9f, 200, 200, refLink, player.getX() + 120, -200, 2);
                    entityManager.addEntity(rechin[10]);


                    if((player.getX()+77+63  + 180 > rechin[10].getX() +36 || player.getX()+77 -180 < rechin[10].getX()+36+90) && 840 == rechin[10].getY())
                    {
                        player.incScore9();

                    }else if((player.getX()+77+63  + 45 > rechin[10].getX() +36 || player.getX()+77 -45 < rechin[10].getX()+36+90) && 840 == rechin[10].getY())
                    {
                        player.incScore18();
                    }else if((player.getX()+77+63  + 9 > rechin[10].getX() +36 || player.getX()+77 -9 < rechin[10].getX()+36+90) && 840 == rechin[10].getY()){
                        player.incScore45();
                    }
                    flag10 = 1;
                    flag6 = 1;
                    break;
                case 16600:
                    rechin[6] = new Rechin(30, 5.66f, 200, 200, refLink, 750, -200, 4);
                    entityManager.addEntity(rechin[6]);


                    flag6 = 1;
                    break;
                case 16800:
                    rechin[5] = new Rechin(30, 3.9f, 200, 200, refLink, 350, -200, 1);
                    entityManager.addEntity(rechin[5]);

                    break;
                case 17300:
                    rechin[5] = new Rechin(30, 5.9f, 200, 200, refLink, 650, -200, 3);
                    entityManager.addEntity(rechin[5]);


                    break;

            }

            if (contoRechin == 430) //~6 secunde, start Rechin_sur
            {
                //System.out.println((int)(Math.random()*1000));
                rechin[1] = new Rechin(30, 4, 200, 200, refLink, (int) (Math.random() * 900), -200, 2);
                entityManager.addEntity(rechin[1]);


                contoRechin = 0;
                flagR = 1;
                //rechin[0] = new Rechin(30, 2, 200,200, game, 411, -200, 1);
            }

            if (contoRechinA == 550) {//~6 secunde, start Rechin_Alb, doar ca apare si la inceput
                rechin[0] = new Rechin(30, 4, 200, 200, refLink, (int) (Math.random() * 900), -200, 1);


                entityManager.addEntity(rechin[0]);
                contoRechinA = 0;
            }

            if (contorRechinV == 1800) {
                flagV = 1;
                rechin[3] = new Rechin(30, 5.4f, 200, 200, refLink, (int) (Math.random() * 500), -200, 4);


                entityManager.addEntity(rechin[3]);
                contorRechinV = 0;
            }

            if (contoRechinNemo == 250) {
                flagRA = 1;
                rechin[2] = new Rechin(30, 4.2f, 200, 200, refLink, (int) (Math.random() * 900), -200, 3);
                entityManager.addEntity(rechin[2]);
                contoRechinNemo = 0;
            }

            if (contor2 < 38) {
                flag = 1;
            } else if (contor2 < 76) {
                if (contor2 == 75)
                    contor2 = 0;
                flag = 0;
            }

            if (contor < 38)//contor pentru mapa cu apa
            {
                world.Update(flag);
            } else {
                //System.out.println("sunt la flag = " + flag);
                world.Update(flag);

            }

            player.Update();

            rechin[0].Update(1, 1);
            if (flagR == 1)
                rechin[1].Update(1, 1);
            if (flagRA == 1)
                rechin[2].Update(1, 1);
            if (flagV == 1)
                rechin[3].Update(1, 1);
            if (flag5 == 1)
                rechin[5].Update(1, 1);
            if (flag6 == 1)
                rechin[6].Update(1, 1);
            if (flag7 == 1)
                rechin[7].Update(1, 1);
            if (flag8 == 1)
                rechin[8].Update(1, 1);
            if (flag9 == 1)
                rechin[9].Update(1, 1);
            if (flag10 == 1)
                rechin[10].Update(1, 1);
            if (flag11 == 1)
                rechin[11].Update(1, 1);
            if(fg16 == 1)
            {
                rechin[16].Update(1, 1);
                rechin[17].Update(1, 1);
            }
        }

    }

    @Override
    public void Draw(Graphics g) throws SQLException {
        contor++; //pana la 18000~5 min

        if(flagPoveste == 0 && contor< 18000 && !youLose) {
            if(contor== 18000) {
                try {
                    Thread.sleep(2700);
                }catch (InterruptedException e) {
                    System.err.println("Error: MenuState: Thread Sleep");
                }
            }
                world.Draw(g);


                rechin[0].Draw(g);
                if((((player.getX()+77+63  + 180) > (rechin[0].getX() +36) )|| ((player.getX()+77 -180) < (rechin[0].getX()+36+90)) ) && (580 == rechin[0].getY()))
                {
                    player.incScore9(); // +10p

                }
                if((((player.getX()+77+63  + 45 )> (rechin[0].getX() +36)) || ((player.getX()+77 -45) < (rechin[0].getX()+36+90))) && (580 == rechin[0].getY()))
                {
                    player.incScore9(); //+20p
                }
                if((((player.getX()+77+63  + 19) > (rechin[0].getX() +36)) || ((player.getX()+77 -19) < (rechin[0].getX()+36+90))) && (580 == rechin[0].getY())){
                    player.incScore45(); //+30 + 20 = ((+50p
                }
                if (flagR == 1) {
                    rechin[1].Draw(g);

                    if((player.getX()+77+63  + 180 > rechin[1].getX() +36 || player.getX()+77 -180 < rechin[1].getX()+36+90) && 580 == rechin[1].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[1].getX() +36 || player.getX()+77 -45 < rechin[1].getX()+36+90) && 580 == rechin[1].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[1].getX() +36 || player.getX()+77 -19 < rechin[1].getX()+36+90) && 580 == rechin[1].getY()){
                        player.incScore45();
                    }
                }
                if (flagRA == 1) {
                    rechin[2].Draw(g);
                    if((player.getX()+77+63  + 180 > rechin[2].getX() +36 || player.getX()+77 -180 < rechin[2].getX()+36+90) && 580 == rechin[2].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[2].getX() +36 || player.getX()+77 -45 < rechin[2].getX()+36+90) && 580 == rechin[2].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[2].getX() +36 || player.getX()+77 -19 < rechin[2].getX()+36+90) && 580 == rechin[2].getY()){
                        player.incScore45();
                    }
                }
                if (flagV == 1) {
                    rechin[3].Draw(g);

                    if((player.getX()+77+63  + 180 > rechin[3].getX() +36 || player.getX()+77 -180 < rechin[3].getX()+36+90) && 580 == rechin[3].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[3].getX() +36 || player.getX()+77 -45 < rechin[3].getX()+36+90) && 580 == rechin[3].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[3].getX() +36 || player.getX()+77 -19 < rechin[3].getX()+36+90) && 580 == rechin[3].getY()){
                        player.incScore45();
                    }
                }
                if (flag6 == 1) {
                    rechin[6].Draw(g);

                    if((player.getX()+77+63  + 180 > rechin[6].getX() +36 || player.getX()+77 -180 < rechin[6].getX()+36+90) && 580 == rechin[6].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[6].getX() +36 || player.getX()+77 -45 < rechin[6].getX()+36+90) && 580 == rechin[6].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[6].getX() +36 || player.getX()+77 -19 < rechin[6].getX()+36+90) && 580 == rechin[6].getY()){
                        player.incScore45();
                    }
                }
                if (flag5 == 1) {
                    rechin[5].Draw(g);
                    if((player.getX()+77+63  + 180 > rechin[5].getX() +36 || player.getX()+77 -180 < rechin[5].getX()+36+90) && 580 == rechin[5].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[5].getX() +36 || player.getX()+77 -45 < rechin[5].getX()+36+90) && 580 == rechin[5].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[5].getX() +36 || player.getX()+77 -19 < rechin[5].getX()+36+90) && 580 == rechin[5].getY()){
                        player.incScore45();
                    }
                }
                if (flag7 == 1) {
                    rechin[7].Draw(g);
                    if((player.getX()+77+63  + 180 > rechin[7].getX() +36 || player.getX()+77 -180 < rechin[7].getX()+36+90) && 580 == rechin[7].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[7].getX() +36 || player.getX()+77 -45 < rechin[7].getX()+36+90) && 580 == rechin[7].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[7].getX() +36 || player.getX()+77 -19 < rechin[7].getX()+36+90) && 580 == rechin[7].getY()){
                        player.incScore45();
                    }
                }
                if (flag8 == 1) {
                    rechin[8].Draw(g);
                    if((player.getX()+77+63  + 180 > rechin[8].getX() +36 || player.getX()+77 -180 < rechin[8].getX()+36+90) && 580 == rechin[8].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[8].getX() +36 || player.getX()+77 -45 < rechin[8].getX()+36+90) && 580 == rechin[8].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[8].getX() +36 || player.getX()+77 -19 < rechin[8].getX()+36+90) && 580 == rechin[8].getY()){
                        player.incScore45();
                    }
                }
                if (flag9 == 1) {
                    rechin[9].Draw(g);
                    if((player.getX()+77+63  + 180 > rechin[9].getX() +36 || player.getX()+77 -180 < rechin[9].getX()+36+90) && 580 == rechin[9].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[9].getX() +36 || player.getX()+77 -45 < rechin[9].getX()+36+90) && 580 == rechin[9].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[9].getX() +36 || player.getX()+77 -19 < rechin[9].getX()+36+90) && 580 == rechin[9].getY()){
                        player.incScore45();
                    }
                }
                if (flag10 == 1) {
                    rechin[10].Draw(g);

                    if((player.getX()+77+63  + 180 > rechin[10].getX() +36 || player.getX()+77 -180 < rechin[10].getX()+36+90) && 580 == rechin[10].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[10].getX() +36 || player.getX()+77 -45 < rechin[10].getX()+36+90) && 580 == rechin[10].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[10].getX() +36 || player.getX()+77 -19 < rechin[10].getX()+36+90) && 580 == rechin[10].getY()){
                        player.incScore45();
                    }
                }
                if (flag11 == 1) {
                    rechin[11].Draw(g);

                    if((player.getX()+77+63  + 180 > rechin[11].getX() +36 || player.getX()+77 -180 < rechin[11].getX()+36+90) && 580 == rechin[11].getY())
                    {
                        player.incScore9();

                    }
                    if((player.getX()+77+63  + 45 > rechin[11].getX() +36 || player.getX()+77 -45 < rechin[11].getX()+36+90) && 580 == rechin[11].getY())
                    {
                        player.incScore18();
                    }
                    if((player.getX()+77+63  + 19 > rechin[11].getX() +36 || player.getX()+77 -19 < rechin[11].getX()+36+90) && 580 == rechin[11].getY()){
                        player.incScore45();
                    }
                }
            if(fg16==1){
                rechin[16].Draw(g);
                rechin[17].Draw(g);


                if((player.getX()+77+63  + 45 > rechin[16].getX() +36 || player.getX()+77 -45 < rechin[16].getX()+36+90) && 580 == rechin[16].getY())
                {
                    player.incScore18();
                }



                if((player.getX()+77+63  + 45 > rechin[17].getX() +36 || player.getX()+77 -45 < rechin[17].getX()+36+90) && 580 == rechin[17].getY())
                {
                    player.incScore18();
                }

            }

                player.Draw(g);
             System.out.println("X = " + game.GetMouseManager().getMouseX() + "  ;Y =  " + game.GetMouseManager().getMouseY() );
            System.out.println("Xp = " + player.getX() + "  ;Yp =  " + player.getY() );
            if(player.checkEntityCollisions(0, 0) && player.checkEntityCollisions(0,0))
            {
                youLose = true;
                //g.drawImage(Assets.YL,0,0,1024,868,null);
            }

            refLink.setScore(player.getScore());

        }else if(contor>= 18000) { //18 000
            flagPoveste = 1;
            /*System.exit(0); //doar de testare, ma asigur ca poate rula 5 minute, primul level va dura 5 minute aproximativ*/

                g.drawImage(Assets.conexLv12[0], 0, 0, 1024, 868, null);
                /* System.out.println("X = " + game.GetMouseManager().getMouseX() + "  ;Y =  " + game.GetMouseManager().getMouseY() );*/
                if (refLink.GetGame().GetMouseManager().getMouseX() >= 382 && refLink.GetGame().GetMouseManager().getMouseX() <= 986) {
                    if (refLink.GetGame().GetMouseManager().getMouseY() >= 317 && refLink.GetGame().GetMouseManager().getMouseY() <= 365) {
                        g.drawImage(Assets.conexLv12[1], 0, 0, 1024, 868, null);
                        if (game.GetMouseManager().leftClickPressed()) {
                            try {
                                Thread.sleep(1700);
                                Assets.Level1StateMusic.stop();
                                Assets.ahBer.stop();
                                Assets.BattleOfGods.play();
                                Assets.BattleOfGods.setVolume(0.70);
                                State.setCurrentState(refLink.GetGame().getLevel2State());
                            } catch (InterruptedException e) {
                                System.err.println("Error: MenuState: Thread Sleep");
                            }
                        }
                    }
                }
        }else if(youLose) {
            Assets.Level1StateMusic.stop();
            Assets.ahBer.stop();
            int score = refLink.GetGame().getLevel1State().refLink.getScore();
            //insertScoreIntoDB(score);
            /*State.setCurrentState(refLink.GetGame().getYouLose());*/
            State.setCurrentState( game.returnNewYouLoseState(refLink) );
        }

    }

    public void insertScoreIntoDB(int score) throws SQLException {
        Statement stmt = null;

        Connection connection = dbConnection.getConnection();
        stmt = connection.createStatement();
        String query = "INSERT INTO Revelation VALUES(?)";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, score);
        pstmt.executeUpdate();

    }
}

