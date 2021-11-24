package breakout;

public class GamePanel {
    final static int numberColumns = 3;
    final static int numberLines = 3;
    public static void main(String[] args) {

    }
    public static double[] getAverageScore(byte[][] matrix){
        double[] grade = new double[numberColumns];
        int sum = 0;
        for (short i = 0; i < numberColumns; i++)
        {
            for (short j = 0; j < numberLines; j++)
            {
                sum = sum + matrix[j][i];
            }
            grade[i] = 0;
            grade[i] = ((double) sum / (numberLines));
            sum = 0;
        }
        return grade;
    }

    static boolean checkFirstElem(char[] ch) {
        boolean isCorrect = ch[0] >= 'A' && ch[0] <= 'Z' || ch[0] == '_';
        return isCorrect;
    }

    static boolean checkRestElem(char[] ch, boolean isCorrect, int n) {
        for(int i = 1; isCorrect && i < n; ++i) {
            isCorrect = ch[i] >= 'A' && ch[i] <= 'Z' || ch[i] == '_' || ch[i] >= '0' && ch[i] <= '9';
        }

        return isCorrect;
    }

    static boolean checkElem(char[] ch, int n) {
        boolean isCorrect = checkFirstElem(ch);
        isCorrect = checkRestElem(ch, isCorrect, n);
        return isCorrect;
    }

    static char[] isStringToChar(String str) {
        char[] ch = new char[str.length()];

        for(int i = 0; i < str.length(); ++i) {
            ch[i] = str.charAt(i);
        }

        return ch;
    }

    public static int[][] sortRow(int[][] matrix, int i, int x) {
        for(int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrix(int[][] matrix, int number, String path) {
        for(int i = 0; i < matrix[0].length - 1; ++i) {
            int x = i;

            for(int j = i + 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] < matrix[0][x]) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
            //outputMatrix(matrix, number, path);
        }

        return matrix;
    }
}