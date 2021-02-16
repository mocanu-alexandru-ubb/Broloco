import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class battle_background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle extends Overlord
{
    /**
     * Act - do whatever the battle_background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    boolean caught = false;
    text_text catch_anim = null;
    int counter = 1;

    ROkemon player = new ROkemon();
    int hp_player = 16 * 25;
    int pills_player = 16;
    int rage_player = 0;
    int magic_stacks_player = 0;
    int ultimate_stacks_pl = 3;
    int max_rage_pl = 5;
    int prc_pl = 100;

    ROkemon enemy = new ROkemon();
    int hp_enemy = 16 * 25;
    int pills_enemy = 16;
    int rage_enemy = 0;
    int magic_stacks_enemy = 0;
    int ultimate_stacks_en = 3;
    int max_rage_en = 5;
    int prc_en = 75;

    hp_bar bar_rage = new hp_bar();
    hp_bar bar_hp = new hp_bar();
    Random rand = new Random();

    void draw_hp ()
    {
        while(hp_player < pills_player * 25)
        {
            pills_player--;
            bar_hp.getImage().drawImage(new GreenfootImage("capsule_hp.png"), 390 - ((16 - pills_player) * 20), 60);
            System.out.println("Drew pill at x=" + (390 - ((16 - pills_player) * 20)));
        }

        while(hp_enemy < pills_enemy * 25)
        {
            pills_enemy--;
            bar_hp.getImage().drawImage(new GreenfootImage("capsule_hp.png"), 1220 - ((16 - pills_enemy) * 20), 439);
        }
    }

    public void end_battle()
    {
        getWorld().removeObject(player);
        getWorld().removeObject(enemy);
        getWorld().removeObject(bar_hp);
        getWorld().removeObject(bar_rage);
        getWorld().removeObject(catch_anim);

        getImage().clear();
    }

    void enemy_magic (int id)
    {
        effect ef = new effect();
        if (id == 0) ef.set_anim("vine_whip_enemy");
        if (id == 1) ef.set_anim("fireball_enemy");
        if (id == 2) ef.set_anim("cannon_enemy");
        getWorld().addObject(ef, 550, 384);

        max_rage_en--;
        if (rage_enemy == max_rage_en + 1)
        {
            rage_enemy--;
            bar_rage.getImage().drawImage(new GreenfootImage("ui_hb0_" + rage_enemy + ".png"), 0, 0);
        }
        int i = 0;
        while (i < 5 - max_rage_en)
        {
            bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 650 + i * 40, 439);
            i++;
        }

        hp_player -= 51;
        hp_enemy -= (int)(0.1f * hp_enemy) + 10;
    }

    void enemy_ultimate (int id)
    {
        ultimate_stacks_en--;
        effect ef = new effect();
        ef.set_anim("typhoon_enemy");
        if (id == 1) ef.set_anim("meteor_enemy");
        if (id == 2) ef.set_anim("tsunami_enemy");
        getWorld().addObject(ef, 550, 384);

        rage_enemy -= 3;
        bar_rage.getImage().drawImage(new GreenfootImage("ui_hb0_" + rage_enemy + ".png"), 0, 0);

        int i = 0;
        while (i < 5 - max_rage_en)
        {
            bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 650 + i * 40, 439);
            i++;
        }

        int crit = rand.nextInt(100);

        if (crit < 25) hp_player -= 25;
        crit = rand.nextInt(11);
        hp_player -= (int)((50 + crit) * prc_en / 100);
    }

    void enemy_basic ()
    {
        effect ef = new effect();
        ef.set_anim("scratch_enemy");
        getWorld().addObject(ef, 550, 384);
        if (rage_enemy < max_rage_en)
        {
            rage_enemy++;
            bar_rage.getImage().drawImage(new GreenfootImage("ui_hb0_" + rage_enemy + ".png"), 0, 0);
            int i = 0;
            while (i < 5 - max_rage_en)
            {
                bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 650 + i * 40, 439);
                i++;
            }
        }
        hp_player -= (int)((10 + rand.nextInt(5)) * prc_en / 100);
    }

    void basic_atack ()
    {
        effect ef = new effect();
        ef.set_anim("scratch");
        getWorld().addObject(ef, 640, 384);
        if (rage_player < max_rage_pl)
        {
            rage_player++;
            bar_rage.getImage().drawImage(new GreenfootImage("ui_hb1_" + rage_player + ".png"), 0, 0);
            int i = 0;
            while (i < 5 - max_rage_pl)
            {
                bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 600 - i * 40, 60);
                i++;
            }
        }
        hp_enemy -= (int)((10 + rand.nextInt(5)) * prc_pl / 100);
    }

    void magic_atack (int id)
    {
        effect ef = new effect();
        if (id == 0) ef.set_anim("vine_whip");
        if (id == 1) ef.set_anim("fireball");
        if (id == 2) ef.set_anim("cannon");
        getWorld().addObject(ef, 640, 384);

        max_rage_pl--;
        if (rage_player == max_rage_pl + 1 && max_rage_pl != 0)
        {
            rage_player--;
            bar_rage.getImage().drawImage(new GreenfootImage("ui_hb1_" + rage_player + ".png"), 0, 0);
        }
        int i = 0;
        while (i < 5 - max_rage_pl)
        {
            bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 600 - i * 40, 60);
            i++;
        }

        hp_enemy -= 51;
        hp_player -= (int)(0.1f * hp_player) + 10;
    }

    void ultimate_atack (int id)
    {
        effect ef = new effect();
        if (id == 0) ef.set_anim("typhoon");
        if (id == 1) ef.set_anim("meteor");
        if (id == 2) ef.set_anim("tsunami");
        getWorld().addObject(ef, 640, 384);

        rage_player -= 3;
        bar_rage.getImage().drawImage(new GreenfootImage("ui_hb1_" + rage_player + ".png"), 0, 0);

        int i = 0;
        while (i < 5 - max_rage_pl)
        {
            bar_rage.getImage().drawImage(new GreenfootImage("rage_null.png"), 600 - i * 40, 60);
            i++;
        }
        int crit = rand.nextInt(100);

        if (crit < 25) hp_enemy -= 25;
        crit = rand.nextInt(11);
        hp_enemy -= ((int)(50 * prc_pl / 100) + crit);
    }

    public void set_match (int id_a, int id_b)
    {
        bar_rage.getImage().drawImage(new GreenfootImage("ui_hb0_0.png"), 0, 0);
        bar_rage.getImage().drawImage(new GreenfootImage("ui_hb1_0.png"), 0, 0);
        player = new ROkemon();
        enemy = new ROkemon();
        getWorld().addObject(player, 640, 384);
        getWorld().addObject(enemy, 640, 384);
        getWorld().addObject(bar_rage, 640, 384);
        getWorld().addObject(bar_hp, 640, 384);
        player.set_poke(id_a, false);
        enemy.set_poke(id_b, true);
        if (id_a == 0 && id_b == 1) prc_pl = 75;
        else if (id_a == 0 && id_b == 2) {prc_en = 75; prc_pl = 125;}
        else if (id_a == 1 && id_b == 2) {prc_pl = 75; prc_en = 125;}
        else if (id_a == 1 && id_b == 0) {prc_en = 75; prc_pl = 125;}
        else if (id_a == 2 && id_b == 0) {prc_pl = 75; prc_en = 125;}
        else if (id_a == 2 && id_b == 1) {prc_en = 75; prc_pl = 125;}
    }

    public boolean player_launch_atack (int type)
    {
        if (type == 4)
        {
            caught = true;
            System.out.println("Caught");
            Template wrld = (Template) getWorld();
            wrld.get_player().cach(enemy.get_id());
        }
        if (type == 2) basic_atack();
        else if (type == 3) ultimate_atack(player.get_id());
        else if (type == 1) magic_atack(player.get_id());
        draw_hp();

        if (hp_enemy <= 0) return true;
        else return false;
    }

    public int enemy_ai ()
    {
        if (rage_enemy == 0) enemy_basic();
        else
        {
            if (rage_enemy == 3)
            {
                enemy_ultimate(enemy.get_id());
                draw_hp();

                if (hp_player <= 0) return 4;
                return 3;
            }
            else if (max_rage_en != 0 && hp_enemy <= 200 && (max_rage_en > 3 || ultimate_stacks_en == 0))
            {
                enemy_magic(enemy.get_id());
                draw_hp();

                if (hp_player <= 0) return 4;
                return 1;
            }
            else enemy_basic();

            draw_hp();

            if (hp_player <= 0) return 4;
            return 2;
        }
        draw_hp();
        if (hp_player <= 0) return 4;
        return 2;
    }

    public int player_atack (int type)
    {
        if (type == 3 && rage_player < 3) return 3;
        if (type == 1 && max_rage_pl == 0) return 2;
        if (type == 3 && ultimate_stacks_pl == 0) return 4;
        if (type == 1 && hp_player <= 50) return 5;
        if (type == 4 && hp_enemy > 50) return 6;
        if (type == 4 && rand.nextInt(100) > 50) return 7;
        return 1;
    } 

    public void act ()
    {
        if (catch_anim == null) {
            catch_anim = new text_text();
            catch_anim.setImage("text_box_empty.png");
            getWorld().addObject(catch_anim, 640, 364);
        }

        if (caught)
        {
            if (counter == 79) getWorld().removeObject(enemy);
            if (counter % 5 == 0) catch_anim.setImage("catch_" + counter / 5 + ".png");
            if (counter < 139) counter++;
        }
    }
}
