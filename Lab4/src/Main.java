import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Where should the catalog be stored? ");
        String catalogPath = in.nextLine();
        Catalog catalog = new Catalog(catalogPath);

        System.out.println("Enter command: ");
        String command = in.nextLine();

        while(!(command.equals("exit"))){
            processCommand(command, catalog);
            System.out.println("Enter next command: ");
            command = in.nextLine();
        }
    }

    public static void processCommand(String command, Catalog catalog) throws IOException {
        Scanner in = new Scanner(System.in);

        switch (command) {
            case "add":
                System.out.println("Enter the name of the graph");
                String firstParameter = in.nextLine();
                System.out.println("Enter the .tgf file path");
                String secondParameter = in.nextLine();
                System.out.println("Enter the destination path for the generated image of the graph");
                String thirdParameter = in.nextLine();
                catalog.add(new OurGraph(firstParameter, secondParameter, thirdParameter));
                break;

            case "list":
                catalog.list();
                break;

            case "open":
                System.out.println("Enter the name of the graph that you wish to open");
                String graphName = in.nextLine();
                catalog.open(graphName);
                break;

            case "save":
                System.out.println("Enter the name of the saved file");
                String fileName = in.nextLine();
                catalog.save(fileName);
                break;

            case "load":
                System.out.println("What catalog do you wish to open?");
                fileName = in.nextLine();
                catalog.load(fileName);
                break;

                default:
                    System.out.println("You have entered an invalid command. Please enter a command from the following:\nadd \nlist\nopen\nsave\nload\nexit");
                    System.out.println();
        }
    }
}
