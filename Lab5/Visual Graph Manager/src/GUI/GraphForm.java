package GUI;

import Graphs.OurGraph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GraphForm extends JPanel {
//    private final CatalogFrame frame;

    JLabel nameLabel = new JLabel("Name of the graph:");
    JTextField name = new JTextField();

    JLabel typeLabel = new JLabel("Type of the graph:");
    String[] typeOptions = {"simple", "directed"};
    JComboBox type = new JComboBox(typeOptions);

    JLabel destinationFileLabel = new JLabel("From:");
    JTextField destinationFile = new JTextField();

    JLabel imageLocationLabel = new JLabel("Image location:");
    JTextField imageLocation = new JTextField();

    JLabel numberOfVerticesLabel = new JLabel("Number of vertices:");
    JSpinner numberOfVertices = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));

    JLabel numberOfEdgesLabel = new JLabel("Number of edges:");
    JSpinner numberOfEdges = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));

    public GraphForm(){
        init();
    }

    private void init(){
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(1000, 300));
        this.setBorder(BorderFactory.createTitledBorder("Add graph"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipadx = 10;
        gbc.ipady = 10;

        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        add(nameLabel, gbc);

        gbc.gridy=1;
        gbc.gridx=0;
        gbc.gridwidth = 6;
        add(name, gbc);

        gbc.gridy=2;
        gbc.gridx=0;
        gbc.gridwidth = 1;
        add(destinationFileLabel, gbc);

        gbc.gridy=3;
        gbc.gridx=0;
        gbc.gridwidth = 6;
        add(destinationFile, gbc);

        gbc.gridy=4;
        gbc.gridx=0;
        gbc.gridwidth = 1;
        add(imageLocationLabel, gbc);

        gbc.gridy=5;
        gbc.gridx=0;
        gbc.gridwidth = 6;
        add(imageLocation, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 6;
        gbc.ipady = 6;
        gbc.gridy=6;
        gbc.gridx=0;
        gbc.gridwidth = 1;
        add(typeLabel, gbc);

        gbc.gridy=6;
        gbc.gridx=1;
        add(type, gbc);

        gbc.gridy=6;
        gbc.gridx=2;
        add(numberOfVerticesLabel, gbc);

        gbc.gridy=6;
        gbc.gridx=3;
        add(numberOfVertices, gbc);

        gbc.gridy=6;
        gbc.gridx=4;
        add(numberOfEdgesLabel, gbc);

        gbc.gridy=6;
        gbc.gridx=5;
        add(numberOfEdges, gbc);

        gbc.gridy=8;
        gbc.gridx=2;
        gbc.gridwidth = 1;
        Button addButton = new Button("Add");
        add(addButton, gbc);

        addButton.addActionListener(e -> {
            try {
                addGraph(name.getText(), (String) type.getSelectedItem(), destinationFile.getText(), imageLocation.getText(), (String) numberOfVertices.getValue(), (String) numberOfEdges.getValue());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        this.setVisible(true);
    }

    private OurGraph addGraph(String name, String type, String destinationFile, String imageLocation, String numberOfVertices, String numberOfEdges) throws IOException {
        OurGraph graph = new OurGraph(name, type, destinationFile, imageLocation, numberOfVertices, numberOfEdges);
//        frame.list.addGraph(graph);
        return graph;
    }
}
