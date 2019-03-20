package Commands;

import main.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveCommand extends Command implements Serializable {

    private String name = new String();
    private Path path = null;
    private Catalog catalog = new Catalog();

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = Paths.get(path);
        this.name = path.substring(path.lastIndexOf("/") + 1);
    }

    @Override
    public boolean checkInput() {
        if (!(name.substring(name.length() - 4).equals(".dat"))) {
            try {
                throw new InvalidFileExtension("Incorrect filename: " + name);
            } catch (InvalidFileExtension invalidFileExtension) {
                invalidFileExtension.printStackTrace();
                return false;
            }
        }

        return true;
    }

    @Override
    public Catalog executeCommand() {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.path.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(catalog);
            out.close();
            fileOut.close();
            System.out.println("File saved at: " + this.path);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return catalog;
    }
}
