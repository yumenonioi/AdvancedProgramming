package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int [][] matrix = new int[20][20];
        int m = 0;

        if(args.length != 2) throw new IllegalArgumentException("2 parameters required");

        try{
            int n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("First argument is not integer");
        }

        int n = Integer.parseInt(args[0]);

        if(n%2 == 0) throw new IllegalArgumentException("Number is not odd.");

        if(args[1].equals("complete")) {
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                {
                    if(i==j) matrix[i][j]=0;
                    else {
                        matrix[i][j]=1;
                        m++;
                    }
                }
            }
        }

        else if(args[1].equals("cycle")) {
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                {
                    if(i==1 && j==n) {
                        matrix[i][j]=1;
                        m++;
                    }
                    else if(j==1 && i==n) {
                        matrix[i][j]=1;
                        m++;
                    }
                    else if(Math.abs(i-j) == 1) {
                        matrix[i][j]=1;
                        m++;
                    }
                    else matrix[i][j]=0;
                }
            }
        }

        else if(args[1].equals("random")) {
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                {
                    if(i!=j) {
                        if (matrix[i][j] != 1) {
                            int element = (int) (Math.random() * 2);
                            matrix[i][j] = element;
                            matrix[j][i] = element;
                            if (element == 1) m=m+2;
                        }
                    }
                    else matrix[i][i]=0;
                }
            }
        }

        else throw new IllegalArgumentException("The type of graph is not valid.");

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }

        System.out.println("Number of edges is: " + m/2);
    }
}
