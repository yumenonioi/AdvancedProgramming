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

        int count=1;
        System.out.print('\u250F');
        for(count=1; count<(n*4);count++)
            if(count%4==0)
                System.out.print('\u252F');
            else
                System.out.print('\u2501');
        System.out.println('\u2513');
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if(j==1) {
                    if(j!=n) {
                        System.out.print('\u2503');
                        System.out.print(" " + matrix[i][j] + " ");
                        System.out.print('\u2502');
                    }
                    else {
                        System.out.print('\u2503');
                        System.out.print(" " + matrix[i][j] + " ");
                        System.out.print('\u2503');
                    }
                }
                else if(j==n){
                    System.out.print(" " + matrix[i][j] + " ");
                    System.out.print('\u2503');
                }
                else {
                    System.out.print(" " + matrix[i][j] + " ");
                    System.out.print('\u2502');
                }
            }
            System.out.print("\n");
            if(i!=n) {
                System.out.print('\u2520');
                for (count = 1; count < (n * 4); count++)
                    if (count % 4 == 0)
                        System.out.print('\u253C');
                    else
                        System.out.print('\u2500');
                System.out.println('\u2528');
            }
        }
        System.out.print('\u2517');
        for(count=1; count<(n*4);count++)
            if(count%4==0)
                System.out.print('\u2537');
            else
                System.out.print('\u2501');
        System.out.println('\u251B');

        System.out.println("Number of edges is: " + m/2);
    }
}
