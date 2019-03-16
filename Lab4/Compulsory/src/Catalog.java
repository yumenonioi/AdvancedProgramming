import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String path = new String();
    private List<OurGraph> graphs = new ArrayList<>();

    public Catalog(String givenPath) throws IOException {
        this.setPath(givenPath);
    }

    public void setPath(String path) throws FileNotFoundException {
        Path myPath = Paths.get(path);

        if (Files.exists(myPath))
            this.path = path;
        else
            throw new FileNotFoundException();
    }

    public void setGraphs(List<OurGraph> graphs) {
        this.graphs = graphs;
    }

    public String getPath() {
        return path;
    }

    public List<OurGraph> getGraphs() {
        return graphs;
    }

    public void add(OurGraph graph) {
        graphs.add(graph);
    }

    public List<OurGraph> list() {
        return graphs;
    }

    public void open(String graphName) throws IOException {
        for (OurGraph graph : graphs) {
            if (graph.getName().equals(graphName)) {
                displayImage(graph);
            }
        }
    }

    private void displayImage(OurGraph graph) throws IOException {
        JPanel panel = new JPanel();

        System.out.println(graph.getImageAddress());
        BufferedImage image = ImageIO.read(new File(graph.getImageAddress()));
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
        System.out.println("finished");
    }

    public void save(String name) throws Exception {
        if (!(name.substring(name.length() - 4).equals(".dat"))) {
            throw new InvalidFileExtension("Incorrect filename: " + name);
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(this.path + "/" + name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("File saved at: " + this.path + "/" + name);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Catalog load(String name) throws FileNotFoundException, IOException {
        Catalog c = null;


        FileInputStream fileIn = new FileInputStream(this.getPath() + "/" + name);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        try {
            c = (Catalog) in.readObject();
            in.close();
            fileIn.close();
            return c;
        } catch (FileNotFoundException f) {
            System.out.println("Specified catalog does not exist.");
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException b) {
            System.out.println("Catalog class not found.");
            b.printStackTrace();
        }
        return this;
    }
}
