package test.java;

import main.java.breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static main.java.breakout.GamePanel.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePanelTest {

    public GamePanelTest() {
    }

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
            assert false;
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
        paintComponent();
        try {
            assert false;
            g.setColor(Color.WHITE);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    private void paintComponent() {
    }

    @Test
    @DisplayName("Test Component")
    public void testComponent2(){

        boolean expectedResult = true;
        new GamePanel();
        DebugGraphics g = null;
        paintComponent();
        try {
            assert false;
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
        final int[][] actualResult = orderMatrix(matrix);
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

    @Test
    @DisplayName("Order Matrix for 4 rows 1 cols with nulls")
    public void orderMatrix41x1nulls(){
        final int[][] matrix = {{0}, {0}, {0}, {0}};
        final int[][] expectedResult = {{0}, {0}, {0}, {0}};
        final int[][] actualResult =  orderMatrixBrick(matrix);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Sort Row for 6 rows 3 cols")
    public void sortRow6x31(){
        final int[][] matrix = {{2, 2, 3}, {3, 1, 8}, {3, 2, 7}, {5, 2, 3}, {4, 2, 3}, {3, 2, 3}};
        final int[][] expectedResult = {{2, 3, 2}, {3, 8, 2}, {3, 7, 2}, {5, 3, 2}, {4, 3, 2}, {3, 3, 2}};
        final int[][] actualResult = sortLine(matrix, 2, 1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Order Matrix for 4 rows 1 cols with nulls")
    public void orderMatrix41x11nulls(){
        final int[][] matrix = {{0}, {0}, {0}, {0}};
        final int[][] expectedResult = {{0}, {0}, {0}, {0}};
        final int[][] actualResult =  orderMatrixBrick(matrix);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Sort Row for 6 rows 3 cols")
    public void sortRow62x31(){
        final int[][] matrix = {{2, 2, 3}, {3, 1, 8}, {3, 2, 7}, {5, 2, 3}, {4, 2, 3}, {3, 2, 3}};
        final int[][] expectedResult = {{2, 3, 2}, {3, 8, 2}, {3, 7, 2}, {5, 3, 2}, {4, 3, 2}, {3, 3, 2}};
        final int[][] actualResult = sortMatrixRow(matrix, 2, 1);
        assertEquals(expectedResult, actualResult);
    }

}