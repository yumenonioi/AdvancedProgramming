package Commands;

import main.Catalog;

public class ListCommand extends Command {

    private Catalog catalog = new Catalog();

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean checkInput() {
        return false;
    }

    @Override
    public Catalog executeCommand() {
        System.out.println(catalog.getListOfGraphs());
        return null;
    }
}
