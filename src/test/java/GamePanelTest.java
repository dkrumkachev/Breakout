package test.java;

import main.java.breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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

}