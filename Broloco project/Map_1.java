import greenfoot.*;
import java.util.Random;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map_1 extends Template
{
    public Map_1(soundplayer nsfx)
    {    
        set_sfx(nsfx, 0);
        prepare();
    }

    public void started()
    {
        get_sfx().play_loop(0);
    }
    
    public void stopped()
    {
        get_sfx().close();
    }

    private void prepare()
    { 
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] first_layer1 = {0, 0, 0, 0, 0, 0, 0, 0, 0,34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] first_layer2 = {0, 0, 0, 0, 0, 0, 0, 0, 0,56, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] first_layer3 = {0, 0, 0, 0, 0, 0, 0, 0, 0,34, 0, 0, 0, 0, 0, 0, 0, 0, 0,12};
        int[] first_layer4 = {0, 0, 0, 0, 0, 0, 0, 0, 0,56, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] first_layer5 ={33, 0, 0, 0, 0, 0, 0, 0, 0,34, 0, 0, 0, 0, 0, 0, 0, 0,33,33};
        int[] first_layer6 ={18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18};
        int[] first_layer7 ={23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23};
        int[] first_layer8 ={19,19,19,19,19,19,19,19,27,22,26,19,19,19,19,19,19,19,19,19};
        int[] first_layer9 ={33,33, 0,33, 0,33, 0,12,21,22,20, 0, 0, 0, 0, 0, 0, 0,33,33};
        int[] first_layer10= {0, 0,12,33,34, 0, 0, 0,21,22,20, 0,13,13, 0,52,50,50,50,50};
        int[] first_layer11= {4, 4, 4, 0, 0, 0, 0,33,21,22,20,33, 0, 0, 0,56,43,38,38,38};
        int[] first_layer12= {4, 4, 4, 0, 0, 0, 0,33,21,22,20,33, 0, 0, 0,56,37,36,36,36};
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[][] map = {first_layer1, first_layer2, first_layer3, first_layer4, first_layer5, first_layer6, first_layer7, first_layer8, first_layer9, first_layer10, first_layer11, first_layer12};

        //            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row5 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row6 = {0, 0, 0, 0, 0,42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row7 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32};
        int[] row8 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,41, 0, 0};
        int[] row10= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row11= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row12= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] map_layer2 = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12};

        //                  LAYER 2
        
        Grass_fake house_bottom = new Grass_fake();
        house_bottom.setImage("house_bottom.png");
        addObject(house_bottom, 928, 200);
        addObject(new npc0(), 864, 352);
        addObject(new npc_mum(), 992, 288);
        addObject(new house(), 928, 160); 
        addObject(new rooftop(), 928, 160);
        
        house_bottom = new Grass_fake();
        house_bottom.setImage("house_bottom.png");
        addObject(house_bottom, 288, 200);
        addObject(new house(), 288, 160); 
        addObject(new rooftop(), 288, 160);
        
        generate(map, true);
        generate(map_layer2, false);

    }
}
