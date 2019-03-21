package GUI;

import Controller.Controller;
import Model.OurGraph;
import main.Catalog;
import org.graphstream.graph.Graph;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CatalogFrame extends JFrame {
    GraphForm form = new GraphForm();
    CatalogList list = new CatalogList();
    ControlPanel control = new ControlPanel();
    Controller controller = new Controller();

    public CatalogFrame() {
        super("Visual Graph Manager");
        init();
        buttonActions();
    }

    private void init(){
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(1000, 700));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        form.setPreferredSize(new Dimension(1000, 300));
        form.setBackground(Color.GRAY);
        this.add(form, BorderLayout.NORTH);

        list.setPreferredSize(new Dimension(1000, 300));
        list.setBackground(Color.GRAY);
        this.add(list, BorderLayout.CENTER);

        control.setPreferredSize(new Dimension(1000, 100));
        control.setBackground(Color.GRAY);
        this.add(control, BorderLayout.SOUTH);

        this.pack();
    }

    public void buttonActions(){
        form.addButton.addActionListener(e -> {
            list.addGraph("Nume: " +
                    form.name.getText() + ", " +
                    "Tip: " +
                    (String) form.type.getSelectedItem() + ", " +
                    "Numar de noduri: " +
                    form.numberOfVertices.getValue().toString() + ", " +
                    "Numar de muchii: " +
                    form.numberOfEdges.getValue().toString());
            controller.add(form.name.getText() + "," +
                    form.type.getSelectedItem() + "," +
                    form.destinationFile.getText() + "," +
                    form.imageLocation.getText() + "," +
                    form.numberOfVertices.getValue().toString() + "," +
                    form.numberOfEdges.getValue().toString());
            control.addGraphToList(form.name.getText());
        });

        control.openButton.addActionListener(e -> {
            controller.open(control.openGraph.getSelectedItem().toString());
        });

        control.loadButton.addActionListener(e -> {
            final JFrame frame = new JFrame("Load from");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String path = new String();

            int retVal = control.loadChooser.showOpenDialog(frame);
            if(retVal == JFileChooser.APPROVE_OPTION) {
                list.removeGraphs();
                control.removerGraphsFromList();

                path = control.loadChooser.getSelectedFile().getAbsolutePath();
                controller.load(path);

                List<OurGraph> graphs = controller.getCatalog().getListOfGraphs();

                for(OurGraph graph : graphs) {
                    list.addGraph("Nume: " +
                            graph.getName() + ", " +
                            "Tip: " +
                            graph.getType() + ", " +
                            "Numar de noduri: " +
                            graph.getNumberOfVertices() + ", " +
                            "Numar de muchii: " +
                            graph.getNumberOfEdges());
                    control.addGraphToList(graph.getName());
                }
            }
        });

        control.saveButton.addActionListener(e -> {
            final JFrame frame = new JFrame("Save to");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String path = new String();

            control.saveChooser.showSaveDialog(frame);
            path = control.saveChooser.getSelectedFile().getAbsolutePath();
            if(!(path.endsWith(".dat")))
                path = path.concat(".dat");
            controller.save(path);
        });
    }

}
