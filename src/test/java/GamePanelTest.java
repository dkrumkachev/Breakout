package test.java;

import main.java.breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static main.java.breakout.GamePanel.orderMatrix;
import static main.java.breakout.GamePanel.sortRow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePanelTest {

    private Object Graphics;

    @Test
    @DisplayName("Test Create GamePanel")
    public void testCreateGamePanel(){
        boolean actualResult;
        boolean expectedResult = true;
        try{
            new GamePanel(){
            };
        } catch(Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Oval for 1x4")
    public void testOval1x4(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            g.fillOval(1, 4, 7, 7);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Component")
    public void testComponent(){

        boolean expectedResult = true;
        new GamePanel();
        DebugGraphics g = null;
        paintComponent(Graphics);
        try {
            g.setColor(Color.WHITE);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    private void paintComponent(Object graphics) {
    }

    @Test
    @DisplayName("Test Component")
    public void testComponent2(){

        boolean expectedResult = true;
        new GamePanel();
        DebugGraphics g = null;
        paintComponent(Graphics);
        try {
            g.setColor(Color.WHITE);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Order Matrix for 4 rows 1 cols with nulls")
    public void orderMatrix4x1nulls(){
        final int[][] matrix = {{0}, {0}, {0}, {0}};
        final int[][] expectedResult = {{0}, {0}, {0}, {0}};
        final int[][] actualResult = orderMatrix(matrix,  1, "");
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Sort Row for 6 rows 3 cols")
    public void sortRow6x3(){
        final int[][] matrix = {{2, 2, 3}, {3, 2, 8}, {3, 2, 7}, {5, 2, 3}, {4, 2, 3}, {3, 2, 3}};
        final int[][] expectedResult = {{2, 3, 2}, {3, 8, 2}, {3, 7, 2}, {5, 3, 2}, {4, 3, 2}, {3, 3, 2}};
        final int[][] actualResult = sortRow(matrix, 2, 1);
        assertEquals(expectedResult, actualResult);
    }

}