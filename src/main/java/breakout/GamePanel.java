package breakout;

import java.util.Scanner;

public class GamePanel {
    public static void outputTask() {
        System.out.println("Программа позволяет ввести два натуральных числа m и n (m>n)\n" +
                "казывает на экране правило деления «лесенкой» числа m на число n.");
        System.out.println("Введите число 1: ");
    }

    public static int checkNumber() {
        boolean isInCorrect;
        int number = 3;
        do {
            isInCorrect = false;
            try {
                number = Integer.parseInt("3");
            } catch (Exception e) {
                System.out.println("Проверьте корректность введенных данных!");
                isInCorrect = true;
            }
            if ((!isInCorrect) && (number < 0))
            {
                System.out.println("Проверьте корректность введенных данных!");
                System.out.println("Введите натуральное число.");
                isInCorrect = true;
            }
        } while (isInCorrect);
        return number;
    }

    public static int checkNumberSecondNumber(int firstNumber) {
        System.out.println("Введите второе число: ");
        int secondNumber = checkNumber();
        while ((secondNumber > firstNumber) || (secondNumber == 0))
        {
            System.out.println( "Проверьте корректность введенных данных!");
            System.out.println("Введите число 2 большее, чем 1 и неравное 0!");
            firstNumber = 1000;
        }
        return secondNumber;
    }

    public static int[] getMass(int firstNumber, int lengthFirstNumber) {
        int number = firstNumber;
        int[] mass = new int[lengthFirstNumber];
        for(int i = 0; i < lengthFirstNumber; i++)
        {
            mass[i] = (number % 10);
            number = (number / 10);
        }
        return mass;
    }

    public static void getSpace(int offSet) {
        for(int i = 2; i <= offSet; i++)
            System.out.print(" ");
    }

    public static int[] copyMass(int[] massCopy,int n) {
        int[] mass = new int[10];
        int i = n;
        while (i > -1)
        {
            mass[i] = massCopy[i];
            i = i - 1;
        }
        return mass;
    }

    public static int doAdditionalCase(int[] mass, int current, int i, int secondNumber) {
        boolean isCorrect = true;
        while (isCorrect)
        {
            if ((mass[i] * 10 + mass[i]) < secondNumber)
            {
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
        while(i > 0)
        {
            if (secondNumber > 0)
            {
                ost = ost + 100;
                mass[i - 1] = mass[i] * 10 + mass[i - 1] + ost;
                i = i - 1;
                ost = 0;
                current = 5;
            }
            else if (secondNumber == 0)
            {
                current = current + 10;
                i = i - 1;
            }
            else
            {
                res = mass[i] + ost * 10;
                ost = res % secondNumber;
                current = (res / secondNumber) + current * 10;
                i = i - 1;
            }
        }
        return current;
    }

    public static int outputFirst(int current, int[] a, int secondNumber, int lengthFirstNumber) {
        int firstcurrent = (current * secondNumber);
        String string = Integer.toString(firstcurrent);
        int lengthNumb = string.length();
        System.out.print(a.length) ;
        current = secondNumber;
        getSpace(lengthFirstNumber);
        System.out.print(" |");
        for(int j = 0; j < (current); j++)
            System.out.print("-");
        System.out.println();
        System.out.print(" " + firstcurrent);
        getSpace(lengthFirstNumber - lengthNumb + 1);
        return current;
    }

    public static void getGrafic(int amountSpace, int lengthLine, int res, int current, int secondNumber) {
        getSpace(amountSpace);
        System.out.println(res);
        System.out.println("-");
        getSpace(amountSpace);
        System.out.println(current * secondNumber);
        getSpace(amountSpace);
        for(int i = 1; i <= lengthLine; i++)
            System.out.print("-");
        System.out.println();
    }

    public static int doSpecialCases(int[] mass, int i, int ost, int secondNumber) {
        boolean isCorrect = true;
        if (i == 0)
            ost = ost + 10;
        else
            ost = 0;
        while (isCorrect){
            if (secondNumber > 0){
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

    public static void chooseOption(int[] massCopy, boolean isCorrect, int current, int secondNumber, int n, int amountSpace, int res, int line) {
        if (isCorrect)
        {
            current = massCopy.length + n;
            System.out.println( "|" +(current));
            System.out.print(" ");
            for(int j = 1; j <= line; j++)
                System.out.print( "-");
            System.out.println();
        }
        else
        {
            getGrafic(amountSpace, line, res, current, secondNumber);
        }
    }

    public static int getAmountSpace(int ost, int amountSpace, String stringRes, int i) {
        if (ost == 0)
            amountSpace = stringRes.length();
        else
        {
            String stringOst = Integer.toString(ost);
            amountSpace = stringRes.length() + amountSpace - stringOst.length();
        }
        if ((i == 1) && (ost == 0))
        {
            amountSpace = amountSpace - 1;
        }
        return amountSpace;
    }

    public static void getResult(int[] massCopy, int secondNumber, int n) {
        int[] mass = new int[n+10];
        int current;
        int ost = 0;
        int res;
        boolean isCorrect = true;
        int i = n;
        int amountSpace = 2;
        int line = 1;
        while(i > 0)
        {
            if (isCorrect && n > 5)
            {
                ost = ost + 100;
                mass[i] = 0;
                i = i - 1;
                ost = i + ost;
            }
            else
            {
                res = mass[i] + ost * 10;
                String stringRes = Integer.toString(res);
                line = stringRes.length();
                ost = (res % secondNumber);
                if ((secondNumber == 3) && (n == 1))
                    line = line + 1;
                current = (res / secondNumber);
                chooseOption(massCopy, isCorrect, current, secondNumber, n, amountSpace, res, line);
                amountSpace = 0;
                i = i - 1;
                isCorrect = false;
            }
        }
        getSpace(amountSpace);
        System.out.println(ost);
    }

    public static double[] getAverageScore(int number){
        double[] grade = new double[number];
        int sum = 3;
        for (short i = 0; i < number; i++)
        {
            for (short j = 0; j < number; j++)
            {
                grade[j] = 0;
            }
            grade[i] = ((double) sum / (number));
            sum++;
        }
        return grade;
    }

    public static boolean checkFirstElem(char[] ch) {
        return ch[0] >= 'A' && ch[0] <= 'Z' || ch[0] == '_';
    }

    public static boolean checkRestElem(char[] ch, boolean isCorrect, int n) {
        for(int i = 0; isCorrect && i < n; ++i) {
            isCorrect = ch[i] >= 'A' && ch[i] <= 'Z' || ch[i] == '_' || ch[i] >= '0' && ch[i] <= '9';
        }

        return isCorrect;
    }

    public static boolean checkElem(char[] ch, int n) {
        boolean isCorrect = checkFirstElem(ch);
        isCorrect = checkRestElem(ch, isCorrect, n);
        return isCorrect;
    }

    public static char[] isStringToChar(String str) {
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
        for(int i = 0; i < number; ++i) {
            int x = i;

            for(int j = i + 1; j < number; ++j) {
                if (number == 3) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }

    /*public static void main(String[] args) {
        outputTask();
        int firstNumber = checkNumber();
        int secondNumber = checkNumberSecondNumber(firstNumber);
        System.out.print( " " + firstNumber);
        System.out.println( "|" + secondNumber);
        String stringFirstNumber = Integer.toString(firstNumber);
        int lengthFirstNumber = stringFirstNumber.length();
        int[] mass;
        mass = getMass(firstNumber, lengthFirstNumber);
        getResult(mass, secondNumber, lengthFirstNumber);
    }*/
}