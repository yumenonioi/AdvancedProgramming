package Commands;

import Model.OurGraph;
import main.Catalog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddCommand extends Command {

    private Catalog catalog = new Catalog();

    private String name = new String();
    private String type = new String();
    private String definition = new String();
    private String imageAddress = new String();
    private String numberOfEdges =  new String();
    private String numberOfVertices = new String();

    public AddCommand(Catalog catalog, String input) {
        this.catalog = catalog;
        parseInput(input);
    }

    @Override
    public boolean checkInput() {

        // Check if any parameter is null

        if(name.equals(null) || type.equals(null) || definition.equals(null) || imageAddress.equals(null))
            return false;

        // The file entered doesn't have the .tgf extension
        if( !(definition.substring(definition.length()-4).equals(".tgf")) ){
            System.out.println("The file format that you have entered is not .tgf" + definition.substring(definition.length()-4));
            return false;
        }

        // The file entered does not exit
        Path myPath = Paths.get(definition);
        if( !(Files.exists(myPath))){
            System.out.println("The file does not exist.");
            return false;
        }
        return true;
    }

    @Override
    public Catalog executeCommand() {
        OurGraph newGraph = null;
        try {
            newGraph = new OurGraph(name, type, definition, imageAddress, numberOfVertices, numberOfEdges);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.catalog.setListOfGraphs(newGraph);

        return this.catalog;
    }

    private void parseInput(String input){

        input = input.replace("\\s+", "");

        String[] inputValues = input.split(",");

        for(int i=0; i<=6; i++){
            if(i == 0) {
                this.name = inputValues[i];
            }
            if(i == 1){
                this.type = inputValues[i];
            }
            if(i == 2){
                this.definition = inputValues[i];
            }
            if(i == 3){
                this.imageAddress = inputValues[i];
            }
            if(i == 4){
                this.numberOfVertices = inputValues[i];
            }
            if(i == 5){
                this.numberOfEdges = inputValues[i];
            }
        }
    }
}