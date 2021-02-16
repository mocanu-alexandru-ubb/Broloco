import greenfoot.*;
import java.util.Random;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map_2 extends Template
{
    public Map_2(soundplayer nsfx)
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
        int[] first_layer1 = {1, 1, 1, 1, 1, 1, 1,33,21,22,20,33, 1, 1, 1, 4, 4, 4, 4, 4};
        int[] first_layer2 = {1,12, 1, 1, 1, 1, 9,33,21,22,20,33,12, 9, 1, 4, 4, 4,33, 4};
        int[] first_layer3 = {1, 1, 1, 1, 1, 1, 1, 1,21,22,20, 1, 1, 1, 4, 4, 4, 4, 4, 4};
        int[] first_layer4 = {1, 1, 1, 1, 1, 1, 1,33,21,22,20, 1, 4, 4, 4, 4, 4, 4, 4, 33};
        int[] first_layer5 ={33, 3, 1, 1, 1, 1, 1,33,21,22,20, 4, 4, 4, 4, 4, 4, 1, 1, 1};
        int[] first_layer6 ={18,18,18,18,18,18,18,18,24,22,20, 4, 4, 4, 4, 4, 4, 1, 1, 1};
        int[] first_layer7 ={23,23,23,23,23,23,23,23,23,22,20, 1, 4, 4, 4, 4, 4, 1, 1, 1};
        int[] first_layer8 ={19,19,19,19,19,19,19,19,27,22,20,12, 9, 1, 1, 1, 1, 9, 1, 1};
        int[] first_layer9 ={33,33, 1, 1, 1, 1, 1, 1,21,22,20, 1, 1, 1, 1, 1, 4, 4, 1, 4};
        int[] first_layer10={50,50,50,50,50,53, 1, 1,21,22,20, 1, 1, 1, 1,13,13,63,61,61};
        int[] first_layer11={38,38,38,38,44,57, 1,33,21,22,20,33,12, 1, 1, 1,63,69,60,60};
        int[] first_layer12={36,36,36,36,39,57, 1,33,21,22,20,33,33, 1, 1, 4,67,60,60,60};
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[][] map = {first_layer1, first_layer2, first_layer3, first_layer4, first_layer5, first_layer6, first_layer7, first_layer8, first_layer9, first_layer10, first_layer11, first_layer12};

        //            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0,32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row5 = {0, 0, 0, 0,34,34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,32};
        int[] row7 ={32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row8 = {0, 0, 0, 0,13,13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row10= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row11= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row12= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] map_layer2 = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12};

        //                  LAYER 2

        generate(map, true);
        generate(map_layer2, false);

    }
}
