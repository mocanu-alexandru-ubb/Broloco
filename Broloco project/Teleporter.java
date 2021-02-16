import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teleporter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teleporter extends Trigger
{
    /**
     * Act - do whatever the Teleporter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player pl = null;
    boolean collided = false;

    public void act() 
    {
        if (!collided)
        {
            Template aux = (Template)getWorld();
            if (pl == null)
            {
                pl = aux.get_player();
                if (pl == null) return;
            }

            if (Math.abs(pl.getX() - getX()) < 32 && Math.abs(pl.getY() - getY()) < 32)
            {
                pl.set_state("exiting the world");
                System.out.println("Collided at:" + getX() + ", " + getY());
                if (getWorld().getClass() == Map_1.class || getWorld().getClass() == My_world.class)
                {
                    System.out.println("Is map_1");
                    Map_2 map = new Map_2(aux.get_sfx());
                    map.set_coord(96, 416, aux.get_player());

                    black bl = new black();
                    bl.set_action(1);
                    bl.set_map(map);
                    getWorld().addObject(bl, 640, 384);
                }
                else if (getWorld().getClass() == Map_4.class)
                {
                    aux.get_sfx().play_bgm(0);
                    Map_2 map = new Map_2(aux.get_sfx());
                    map.set_coord(1184, 416, aux.get_player());

                    black bl = new black();
                    bl.set_action(1);
                    bl.set_map(map);
                    getWorld().addObject(bl, 640, 384);
                }
                else if (getWorld().getClass() == Map_3.class)
                {
                    aux.get_sfx().play_bgm(0);
                    Map_2 map = new Map_2(aux.get_sfx());
                    map.set_coord(608, 96, aux.get_player());

                    black bl = new black();
                    bl.set_action(1);
                    bl.set_map(map);
                    getWorld().addObject(bl, 640, 384);
                }
                else if (getWorld().getClass() == Map_2.class)
                {
                    System.out.println("Is map_2");
                    if (getY() == 352 && getX() == 1248)
                    {
                        aux.get_sfx().play_bgm(2);
                        System.out.println("Is left border");
                        Map_4 map = new Map_4(aux.get_sfx());
                        map.set_coord(96, getY(), aux.get_player());

                        black bl = new black();
                        bl.set_action(1);
                        bl.set_map(map);
                        getWorld().addObject(bl, 640, 384);
                    }
                    if (getY() == 416 && getX() == 32)
                    {
                        System.out.println("Is right border");
                        Map_1 map = new Map_1(aux.get_sfx());
                        map.set_coord(1184, getY(), aux.get_player());

                        black bl = new black();
                        bl.set_action(1);
                        bl.set_map(map);
                        getWorld().addObject(bl, 640, 384);
                    }
                    if(getY() == 32 && getX() == 608)
                    {
                        aux.get_sfx().play_bgm(4);
                        System.out.println("Is top border");
                        Map_3 map = new Map_3(aux.get_sfx());
                        map.set_coord(608, 672  , aux.get_player());

                        black bl = new black();
                        bl.set_action(1);
                        bl.set_map(map);
                        getWorld().addObject(bl, 640, 384);
                    }
                }
                collided = true;
            }
        }
    }    
}
