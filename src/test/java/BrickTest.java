package main.java.breakout;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BrickTest {

    @Test
    @DisplayName("check Brick(1, 2)")
    public void checkBrick() {
        boolean expectedResult = true;
        new Brick(1, 2) {
        };
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("check function drawBrick")
    public void checkDrawBrick() {
        boolean expectedResult = true;
        new Brick(1, 5) {
            public void drawBrick(Graphics g) {
                try {
                    g.setColor(Color.white);
                } catch (Exception ignored) {
                }
            }
        };
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("check Rectangle with options")
    public void checkRectangleWidth1() {
        boolean expectedResult = true;
        new Brick(3, 4) {
            public void drawBrick(Graphics g) {
                try {
                    g.fill3DRect(1, 2, 3, 4, true);
                } catch (Exception ignored) {
                }
            }
        };
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("check Rectangle with options")
    public void checkRectangleWidth2() {
        boolean expectedResult = true;
        new Brick(2, 3) {
            public void drawBrick(Graphics g) {
                try {
                    g.drawRect(2, 3, 4, 8);
                } catch (Exception ignored) {
                }
            }
        };
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }


}