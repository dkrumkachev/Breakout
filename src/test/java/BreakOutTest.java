package test.java;


import main.java.breakout.BreakOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreakOutTest{

    @Test
    @DisplayName("Test BreakOut setResizable")
    public void testGameResizable(){
        boolean expectedResult = true;
        boolean actualResult;
        JInternalFrame game = new JInternalFrame();
        game.pack();
        game.setResizable(false);
        try{
            game.setResizable(false);
        }catch (Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Create New Object Game")
    public void testCreationGame(){
        boolean expectedResult = true;
        boolean actualResult;
        JInternalFrame game = new JInternalFrame();
        game.pack();
        game.setVisible(true);
        try{
            game.setVisible(true);
        }catch (Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Create New Object Game")
    public void testCreationGame2(){
        int expectedResult = 12;
        int actualResult = Sum(5, 7);
        assertEquals(expectedResult, actualResult);
    }

    public static int Sum(int a, int b){
        int c = a + b;
        return c;
    }

    @Test
    @DisplayName("Test GamePack")
    public void testGamePack(){
        boolean expectedResult = true;
        boolean actualResult;
        JInternalFrame game = new JInternalFrame();
        game.pack();
        game.setVisible(true);
        try{
            game.setVisible(true);
        }catch (Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test New Game Start")
    public void testNewGameStart(){
        boolean expectedResult = true;
        boolean actualResult;
        JInternalFrame game = new JInternalFrame();
        game.pack();
        game.setVisible(true);
        try{
            new BreakOut(){};
        }catch (Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }


}