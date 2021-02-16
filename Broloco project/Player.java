import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class PlayerV2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Overlord
{
    choice_engine ch = null;
    Actor target = null;
    soundplayer sfx = null;

    String state = "transitioning";
    String facing = "down";
    int speedX = 0;
    int speedY = 0;
    int speed = 4;
    int anime_counter = 0;
    int poke = 0;
    Actor bubble = null;

    boolean changing = false;
    boolean first_run = true;
    boolean talking = false;
    boolean got_bread = false;
    
    boolean[] cached = {true, false, false};
    boolean[] defeated = {false, false, false, false, false, false};
    int enemy_id = -1;
    
    public void eligible_for_breda () 
    {
        System.out.println("da");
        for (int i=2; i < defeated.length; i++) if (!defeated[i]) return;
        defeated[1] = true;
        defeated[0] = true;
        return;
    }
    
    public void get_bread () {got_bread = true;}
    
    public boolean is_defeated (int id) {return defeated[id];}

    public void set_enemy (int idd) {enemy_id = idd;}
    
    public void defeat () {if (enemy_id != -1)defeated[enemy_id] = true;}

    public void talk (boolean b) {talking = b;}

    public void cach (int id) {cached[id] = true;}

    public int get_poke () {return poke;}
    
    public void set_state (String new_state)
    {
        state = new_state;
    }

    public int start_combat (int poke_id)
    {
        if (state == "static") 
        {
            state = "combat";
            black bl = new black();
            bl.set_action(2);
            bl.set_for_fight(poke_id, poke);
            getWorld().addObject(bl, 640, 384);
            return 41;
        }
        else
            return 39;
    }

    void meniu ()
    {
        if (state == "static" && pressed("escape") || changing)
        {
            if (ch == null)
            {
                //Cod pentru a accesa meniul de selectare a pokemonilor
                ch = new choice_engine();

                state = "talking";
                changing = true;
                String[] s = {"Chicken Dinner", "Firefux", "Dolphy"};

                getWorld().addObject(ch, 640, 384);
                ch.set_choices(3, s);
            }

            //Ia butonul selectat din meniu
            int aux_poke = ch.get_answer();
            if (aux_poke != -1)
            {
                if (cached[aux_poke])
                {
                    poke = aux_poke;
                    state = "static";
                }
                else
                {
                    String[] s = {"System", "You have not caught that pokemon yet."};
                    Template wrld = (Template)getWorld();
                    wrld.get_txt().set_dia(s);
                }
                //talking = false;
                changing = false;
                ch.delete();
                ch = null;
            }
        }
    }

    public void trigger_bubble ()
    {
        if (bubble == null)
        {
            bubble = new Interact_bula();
            getWorld().addObject(bubble, getX()+45, getY()-45);
        }
    }

    public void clean()
    {
        if (bubble != null)
        {
            getWorld().removeObject(bubble);
            bubble = null;
        }
    }

    public void interact ()
    {
        if (target != null)
        {
            trigger_bubble();
            if (pressed("e"))
            {
                if (target.getClass().getSuperclass() == NPC.class)
                {
                    if (target.getClass() == npc_factory.class)
                    {

                    }
                    state = "taking";
                    NPC npc = (NPC)target;
                    String[] s = null;
                    enemy_id = npc.get_id();
                    if (!defeated[npc.get_id()]) s = npc.get_dia();
                    else s = npc.get_dia_def();
                    Template world = (Template)getWorld();
                    text_box txt = world.get_txt();
                    txt.set_dia(s);
                }

            }
        }
    }

    public void animate ()
    {
        if (state == "moving")
        {
            //Anime_counter va lua valori de la 0 -> 40
            //Odata la 5 frame-uri (cand anime_counter % 5 == 0) v-om schimba frame-ul de animatie
            if (anime_counter % 5 == 0) setImage("player_" + facing + "_" + anime_counter / 5 + ".png");
            anime_counter = (anime_counter + 1) % 40;
        }
        else
        {
            setImage("player_" + facing + "_0.png");
        }
    }

    boolean check_collision (int x, int y)
    {
        //Verificam daca exista un obiect collision la destinatia noastra
        if (getOneObjectAtOffset(x, y, Collision.class) != null) return true;
        return false;
    }

    public void start_movement_event ()
    {
    }

    public void end_movement_event()
    {
        //Pentru ca ne-am oprit din mers vrem sa verificam daca putem interactiona cu ceva
        target = getOneObjectAtOffset(speedX * cell, speedY * cell, Interact.class);
    }

    public void move ()
    {
        if (state == "static")
        {
            //Verificam in ce directie mergem
            if (Greenfoot.isKeyDown("right"))
            {
                facing = "right";
                state = "moving";
                speedX = 1;
                speedY = 0;
            }
            else if (Greenfoot.isKeyDown("left"))
            {
                facing = "left";
                state = "moving";
                speedX = -1;
                speedY = 0;
            }
            else if (Greenfoot.isKeyDown("up"))
            {
                facing = "up";
                state = "moving";
                speedX = 0;
                speedY = -1;
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                facing = "down";
                state = "moving";
                speedX = 0;
                speedY = 1;
            }

            //Verificam daca putem merge in tile-ul dorit
            if (check_collision(cell * speedX, cell * speedY))
            {
                state = "static";
                end_movement_event();
            }
            else
            {
                start_movement_event();
            }
        }

        if (state == "moving")
        {
            setLocation(getX() + speedX * speed, getY() + speedY * speed);

            if (getX() % cell == 32 && getY() % cell == 32)
            {
                //Verificam daca jucatorul in continuare incearca sa mearga in aceeasi directie si daca acesta poate merge pe tile-ul dorit
                if (Greenfoot.isKeyDown(facing) && !check_collision(cell * speedX, cell * speedY))
                {
                    start_movement_event();
                }
                //In caz contrar ne oprim din mers
                else
                {
                    state = "static";
                    end_movement_event();
                }
            }
        }
    }

    public void act() 
    {
        if (first_run)
        {
            Template wrld = (Template)getWorld();
            sfx = wrld.get_sfx();
        }

        if (!talking) 
        {
            if (state == "moving" || state == "static") move();
            if (state == "moving" && !sfx.is_playing(3)) sfx.play_loop(3);
            else if (state != "moving" && sfx.is_playing(3)) sfx.pause(3);

            animate();
            if (state != "moving" && state != "battle") meniu();
        }

        // Daca putem interactiona, interactionam, in caz contrar ne asiguram ca bula interact a fost eliminata
        if (state == "static") interact();
        else clean();

        refresh_keys();
    }    
}
