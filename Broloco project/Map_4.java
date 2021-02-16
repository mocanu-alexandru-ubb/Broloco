import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map_4 extends Template
{

    /**
     * Constructor for objects of class Map_4.
     * 
     */
    public Map_4(soundplayer nsfx)
    {
        set_sfx(nsfx, 2);
        prepare();
    }

    public void started()
    {
        get_sfx().play_loop(2);
    }
    
    public void stopped()
    {
        get_sfx().close();
    }

    private void prepare()
    { 
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] first_layer1 = {4, 4, 4, 4, 4, 4,33,33, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int[] first_layer2 = {4,33, 4, 4, 4, 4,33,33,33, 0, 0, 4,12, 4,33,33,33,33,33, 4};
        int[] first_layer3 = {4, 4, 4, 9,34, 4, 4, 4, 9, 0,33, 4, 4, 4, 0, 0,13,13,33, 4};
        int[] first_layer4 = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 9,33, 4};
        int[] first_layer5 = {0, 4, 4,33, 4, 4, 0, 4, 4, 4, 4,34, 4, 0, 0, 0, 0,34,33, 4};
        int[] first_layer6 ={32, 0, 0, 0, 0, 0, 0,33, 4, 4, 4, 4,33, 0, 0, 0,33,33,9, 4};
        int[] first_layer7 ={ 0, 0, 4, 4, 4, 4, 4, 4, 0, 4, 4, 0,12, 4, 4, 4, 4, 4, 4, 4};
        int[] first_layer8 = {4, 4,63,61,61,64, 4, 4, 0, 4, 0, 4, 4, 4,34, 4, 4, 4, 4, 4};
        int[] first_layer9 ={63,61,69,60,60,68, 4, 4, 4, 4, 4,34, 4,33, 4, 4, 4, 4, 4, 4};
        int[] first_layer10={69,60,60,60,60,68,34, 4, 4,34, 4, 4, 4, 4, 4, 4,34, 4, 4,33};
        int[] first_layer11={60,60,60,60,60,70,64, 4,33, 9, 4, 4, 4,34, 4,33, 4, 4,33,33};
        int[] first_layer12={60,60,60,60,60,60,70,64, 9, 4, 4, 4,33, 4, 4, 4, 4,33,33, 9};
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[][] map = {first_layer1, first_layer2, first_layer3, first_layer4, first_layer5, first_layer6, first_layer7, first_layer8, first_layer9, first_layer10, first_layer11, first_layer12};

        //            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row5 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,48, 0, 0, 0};
        int[] row6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row7 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row8 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row10= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row11= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row12= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] map_layer2 = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12};

        //                  LAYER 2

        generate(map, true);
        generate(map_layer2, false);

    }
}
