import breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GamePanelTest {
    @Test
    @DisplayName("Order Matrix for 3 rows 3 cols with negative numbers")
    void sortMatrix3x3NegativeNumb(){
        final int[][] actualResult1 = GamePanel.orderMatrix(new int[][]{{0, 2, 3}, {-1, 2, 3}, {-9, 2, 3}}, 3);
        final int[][] actualResult2 = GamePanel.orderMatrix(new int[][]{{0, 2, 3}, {-1, 2, 3}, {-9, 2, 3}}, 2);
        final int[][] actualResult3 = GamePanel.orderMatrix(new int[][]{{0, 2, 3}, {-1, 2, 3}, {-9, 2, 3}}, 1);
        final int[][] actualResult4 = GamePanel.orderMatrix(new int[][]{{0, 2, 3}, {-1, 2, 3}, {-9, 2, 3}}, 0);
        final int[][] expectedResult1 = actualResult1;
        final int[][] expectedResult2 = actualResult2;
        final int[][] expectedResult3 = actualResult3;
        final int[][] expectedResult4 = actualResult4;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    @DisplayName("sortRowTest")
    void sortRowTest(){
        final int[][] actualResult1 = GamePanel.sortRow(new int[][] {}, 0, 0);
        final int[][] actualResult2 = GamePanel.sortRow(new int[][] {{1}}, 0, 0);
        final int[][] expectedResult1 = actualResult1;
        final int[][] expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
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
        final int actualResult1 = GamePanel.outputFirst(7, -1, 0);
        final int actualResult2 = GamePanel.outputFirst(7, 3, 0);
        final int expectedResult1 = actualResult1;
        final int expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("getGraficTest")
    void getGraficTest() {
        GamePanel.getGrafic(1, 0);
        GamePanel.getGrafic(1, 2);
        final boolean actualResult = true;
        final boolean expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
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
        GamePanel.chooseOption(new int[]{1, 2, 3}, false, 2,4,5);
        GamePanel.chooseOption(new int[]{1, 2, 3}, true, 2,4,0);
        GamePanel.chooseOption(new int[]{1, 2, 3}, true, 2,4,5);
        final boolean actualResult = true;
        final boolean expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
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
        final boolean actualResult = true;
        final boolean expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getAverageScoreTest")
    void getAverageScoreTest() {
        final double[] actualResult1 = GamePanel.getAverageScore(0);
        final double[] actualResult2 = GamePanel.getAverageScore(3);
        final double[] expectedResult1 = actualResult1;
        final double[] expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("checkFirstElemTest")
    void checkFirstElemTest() {
        final boolean actualResult1 = GamePanel.checkFirstElem(new char[]{'0'});
        final boolean actualResult2 = GamePanel.checkFirstElem(new char[]{'_'});
        final boolean actualResult3 = GamePanel.checkFirstElem(new char[]{'B'});
        final boolean expectedResult1 = actualResult1;
        final boolean expectedResult2 = actualResult2;
        final boolean expectedResult3 = actualResult3;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
    }

    @Test
    @DisplayName("checkRestElemTest")
    void checkRestElemTest() {
        final boolean actualResult1 = GamePanel.checkRestElem(new char[]{'.'}, true, 1);
        final boolean actualResult2 = GamePanel.checkRestElem(new char[]{'0'}, false, 1);
        final boolean actualResult3 = GamePanel.checkRestElem(new char[]{'0'}, true, 0);
        final boolean actualResult4 = GamePanel.checkRestElem(new char[]{'0'}, false, 0);
        final boolean actualResult5 = GamePanel.checkRestElem(new char[]{'B'}, true, 1);
        final boolean actualResult6 = GamePanel.checkRestElem(new char[]{'_'}, true, 1);
        final boolean actualResult7 = GamePanel.checkRestElem(new char[]{'1'}, true, 1);
        final boolean expectedResult1 = actualResult1;
        final boolean expectedResult2 = actualResult2;
        final boolean expectedResult3 = actualResult3;
        final boolean expectedResult4 = actualResult4;
        final boolean expectedResult5 = actualResult5;
        final boolean expectedResult6 = actualResult6;
        final boolean expectedResult7 = actualResult7;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
        assertEquals(expectedResult5, actualResult5);
        assertEquals(expectedResult6, actualResult6);
        assertEquals(expectedResult7, actualResult7);
    }

    @Test
    @DisplayName("isStringToCharTest")
    void isStringToCharTest() {
        final char[] actualResult1 = GamePanel.isStringToChar("123");
        final char[] actualResult2 = GamePanel.isStringToChar("");
        final char[] expectedResult1 = actualResult1;
        final char[] expectedResult2 = actualResult2;
        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    @DisplayName("stepOfBinaryInsertionSortTest")
    void stepOfBinaryInsertionSortTest() {
        GamePanel.stepOfBinaryInsertionSort(new int[]{1, 2, 3}, 1);
        GamePanel.stepOfBinaryInsertionSort(new int[]{3, 2, 1}, 1);
        final boolean actualResult = true;
        final boolean expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("stepByStepDetailingSortTest")
    void stepByStepDetailingSortTest() {
        GamePanel.stepByStepDetailingSort(new int[]{1, 2, 3}, 1);
        GamePanel.stepByStepDetailingSort(new int[]{1, 2, 3}, 0);
        GamePanel.stepByStepDetailingSort(new int[]{}, 1);
        GamePanel.stepByStepDetailingSort(new int[]{}, 0);
        final boolean actualResult = true;
        final boolean expectedResult = actualResult;
        assertEquals(expectedResult, actualResult);
    }

}