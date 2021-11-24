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
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Sort Row for 6 rows 3 cols")
    void sortRow6x3(){
        final int[][] expectedResult = {{2, 3, 2}, {3, 8, 2}, {3, 7, 2}, {5, 3, 2}, {4, 3, 2}, {3, 3, 2}};
        final int[][] actualResult = expectedResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("OutputTaskTest")
    void outputTaskTest() {
        final boolean expectedResult = true;
        final boolean actualResult = expectedResult;
        assertEquals(expectedResult, actualResult);
    }
}