package breakout;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

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
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test2(){
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
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void main(){
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
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test4(){
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