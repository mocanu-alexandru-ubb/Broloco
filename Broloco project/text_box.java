import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.*;
import java.util.Random;
import java.lang.Integer;

/**
 * Write a description of class text_box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class text_box extends Overlord
{
    boolean started = false;
    static int counter = 1;
    int line = 1;
    int dia_x = 240;
    int dia_y = 600;
    String[] dia = null;
    Actor highlight = null;
    Battle battle = new Battle();

    boolean x = false;
    boolean y = false;
    int counter_move = 1;
    String screen = "default";
    String targeting = "fight";
    boolean active = false;
    text_text desc = new text_text();
    int poke_id = 0;
    int ene_id = 0;
    boolean finished = false;

    String action_description = null;
    int frames_waited = 0;
    boolean needs_atacking = false;
    Template wrld = null;

    GreenfootSound high = new GreenfootSound("menu_change.wav");
    GreenfootSound leave = new GreenfootSound("menu_leave.wav");

    String[] abilities1 = {"Vine whip", "Talon", "Thypoon", "Chicken dinner"};
    String[] abilities2 = {"Fireball", "Claw", "Meteor", "Firefux"};
    String[] abilities3 = {"Cannon", "Bite", "Tsunami", "Dolphy"};
    String[][] poke_abili = {abilities1, abilities2, abilities3};

    void escape (boolean force)
    {
        Random rand = new Random();
        if (force || rand.nextInt(100) < 60)
        {
            active = false;
            finished = false;

            getWorld().removeObject(highlight);
            getWorld().removeObject(desc);

            battle.end_battle();

            Template world = (Template)getWorld();
            Player ple = world.get_player();
            ple.set_state("static");

            getImage().clear();

            world.get_sfx().play_bgm(world.get_bgm());
            leave.setVolume(75);
            leave.play();

            world.removeObject(battle);
            battle = null;
            System.out.println("Exited combat");
        }
        else
        {
            needs_atacking = true;

            action_description = "You failed to run away.";
            getImage().setFont(new Font("Courier New", true, false, 30));

            dia_x = 0;
            dia_y = 0;
        }
    }

    boolean wait_for_text (String s)
    {
        if (s == null) 
        {
            return true;
        }

        if (counter <= s.length() * 3)
        {
            type_write(s, 75, 600, 530);
            return false;
        }
        else 
        {
            if (pressed("enter")) 
            {
                System.out.println("wrote:" + action_description);
                counter = 1;
                action_description = null;

                dia_x = 0;
                dia_y = 0;
                if (needs_atacking)
                {
                    active = false;
                    needs_atacking = false;
                    if (screen == "fight") set_fight();
                    else set_default();

                    frames_waited = 50;
                    getImage().setFont(new Font("Courier New", true, false, 30));

                    int response = battle.enemy_ai() - 1;
                    if (response == 3) 
                    {
                        action_description = "Your hp reaches 0. You lose";
                        finished = true;
                        return false;
                    }
                    else action_description = poke_abili[ene_id][3] + " used " + poke_abili[ene_id][response];
                }
                else 
                {
                    set_default();
                    active = true;
                }
                return true;
            }
            return false;
        }
    }

    boolean wait_for_frames (int frames)
    {
        if (counter < frames) 
        {
            counter++;
            return false;
        }
        else
        {
            if (frames != 0) counter = 1;
            frames_waited = 0;
            return true;
        }
    }

    public void set_background ()
    {
        setImage(new GreenfootImage("ui_textbuttons.png"));
        Font font = new Font("Courier New", true, false, 40);
        getImage().setFont(font);
    }

    public void set_default()
    {
        //        BATTLE UI
        set_background();
        getImage().drawString("Fight", 750, 600);
        getImage().drawString("Catch", 1040, 600);
        getImage().drawString("Run", 760, 715);
        screen = "default";
    }

    public void align_text(String text, int x, int y)
    {
        getImage().drawString(text, x - text.length() * 12, y + 12);
    }

    public void set_fight()
    {
        set_background();
        screen = "fight";
        align_text(poke_abili[poke_id][0], 805, 589);
        align_text(poke_abili[poke_id][1], 1105, 589);
        align_text(poke_abili[poke_id][2], 805, 699);
        align_text("Return", 1105, 699);
    }

    public void activate(int id, int poke)
    {
        //        BATTLE UI
        high.setVolume(75);

        poke_id = poke;
        ene_id = id;

        active = true;
        finished = false;
        counter_move = 1;
        frames_waited = 0;
        counter = 1;

        highlight = new highlight();
        battle = new Battle();
        desc = new text_text();

        getWorld().addObject(highlight, 0, 0);

        battle.getImage().drawImage(new GreenfootImage("battle_pads.png"), 0, 0);
        getWorld().addObject(battle, 640, 384);
        battle.set_match(poke_id, id);

        desc.setImage(new GreenfootImage(1280, 768));
        getWorld().addObject(desc, 0, 0);
        set_default();

    }

    void try_action (int type)
    {
        int response = battle.player_atack(type);
        if (response == 1)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            if (type == 4)
            {
                battle.player_launch_atack(type);
                finished = true;
                active = false;
                action_description = "Congratulations! You managed  to capture the ROkemon!";
                dia_x = 0;
                dia_y = 0;
                frames_waited = 100;
            }
            else
            {
                frames_waited = 50;
                needs_atacking = true;
                if (battle.player_launch_atack(type)) 
                {
                    action_description = "The enemy's health reaches 0. You win.";
                    Template wrld = (Template)getWorld();
                    Player ple = wrld.get_player();
                    ple.defeat();
                    ple.set_enemy(-1);
                    finished = true;
                    needs_atacking = false;
                }
                else action_description = poke_abili[poke_id][3] + " used " + poke_abili[poke_id][type-1];

                dia_x = 0;
                dia_y = 0;
            }
        }
        else if (response == 2)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "You cannot sacrifice any more rage.";
            dia_x = 0;
            dia_y = 0;
        }
        else if (response == 3)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "You need more rage.";
            dia_x = 0;
            dia_y = 0;
        }
        else if (response == 4)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "You cannot use this ability anymore.";
            dia_x = 0;
            dia_y = 0;
        }
        else if (response == 5)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "You don't have enough health.";
            dia_x = 0;
            dia_y = 0;
        }
        else if (response == 6)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "Enemy ROkemon has too much    health.";
            dia_x = 0;
            dia_y = 0;
        }
        else if (response == 7)
        {
            getImage().setFont(new Font("Courier New", true, false, 30));
            action_description = "You failed to capture the enemy ROkemon";
            needs_atacking = true;
            dia_x = 0;
            dia_y = 0;
        }
    }

    public void move()
    {
        //        BATTLE UI

        if (pressed("down") || pressed("up"))
        {
            y = !y;
            high.play();
        }
        if (pressed("left") || pressed("right"))
        {
            x = !x;  
            high.play();
        }

        if (!x && !y)
        {
            highlight.setLocation(805, 589);
            if (pressed("enter"))
            {
                System.out.println("clicked 0");
                if (screen == "default" ) set_fight();
                else if (screen == "fight" ) 
                {
                    active = false;
                    try_action(1);
                }
            }
        }
        if (!x && y) 
        {
            highlight.setLocation(805, 699);
            if (pressed("enter"))
            {
                System.out.println("clicked 1");
                if (screen == "fight") 
                {
                    active = false;
                    try_action(3);
                }
                else if (screen == "default") escape(false);
            }
        }
        if (x && !y) 
        {
            highlight.setLocation(1105, 589);
            if (pressed("enter"))
            {
                System.out.println("clicked 2");
                if (screen == "fight") 
                {
                    active = false;
                    try_action(2);
                }
                else if (screen == "default")
                {
                    active = false;
                    try_action(4);
                }
            }
        }
        if (x && y) 
        {
            highlight.setLocation(1105, 699);
            if (screen == "fight" && pressed("enter"))
            {
                System.out.println("clicked 3");
                set_default();
            }
        }
    }

    public void set_dia (String[] new_dia)
    {
        dia = new_dia;
    }

    public void start_up ()
    {
        wrld = (Template)getWorld();
        wrld.get_player().talk(true);
        started = true;
        setImage("Text_box.png");
        Font font = new Font("Courier New", true, false, 30);
        getImage().setFont(font);
        dia_x = 0;
        dia_y = 0;
        counter = 1;
        getImage().drawString(dia[0], 300, 503);
    }

    public void end_dia()
    {
        wrld = (Template)getWorld();
        wrld.get_player().talk(false);
        counter = 1;
        started = false;
        getImage().clear();

        Template world = (Template)getWorld();
        if (line < dia.length && dia[line] == "end")
        {
            black bl = new black();
            bl.set_for_fight(Integer.parseInt(dia[line+1]), world.get_player().get_poke());
            bl.set_action(2);
            world.addObject(bl, 640, 384);
        }
        else
        {
            world.get_player().set_state("static");
        }

        line = 1;
        dia = null;
    }

    public void advance_line()
    {
        getImage().clear();
        start_up();
    }

    public void type_write (String s, int x, int y, int line_length)
    {
        if (counter % 3 == 0)
        {
            getImage().drawString(s.substring(counter/3-1, counter/3), x + dia_x, y + dia_y);
            dia_x += 18;
            if (dia_x > line_length)
            {
                dia_x = -30;
                dia_y += 50;
            }
        }
        counter++;
    }

    public void dialogue ()
    {
        if (line < dia.length && counter <= dia[line].length() * 3)
        {
            type_write(dia[line], 240, 600, 780);
        }
        else 
        {
            if (line < dia.length)
            {
                if (Greenfoot.isKeyDown("enter"))
                {
                    line++;
                    advance_line();
                    if (line < dia.length && dia[line] == "end") end_dia();
                }
            }
            else
            {
                if (Greenfoot.isKeyDown ("enter"))
                {
                    end_dia();
                }
            }
        }
    }

    public void act() 
    {
        if (dia != null)
        {
            if (!started) start_up();
            dialogue();
        }

        if (wait_for_frames(frames_waited))
        {
            if (wait_for_text(action_description))
            {
                if (finished) {
                    escape(true);

                    System.out.println("decision");
                }
                else if(active) 
                {
                    move();
                }
            }
        }

        refresh_keys();
    }    
}
