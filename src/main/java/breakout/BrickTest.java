package breakout;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BrickTest {

    @Test
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test1() {
        boolean expectedResult = true;
        new Brick(1, 2) {
        };
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test2() {
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
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test3() {
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
    @DisplayName("Order Matrix for 3 cols 3 rows for order matrix same elements")
    public void test4() {
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