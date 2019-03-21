package Commands;

import main.Catalog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadCommand extends Command {

    private Catalog catalog;
    private Path path;

    public LoadCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = Paths.get(path);
    }

    @Override
    public boolean checkInput() {
        // Check if the path exists
        if (!(Files.exists(path))) {
            System.out.println("The file does not exist.");
            return false;
        }

        // Check if the file is .dat
        if (!(path.toString().endsWith(".dat"))) {
            System.out.println("The files's format is not .dat.");
            return false;
        }

        return true;
    }

    @Override
    public Catalog executeCommand() {
        catalog.clearListOfGraphs();

        try {
            FileInputStream fileIn = new FileInputStream(path.toFile());
            ObjectInputStream in = new ObjectInputStream(fileIn);

            try {
                this.catalog = (Catalog) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Loading complete of the catalog.");
                return catalog;
            } catch (FileNotFoundException f) {
                System.out.println("Specified catalog does not exist.");
                f.printStackTrace();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException b) {
                System.out.println("Catalog class not found.");
                b.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hap");
        return null;
    }
}
