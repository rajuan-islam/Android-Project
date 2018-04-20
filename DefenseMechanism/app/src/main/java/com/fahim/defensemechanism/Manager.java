package com.fahim.defensemechanism;

import android.graphics.Color;

public class Manager {
    /*
    * WELCOME TO THE MANAGER!!!
    *
    * Every bit of information used in this app goes through here.
    * All the references, databases, constants are kept here.
    * */

    // containers
    public static Container legends[] = new Container[10];
    public static Container sub_legends[];
    public static Container moves[] = new Container[20];
    public static Container sub_moves[];

    // container counters
    public static int legendCount = 0;
    public static int moveCount = 0;

    // CONSTANTS
    // color
    public static int redMinimal  = Color.argb(255,183,73,68);
    public static int redDarkMinimal = Color.argb(255,115,65,60);
    public static int greyMinimal = Color.argb(255,45,45,45);
    public static int whiteMinimal= Color.argb(255,255,255,255);
    public static int textGreyMinimal = Color.argb(255,164,164,164);

    // global variables
    public static boolean onLegendPage = false;

    /*
    * THIS IS THE MASTER METHOD!
    * */
    public static void makeItHappen(){
        moveCount = legendCount = 0;
        onLegendPage = false;

        movesSetUp();
        legendsSetUp();
    }

    // setting up all the moves
    private static void movesSetUp(){
        // setting up all the moves

        // move 1
        moves[moveCount++] = new Container(
                false,
                R.string.move_1_name,
                0,
                R.drawable.move_1_big,
                R.drawable.move_1_small,
                R.string.move_1_desc
        );

        // move 2
        moves[moveCount++] = new Container(
                false,
                R.string.move_2_name,
                0,
                R.drawable.move_2_big,
                R.drawable.move_2_small,
                R.string.move_2_desc
        );

        // move 3
        moves[moveCount++] = new Container(
                false,
                R.string.move_3_name,
                0,
                R.drawable.move_3_big,
                R.drawable.move_3_small,
                R.string.move_3_desc
        );

        // move 4
        moves[moveCount++] = new Container(
                false,
                R.string.move_4_name,
                0,
                R.drawable.move_4_big,
                R.drawable.move_4_small,
                R.string.move_4_desc
        );

        // move 5
        moves[moveCount++] = new Container(
                false,
                R.string.move_5_name,
                0,
                R.drawable.move_5_big,
                R.drawable.move_5_small,
                R.string.move_5_desc
        );

        // move 6
        moves[moveCount++] = new Container(
                false,
                R.string.move_6_name,
                0,
                R.drawable.move_6_big,
                R.drawable.move_6_small,
                R.string.move_6_desc
        );

        // move 7
        moves[moveCount++] = new Container(
                false,
                R.string.move_7_name,
                0,
                R.drawable.move_7_big,
                R.drawable.move_7_small,
                R.string.move_7_desc
        );

        // move 8
        moves[moveCount++] = new Container(
                false,
                R.string.move_8_name,
                0,
                R.drawable.move_8_big,
                R.drawable.move_8_small,
                R.string.move_8_desc
        );

        // move 9
        moves[moveCount++] = new Container(
                false,
                R.string.move_9_name,
                0,
                R.drawable.move_9_big,
                R.drawable.move_9_small,
                R.string.move_9_desc
        );

        // move 10
        moves[moveCount++] = new Container(
                false,
                R.string.move_10_name,
                0,
                R.drawable.move_10_big,
                R.drawable.move_10_small,
                R.string.move_10_desc
        );

        sub_moves = new Container[moveCount];
        System.arraycopy(moves,0,sub_moves,0,moveCount);
    }

    // setting up all the legends
    private static void legendsSetUp(){
        // legend 1
        legends[legendCount++] = new Container(
                true,
                R.string.legend_1_name,
                R.string.legend_1_origin,
                R.drawable.legend_1_big,
                R.drawable.legend_1_small,
                R.string.legend_1_desc
        );

        // legend 2
        legends[legendCount++] = new Container(
                true,
                R.string.legend_2_name,
                R.string.legend_2_origin,
                R.drawable.legend_2_big,
                R.drawable.legend_2_small,
                R.string.legend_2_desc
        );

        // legend 3
        legends[legendCount++] = new Container(
                true,
                R.string.legend_3_name,
                R.string.legend_3_origin,
                R.drawable.legend_3_big,
                R.drawable.legend_3_small,
                R.string.legend_3_desc
        );

        // legend 4
        legends[legendCount++] = new Container(
                true,
                R.string.legend_4_name,
                R.string.legend_4_origin,
                R.drawable.legend_4_big,
                R.drawable.legend_4_small,
                R.string.legend_4_desc
        );

        // legend 5
        legends[legendCount++] = new Container(
                true,
                R.string.legend_5_name,
                R.string.legend_5_origin,
                R.drawable.legend_5_big,
                R.drawable.legend_5_small,
                R.string.legend_5_desc
        );

        sub_legends = new Container[legendCount];
        System.arraycopy(legends,0,sub_legends,0,legendCount);
    }
}
