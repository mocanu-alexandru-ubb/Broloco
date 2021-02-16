import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Template here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Template extends World
{
    static final int cell = 64;
    public Player player = null;
    public text_box txt = null;
    soundplayer sfx = null;

    int default_bgm = 6;
    String lava = "_grass";

    public void set_lava() { lava = "_lava";}
    public int get_bgm() {return default_bgm;}

    public void set_sfx (soundplayer new_sfx, int def)
    {
        sfx = new_sfx;
        default_bgm = def;
    }

    public soundplayer get_sfx()
    {
        return sfx;
    }

    public Player get_player ()
    {
        return player;
    }

    public boolean set_coord (int coord_x, int coord_y, Player pl)
    {
        addObject(pl, coord_x, coord_y);
        set_player(pl);
        System.out.println("Set player at: " + coord_x + ", " + coord_y);
        get_player().eligible_for_breda();
        return true;
    }

    public void set_player (Player new_player)
    {
        player = new_player;
    }

    public text_box get_txt ()
    {
        return txt;
    }

    public void set_txt (text_box new_txt)
    {
        txt = new_txt;
    }

    public void generate (int[][] map, boolean main)
    {
        System.out.println("Generated");
        Actor ground = new Verde();
        ground.setImage(new GreenfootImage(1280, 768));
        Actor path = new Path();
        path.setImage(new GreenfootImage(1280, 768));

        Random rand = new Random();

        for (int i=-1; i < 21; i++)
        {
            addObject(new Pres_nou(), cell/2 + i*cell, -cell/2);
            addObject(new Pres_nou(), -cell/2, cell/2 + i*cell);
            addObject(new Pres_nou(), cell/2 + i*cell, cell/2 + 768);
            addObject(new Pres_nou(), cell/2  + 1280, cell/2 + i*cell);
        }

        for (int i=0; i < 12; i++)
        {
            for (int j=0; j < 20; j++) 
            {
                int sample = rand.nextInt(5);
                ground.getImage().drawImage(new GreenfootImage("terrain" + lava + sample + ".png"), j*cell, i*cell);

                if (map[i][j] == 2) 
                {
                    Player pl = new Player();
                    addObject(pl, cell/2 + j*cell, cell/2 + i*cell);
                    set_player(pl);
                }
                if (map[i][j] == 4) 
                {
                    addObject(new Grass(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new Grass_fundal(), cell/2 + j*cell, cell/2 + i*cell);
                    //addObject(new Grass_fake(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 9) 
                {
                    int r = rand.nextInt(2);
                    if (r == 0)
                        addObject(new log0(), cell/2 + j*cell, cell/2 + i*cell);
                    else
                        addObject(new log1(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 12) 
                {
                    int r = rand.nextInt(2);
                    if (r == 0)
                        addObject(new rock0(), cell/2 + j*cell, cell/2 + i*cell);
                    else
                        addObject(new rock1(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 13)
                {
                    if (map[i][j+1] == 13) addObject(new rock2_left(), cell/2 + j*cell, cell/2 + i*cell);
                    else addObject(new rock2_right(), cell/2 + j*cell, cell/2 + i * cell);
                }
                
                if (map[i][j] == 14) path.getImage().drawImage(new GreenfootImage("path_corner3.png"),  j*cell,  i * cell);
                if (map[i][j] == 15) path.getImage().drawImage(new GreenfootImage("path_corner0.png"),  j*cell,  i * cell);
                if (map[i][j] == 16) path.getImage().drawImage(new GreenfootImage("path_corner1.png"),  j*cell,  i * cell);
                if (map[i][j] == 17) path.getImage().drawImage(new GreenfootImage("path_corner2.png"),  j*cell,  i * cell);
                if (map[i][j] == 18) path.getImage().drawImage(new GreenfootImage("path_halfup.png"),  j*cell,  i * cell);
                if (map[i][j] == 19) path.getImage().drawImage(new GreenfootImage("path_halfdown.png"),  j*cell,  i * cell);
                if (map[i][j] == 20) path.getImage().drawImage(new GreenfootImage("path_halfR.png"),  j*cell,  i * cell);
                if (map[i][j] == 21) path.getImage().drawImage(new GreenfootImage("path_halfL.png"),  j*cell,  i * cell);
                if (map[i][j] == 22) path.getImage().drawImage(new GreenfootImage("path_middle_vert.png"),  j*cell,  i * cell);
                if (map[i][j] == 23) path.getImage().drawImage(new GreenfootImage("path_middle_hor.png"),  j*cell,  i * cell);
                if (map[i][j] == 24) path.getImage().drawImage(new GreenfootImage("path_corner_inner0.png"),  j*cell,  i * cell);
                if (map[i][j] == 25) path.getImage().drawImage(new GreenfootImage("path_corner_inner1.png"),  j*cell,  i * cell);
                if (map[i][j] == 26) path.getImage().drawImage(new GreenfootImage("path_corner_inner2.png"),  j*cell,  i * cell);
                if (map[i][j] == 27) path.getImage().drawImage(new GreenfootImage("path_corner_inner3.png"),  j*cell,  i * cell);
                if (map[i][j] == 28) path.getImage().drawImage(new GreenfootImage("path_corner_inside0.png"),  j*cell,  i * cell);
                if (map[i][j] == 29) path.getImage().drawImage(new GreenfootImage("path_corner_inside1.png"),  j*cell,  i * cell);
                if (map[i][j] == 30) path.getImage().drawImage(new GreenfootImage("path_corner_inside2.png"),  j*cell,  i * cell);
                if (map[i][j] == 31) path.getImage().drawImage(new GreenfootImage("path_corner_inside3.png"),  j*cell,  i * cell);
                
                if (map[i][j] == 32) addObject(new Teleporter(), cell/2 + j*cell, cell/2 + i * cell);
                
                if (map[i][j] == 33) 
                {
                    addObject(new Flower(), cell/2 + j*cell, cell/2 + i * cell);
                }
                
                if (map[i][j] == 34)
                {
                    addObject(new tree_trunk(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new tree_top(), cell/2 + j*cell, -48 + cell/2 + i*cell);
                }
                
                if (map[i][j] == 36) path.getImage().drawImage(new GreenfootImage("fancy_dirt0.png"), j*cell, i*cell);
                if (map[i][j] == 37) path.getImage().drawImage(new GreenfootImage("fancy_dirt4.png"), j*cell, i*cell);
                if (map[i][j] == 38) {path.getImage().drawImage(new GreenfootImage("fancy_dirt6.png"), j*cell, i*cell); path.getImage().drawImage(new GreenfootImage("fancy_dirt1.png"), j*cell, i*cell);}
                if (map[i][j] == 39) path.getImage().drawImage(new GreenfootImage("fancy_dirt3.png"), j*cell, i*cell);
                if (map[i][j] == 40) {path.getImage().drawImage(new GreenfootImage("fancy_dirt5.png"), j*cell, i*cell); path.getImage().drawImage(new GreenfootImage("fancy_dirt2.png"), j*cell, i*cell);}
                if (map[i][j] == 43) path.getImage().drawImage(new GreenfootImage("fancy_dirtc0.png"), j*cell, i*cell);
                if (map[i][j] == 44) path.getImage().drawImage(new GreenfootImage("fancy_dirtc1.png"), j*cell, i*cell);
                if (map[i][j] == 45) path.getImage().drawImage(new GreenfootImage("fancy_dirtc3.png"), j*cell, i*cell);
                
                if (map[i][j] == 41)
                {
                    addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new npc_oldman(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 42)
                {
                    addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new npc2_neighb(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 46)
                {
                    addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new npc2_salariman(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 47)
                {
                    addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new npc_factory(), cell/2 + j*cell, cell/2 + i*cell);
                }
                if (map[i][j] == 48)
                {
                    addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);
                    addObject(new npc3_jungle(), cell/2 + j*cell, cell/2 + i*cell);
                }
                
                
                if (map[i][j] == 50) {path.getImage().drawImage(new GreenfootImage("fence_hor1.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 51) {path.getImage().drawImage(new GreenfootImage("fence_hor0.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 52) {path.getImage().drawImage(new GreenfootImage("fence_corner2.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 53) {path.getImage().drawImage(new GreenfootImage("fence_corner3.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 54) {path.getImage().drawImage(new GreenfootImage("fence_corner1.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 55) {path.getImage().drawImage(new GreenfootImage("fence_corner0.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 56) {path.getImage().drawImage(new GreenfootImage("fence_vert0.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 57) {path.getImage().drawImage(new GreenfootImage("fence_vert1.png"), j*cell, i*cell); addObject(new npc0(), cell/2 + j*cell, cell/2 + i*cell);}
                
                
                if (map[i][j] == 60) {addObject(new liquid("lake_middle"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 61) {addObject(new liquid("lake_top"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 62) {addObject(new liquid("lake_bot"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 63) {addObject(new liquid("lake_corner0_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 64) {addObject(new liquid("lake_corner1_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 65) {addObject(new liquid("lake_corner2_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 66) {addObject(new liquid("lake_corner2_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 67) {addObject(new liquid("lake_side0_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 68) {addObject(new liquid("lake_side1_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 69) {addObject(new liquid("lake_icorner2_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 70) {addObject(new liquid("lake_icorner3_"), cell/2 + j*cell, cell/2 + i*cell);}
                
                if (map[i][j] == 90) {addObject(new liquid("lava_middle"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 91) {addObject(new liquid("lava_top"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 92) {addObject(new liquid("lava_bot"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 93) {addObject(new liquid("lava_corner0_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 94) {addObject(new liquid("lava_corner1_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 95) {addObject(new liquid("lava_corner3_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 96) {addObject(new liquid("lava_corner2_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 97) {addObject(new liquid("lava_side0_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 98) {addObject(new liquid("lava_side1_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 99) {addObject(new liquid("lava_icorner0_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 89) {addObject(new liquid("lava_icorner1_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 88) {addObject(new liquid("lava_icorner3_"), cell/2 + j*cell, cell/2 + i*cell);}
                if (map[i][j] == 87) {addObject(new liquid("lava_icorner2_"), cell/2 + j*cell, cell/2 + i*cell);}
            }
        } 

        if (main)
        {
            black bl = new black();
            bl.reverse();
            addObject(bl, 640, 384);
            
            text_box box = new text_box();
            box.getImage().clear();
            set_txt(box);
            addObject(box, 640, 384);
            addObject(path, 640, 384);
            addObject(ground, 640, 384);
            //addObject(sfx, -64, -64);
        }
    }

    public Template()
    {    
        super(1280, 768, 1, false);

        setPaintOrder(black.class,
            filter_red.class,
            highlight.class,
            text_box.class,
            text_text.class,
            choice_engine.class,
            hp_bar.class,
            effect.class,
            ROkemon.class,
            Battle.class,
            Interact_bula.class,
            Pres_nou.class,
            rooftop.class,
            tree_top.class,
            rock2_right.class,
            rock2_left.class,
            Grass.class, 
            Player.class,
            NPC.class,
            Flower.class,
            Collision.class,
            Grass_fundal.class,
            Grass_fake.class,
            Path.class);
    }
}
