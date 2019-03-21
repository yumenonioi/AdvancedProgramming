package Commands;

import Model.OurGraph;
import main.Catalog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenCommand extends Command{

    private Catalog catalog = new Catalog();
    private List<OurGraph> listOfGraphs = new ArrayList<>();
    private String graphName;
    private OurGraph foundGraph = null;

    public OpenCommand(Catalog catalog, String graphName) {
        this.catalog = catalog;
        this.listOfGraphs = catalog.getListOfGraphs();
        this.graphName = graphName;
    }

    @Override
    public boolean checkInput() {

        // Check if the name of the graph exists
        for(OurGraph graph : listOfGraphs)
            if(graph.getName().equals(graphName)) {
                this.foundGraph = graph;
                return true;
            }

        System.out.println("The specified name does not exist.");
        return false;
    }

    @Override
    public Catalog executeCommand() {
        JPanel panel = new JPanel();

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(foundGraph.getImageAddress()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        return catalog;
    }
}
