package Controller;

import Commands.*;
import main.Catalog;

public class Controller {
    Catalog catalog = new Catalog();

    public void add(String input){
        AddCommand add = new AddCommand(catalog, input);

        if(add.checkInput())
            catalog = add.executeCommand();
    }
    public void list(){
        ListCommand list = new ListCommand(catalog);

        list.executeCommand();
    }

    public void open(String input){
        OpenCommand open = new OpenCommand(catalog, input);

        if(open.checkInput())
            open.executeCommand();
    }

    public void save(String input){
        SaveCommand save = new SaveCommand(catalog, input);

        if(save.checkInput())
            save.executeCommand();
    }

    public void load(String input){
        LoadCommand load = new LoadCommand(catalog, input);

        if(load.checkInput())
            this.catalog = load.executeCommand();
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
