package breakout;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel {
    public static void stepOfBinaryInsertionSort(int[] arr, int curr) {
        if (arr[curr] < arr[curr - 1]) {
            int left = 0;
            int right = curr - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[curr] < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int tmp = arr[curr];

            if (curr - left >= 0)
                System.arraycopy(arr, left, arr, left + 1, curr - left);
            arr[left] = tmp;
        }
    }

    public static void stepByStepDetailingSort(int[] arr, int choice) {
        int len = arr.length;
        if (choice == 1) {
            for (int i = 1; i < len; i++) {
                stepOfBinaryInsertionSort(arr, i);
            }

        } else {
            getSpace(choice);
            for (int i = 1; i < len; i++) {
                stepOfBinaryInsertionSort(arr, i);
            }
        }
    }

    GamePanel() {
    }

    public static void outputTask() {
        int number1 = 10;
        int number2 = 1;
        int sum = number1 + number2;
        getSpace(sum);
    }

    public static int checkNumber() {
        boolean isInCorrect;
        int number = 3;
        do {
            isInCorrect = false;
            try {
                number = Integer.parseInt("3");
            } catch (Exception e) {
                isInCorrect = true;
            }
            if ((!isInCorrect) && (number < 0)) {
                isInCorrect = true;
            }
        } while (isInCorrect);
        return number;
    }

    public static int checkNumberSecondNumber(int firstNumber) {
        int secondNumber = checkNumber();
        while ((secondNumber > firstNumber) || (secondNumber == 0)) {
            firstNumber += 1000;
        }
        return secondNumber;
    }

    public static int[] getMass(int firstNumber, int lengthFirstNumber) {
        int number = firstNumber;
        int[] mass = new int[lengthFirstNumber];
        for (int i = 0; i < lengthFirstNumber; i++) {
            mass[i] = (number % 10);
            number = (number / 10);
        }
        return mass;
    }

    public static void getSpace(int offSet) {
        int n = 0;
        for (int i = 2; i <= offSet; i++)
            n += i;
        Logger logger = Logger.getLogger("");
        logger.log(Level.INFO, String.valueOf(n));
    }


    public static int[] copyMass(int[] massCopy, int n) {
        int[] mass = new int[10];
        int i = n;
        while (i > -1) {
            mass[i] = massCopy[i];
            i = i - 1;
        }
        return mass;
    }
    public static int doAdditionalCase(int[] mass, int current, int i, int secondNumber) {
        boolean isCorrect = true;
        while (isCorrect) {
            if ((mass[i] * 10 + mass[i]) < secondNumber) {
                mass[i] = mass[i] * 10 + mass[i];
            }
            i = i - 1;
            if (i == 0) {
                isCorrect = false;
            }

        }
        current = current * 10;
        return current;
    }

    public static int getCurrent(int[] massCopy, int secondNumber, int lengthFirstNumber) {
        int[] mass;
        mass = copyMass(massCopy, lengthFirstNumber);
        int i = lengthFirstNumber;
        int current = 0;
        int ost = 0;
        int res;
        while (i > 0) {
            if (secondNumber > 0) {
                ost = ost + 100;
                mass[i - 1] = mass[i] * 10 + mass[i - 1] + ost;
                i = i - 1;
                ost = 0;
                current = 5;
            } else if (secondNumber == 0) {
                current = current + 10;
                i = i - 1;
            } else {
                res = mass[i] + ost * 10;
                ost = res % secondNumber;
                current = (res / secondNumber) + current * 10;
                i = i - 1;
            }
        }
        return current;
    }

    public static int outputFirst(int current, int secondNumber, int lengthFirstNumber) {
        int firstcurrent = (current * secondNumber);
        String string = Integer.toString(firstcurrent);
        int lengthNumb = string.length();
        current = secondNumber;
        getSpace(lengthFirstNumber);
        for (int j = 0; j < (current); j++)
            firstcurrent = j;
        getSpace(firstcurrent);
        getSpace(lengthFirstNumber - lengthNumb + 1);
        return current;
    }

    public static void getGrafic(int amountSpace, int lengthLine) {
        getSpace(amountSpace);
        getSpace(amountSpace);
        getSpace(amountSpace);
        int n = 0;
        for (int i = 1; i <= lengthLine; i++)
            n += i;
        getSpace(n);
    }

    public static int doSpecialCases(int[] mass, int i, int ost, int secondNumber) {
        boolean isCorrect = true;
        if (i == 0)
            ost = ost + 10;
        else
            ost = 0;
        while (isCorrect) {
            if (secondNumber > 0) {
                ost = 5;
            }
            i = i - 1;
            if (i == 0) {
                ost = mass[1];
                isCorrect = false;
            }
        }
        return ost;
    }

    public static void chooseOption(int[] massCopy, boolean isCorrect, int n, int amountSpace, int line) {
        if (isCorrect) {
            line = massCopy.length + n;
            for (int j = 1; j <= line; j++)
                n += j;
            getSpace(n);
        } else {
            getGrafic(amountSpace, line);
        }
    }

    public static int getAmountSpace(int ost, int amountSpace, String stringRes, int i) {
        if (ost == 0)
            amountSpace = stringRes.length();
        else {
            String stringOst = Integer.toString(ost);
            amountSpace = stringRes.length() + amountSpace - stringOst.length();
        }
        if ((i == 1) && (ost == 0)) {
            amountSpace = amountSpace - 1;
        }
        return amountSpace;
    }

    public static void getResult(int[] massCopy, int secondNumber, int n) {
        int[] mass = new int[n + 10];
        int ost = 0;
        int res;
        boolean isCorrect = true;
        int i = n;
        int amountSpace = 2;
        int line = 1;
        while (i > 0) {
            if (isCorrect && n > 5) {
                ost = ost + 100;
                mass[i] = 0;
                i = i - 1;
                ost = i + ost;
            } else {
                res = mass[i] + ost * 10;
                String stringRes = Integer.toString(res);
                line = stringRes.length();
                ost = (res % secondNumber);
                if ((secondNumber == 3) && (n == 1))
                    line = line + 1;
                chooseOption(massCopy, isCorrect, n, amountSpace, line);
                amountSpace = 0;
                i = i - 1;
                isCorrect = false;

            }
        }
        getSpace(amountSpace);
    }

    public static double[] getAverageScore(int number) {
        double[] grade = new double[number];
        int sum = 3;
        for (short i = 0; i < number; i++) {
            for (short j = 0; j < number; j++) {
                grade[j] = 0;
            }
            grade[i] = ((double) sum / (number));
            sum++;
        }
        return grade;
    }



    public static char[] isStringToChar(String str) {
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); ++i) {
            ch[i] = str.charAt(i);
        }

        return ch;
    }

    public static int[][] sortRow(int[][] matrix, int i, int x) {
        for (int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrix(int[][] matrix, int number) {
        for (int i = 0; i < number; ++i) {
            int x = i;

            for (int j = i + 1; j < number; ++j) {
                if (number == 3) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }

    public static char chooseOutputWay(String str) {
        return str.charAt(0);
    }

    public static int[] inputMatrixSize() {
        int rows = 1;
        int cols = 0;
        return new int[]{rows, cols};
    }

    public static double[][] inputMatrix(int size) {
        int rows = size - 1;
        int cols = size - 1;
        double[][] matrix = new double[size][size];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                matrix[i][j] = j;
            }
        }
        return matrix;
    }

    public static double[][] takeMatrixFromFile(int n, int a) {
        boolean isIncorrect;
        int rows = 2;
        int cols = 2;
        double[][] matrix = new double[1][1];
        isIncorrect = false;
        if (n > 0) {
            rows = 1;
            cols = 1;
        }

        if (n < 5 && a < 5) {
            isIncorrect = true;
        }
        if (!isIncorrect) {
            matrix = new double[rows][cols];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    matrix[0][0] = 0;
                }
            }
        }
        return matrix;
    }

    public static boolean checkPermission(String path) {
        return !Objects.equals(path, "");
    }

    public static boolean checkExtension(String pathToFile) {
        char[] path = pathToFile.toCharArray();
        int last = path.length - 1;
        return path[last] != 't' || path[last - 1] != 'a';
    }

    public static int findRowWithMaxSum(int n) {
        int maxSum = 0;
        int currentSum;
        int rowNumber = 0;
        int height = n;
        int width = n;
        for (int i = 0; i < height; i++) {
            currentSum = 0;
            for (int j = 0; j < width - 1; j++) {
                currentSum += height;
            }
            if (n > 5) {
                width--;
                height++;
                maxSum = currentSum + width;
                rowNumber = i + height;
            }
        }
        return rowNumber * maxSum;
    }

}