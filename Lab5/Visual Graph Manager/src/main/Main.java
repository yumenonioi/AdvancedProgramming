package main;

import Commands.*;
import GUI.CatalogFrame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Catalog catalog = new Catalog();
//        Scanner in = new Scanner(System.in);
//        String input = new String();
//        String command = new String();
//        boolean whileCondition = true;
//
//        while(whileCondition){
//            System.out.println("Enter command: ");
//            command = in.next();
//            switch (command){
//                case "exit":
//                    System.out.println("Bye.");
//                    whileCondition = false;
//                    break;
//
//                case "add":
//                    input = in.nextLine();
//                    if(input.equals(null)) {
//                        System.out.println("No parameters were entered.");
//                        break;
//                    }
//                    input = input.substring(1);
//                    AddCommand add = new AddCommand(catalog, input);
//                    if(add.checkInput())
//                        catalog = add.executeCommand();
//                    break;
//
//                case "list":
//                    ListCommand list = new ListCommand(catalog);
//                    list.executeCommand();
//                    break;
//
//                case "open":
//                    input = in.nextLine();
//                    if(input.equals(null)) {
//                        System.out.println("No parameters were entered.");
//                        break;
//                    }
//                    input = input.substring(1);
//                    OpenCommand open = new OpenCommand(catalog, input);
//                    if(open.checkInput())
//                        open.executeCommand();
//                    break;
//
//                case "save":
//                    input = in.nextLine();
//                    if(input.equals(null)) {
//                        System.out.println("No parameters were entered.");
//                        break;
//                    }
//                    input = input.substring(1);
//                    SaveCommand save = new SaveCommand(catalog, input);
//                    if(save.checkInput())
//                        save.executeCommand();
//                    break;
//
//                case "load":
//                    input = in.nextLine();
//                    if(input.equals(null)) {
//                        System.out.println("No parameters were entered.");
//                        break;
//                    }
//                    input = input.substring(1);
//                    LoadCommand load = new LoadCommand(catalog, input);
//                    if(load.checkInput())
//                        catalog = load.executeCommand();
//                    break;
//
//                    default:
//                        System.out.println("The command is not valid.");
//            }
//
//        }

        new CatalogFrame().setVisible(true);
    }
}


//add "K3", "The complete graph with 3 vertices", "/home/cris/Desktop/Facultate/sem2-2/Java/AdvancedProgramming/Lab4/Compulsory/k3.tgf", "/home/cris/Desktop/Facultate/sem2-2/Java/AdvancedProgramming/Lab4/Optional/k3.png"
//add "butterfly", "The butterfly graph", "/home/cris/Desktop/Facultate/sem2-2/Java/AdvancedProgramming/Lab4/Compulsory/butterfly.tgf", "/home/cris/Desktop/Facultate/sem2-2/Java/AdvancedProgramming/Lab4/Optional/butterfly.png"