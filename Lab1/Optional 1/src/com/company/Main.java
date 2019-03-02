package com.company;

public class Main {

    public static void main(String[] args) {

        long[][] matrix = new long[6_000][6_000];
        long m;
        m = 0;

        long startTime = System.nanoTime();

        if (args.length != 2) throw new IllegalArgumentException("2 parameters required");

        try {
            long n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("First argument is not integer");
        }

        long n = Integer.parseInt(args[0]);

        if (n % 2 == 0) throw new IllegalArgumentException("Number is not odd.");

        if (args[1].equals("complete")) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) matrix[i][j] = 0;
                    else {
                        matrix[i][j] = 1;
                        m++;
                    }
                }
            }
        } else if (args[1].equals("cycle")) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 && j == n) {
                        matrix[i][j] = 1;
                        m++;
                    } else if (j == 1 && i == n) {
                        matrix[i][j] = 1;
                        m++;
                    } else if (Math.abs(i - j) == 1) {
                        matrix[i][j] = 1;
                        m++;
                    } else matrix[i][j] = 0;
                }
            }
        } else if (args[1].equals("random")) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    if (i != j) {
                        if (matrix[i][j] != 1) {
                            int element = (int) (Math.random() * 2);
                            matrix[i][j] = element;
                            matrix[j][i] = element;
                            if (element == 1) m = m + 2;
                        }
                    } else matrix[i][i] = 0;
            }
        } else throw new IllegalArgumentException("The type of graph is not valid.");

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        if (n < 5_000) {

            int vertices = 1;
            int maxDegree = 0;
            int minDegree = 999;
            int degree = 0;
            int checkDegree = 0;
            int sumDegrees = 0;

            int count = 1;
            System.out.print('\u250F');
            for (count = 1; count < (n * 4); count++)
                if (count % 4 == 0)
                    System.out.print('\u252F');
                else
                    System.out.print('\u2501');
            System.out.println('\u2513');
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] == 1) {
                        vertices++;
                        degree++;
                    }
                    if (j == 1) {
                        if (j != n) {
                            System.out.print('\u2503');
                            System.out.print(" " + matrix[i][j] + " ");
                            System.out.print('\u2502');
                        } else {
                            System.out.print('\u2503');
                            System.out.print(" " + matrix[i][j] + " ");
                            System.out.print('\u2503');
                        }
                    } else if (j == n) {
                        System.out.print(" " + matrix[i][j] + " ");
                        System.out.print('\u2503');
                    } else {
                        System.out.print(" " + matrix[i][j] + " ");
                        System.out.print('\u2502');
                    }
                }
                System.out.print("\n");
                if (i != n) {
                    System.out.print('\u2520');
                    for (count = 1; count < (n * 4); count++)
                        if (count % 4 == 0)
                            System.out.print('\u253C');
                        else
                            System.out.print('\u2500');
                    System.out.println('\u2528');
                }

                if (degree > maxDegree) maxDegree = degree;
                if (degree < minDegree) minDegree = degree;

                if (i == 1)
                    checkDegree = degree;
                else if (checkDegree != degree)
                    checkDegree = -1;

                sumDegrees += degree;

                degree = 0;
            }
            System.out.print('\u2517');
            for (count = 1; count < (n * 4); count++)
                if (count % 4 == 0)
                    System.out.print('\u2537');
                else
                    System.out.print('\u2501');
            System.out.println('\u251B' + "\n");

            System.out.println("Number of edges is: " + m / 2 + "\n");

            System.out.println('\u0394' + "(G) = " + maxDegree);
            System.out.println('\u03B4' + "(G) = " + minDegree);

            if (checkDegree == -1)
                System.out.println("The graph is not regular.");
            else
                System.out.println("The graph is regular. (degree=" + checkDegree + ")\n");

            if (sumDegrees == m)
                System.out.println("The sum of the degrees equals the value 2*m.");
            else
                System.out.println("The sum of the degrees is not equal with the value 2*m.");
            System.out.print("\n");

            System.out.println(totalTime);

        } else
            System.out.println("Running time: " + totalTime);
    }
}