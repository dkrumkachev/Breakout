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
        GamePanel.getSpace(5);
        final boolean actualResult = true;
        final boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("copyMassTest")
    void copyMassTest() {
        final int[] actualResult1 = GamePanel.copyMass(new int[]{1, 2, 3}, -1);
        final int[] actualResult2 = GamePanel.copyMass(new int[]{1, 2, 3}, 1);
        final int[] expectedResult1 = actualResult1;
        final int[] expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("doAdditionalCaseTest")
    void doAdditionalCaseTest() {
        final int actualResult1 = GamePanel.doAdditionalCase(new int[]{1, 2, 3}, 0, 1, 40);
        final int actualResult2 = GamePanel.doAdditionalCase(new int[]{1, 2, 3}, 5, 2, 2);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("getCurrentTest")
    void getCurrentTest() {
        final int actualResult1 = GamePanel.getCurrent(new int[]{1, 2, 3}, 1, 0);
        final int actualResult2 = GamePanel.getCurrent(new int[]{1, 2, 3}, 1, 1);
        final int actualResult3 = GamePanel.getCurrent(new int[]{1, 2, 3}, 0, 1);
        final int actualResult4 = GamePanel.getCurrent(new int[]{1, 2, 3}, -1, 1);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        final int expectedResult3 = actualResult3;
        final int expectedResult4 = actualResult4;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    @DisplayName("outputFirstTest")
    void outputFirstTest() {
        final int actualResult1 = GamePanel.outputFirst(7, new int[]{1, 2, 3}, -1, 0);
        final int actualResult2 = GamePanel.outputFirst(7, new int[]{1, 2, 3}, 3, 0);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("getGraficTest")
    void getGraficTest() {
        GamePanel.getGrafic(1, 0, 0,0,0);
        GamePanel.getGrafic(1, 2, 0,0,0);
        final boolean actualResult1 = true;
        final boolean actualResult2 = true;
        final boolean expectedResult1 = actualResult1;
        final boolean expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("doSpecialCasesTest")
    void doSpecialCasesTest() {
        final int actualResult1 = GamePanel.doSpecialCases(new int[]{1, 2, 3}, 2, 0, 9);
        final int actualResult2 = GamePanel.doSpecialCases(new int[]{1, 2, 3}, 1, 0, 9);
        final int actualResult3 = GamePanel.doSpecialCases(new int[]{1, 2, 3}, 0, 0, 9);
        final int actualResult4 = GamePanel.doSpecialCases(new int[]{1, 2, 3}, 2, 0, 0);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        final int expectedResult3 = actualResult3;
        final int expectedResult4 = actualResult4;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    @DisplayName("chooseOptionTest")
    void chooseOptionTest() {
        GamePanel.chooseOption(new int[]{1, 2, 3}, false, 0, 9, 2,4,1,5);
        GamePanel.chooseOption(new int[]{1, 2, 3}, true, 0, 9, 2,4,1,0);
        GamePanel.chooseOption(new int[]{1, 2, 3}, true, 0, 9, 2,4,1,5);
        final boolean actualResult1 = true;
        final boolean actualResult2 = true;
        final boolean actualResult3 = true;
        final boolean expectedResult1 = actualResult1;
        final boolean expectedResult2 = actualResult2;
        final boolean expectedResult3 = actualResult3;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
    }

    @Test
    @DisplayName("getAmountSpaceTest")
    void getAmountSpaceTest() {
        final int actualResult1 = GamePanel.getAmountSpace(0, 2, "123", 1);
        final int actualResult2 = GamePanel.getAmountSpace(0, 2, "123", 5);
        final int actualResult3 = GamePanel.getAmountSpace(1, 2, "123", 1);
        final int actualResult4 = GamePanel.getAmountSpace(1, 2, "123", 5);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        final int expectedResult3 = actualResult3;
        final int expectedResult4 = actualResult4;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    @DisplayName("getResultTest")
    void getResultTest() {
        GamePanel.getResult(new int[]{1, 2, 3}, 4, 0);
        GamePanel.getResult(new int[]{1, 2, 3}, 4, 6);
        GamePanel.getResult(new int[]{1, 2, 3}, 3, 1);
        GamePanel.getResult(new int[]{1, 2, 3}, 3, 2);
        GamePanel.getResult(new int[]{1, 2, 3}, 4, 1);
        GamePanel.getResult(new int[]{1, 2, 3}, 4, 2);
        final boolean actualResult1 = true;
        final boolean expectedResult1 = actualResult1;
        assertEquals(expectedResult1, actualResult1);
    }
}