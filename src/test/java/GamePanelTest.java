import breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static breakout.GamePanel.sortRow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePanelTest {
    @Test
    @DisplayName("Order Matrix for 3 rows 3 cols with negative numbers")
    void sortMatrix3x3NegativeNumb(){
        final int[][] expectedResult = {{0, 2, 3}, {-1, 2, 3}, {-9, 2, 3}};
        final int[][] actualResult = expectedResult;
        GamePanel.orderMatrix(expectedResult, 1, "");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Sort Row for 6 rows 3 cols")
    void sortRow6x3(){
        final int[][] expectedResult = {{2, 3, 2}, {3, 8, 2}, {3, 7, 2}, {5, 3, 2}, {4, 3, 2}, {3, 3, 2}};
        final int[][] actualResult = expectedResult;
        GamePanel.sortRow(expectedResult, 1, 1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("OutputTaskTest")
    void outputTaskTest() {
        GamePanel.outputTask();
        final boolean expectedResult = true;
        final boolean actualResult = expectedResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("checkNumberTest")
    void checkNumberTest() {
        GamePanel.checkNumber();
        final boolean expectedResult = true;
        final boolean actualResult = expectedResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("checkNumberSecondNumberTest")
    void checkNumberSecondNumberTest() {
        final int expectedResult1 = GamePanel.checkNumberSecondNumber(10);
        final int actualResult1 = 3;
        assertEquals(expectedResult1, actualResult1);
        final int expectedResult2 = GamePanel.checkNumberSecondNumber(0);
        final int actualResult2 = 3;
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("getMassTest")
    void getMassTest() {
        final int[] actualResult = GamePanel.getMass(1,5);
        final int[] expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getSpaceTest")
    void getSpaceTest() {
        GamePanel.getSpace(0);
        final boolean actualResult = true;
        final boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }
}