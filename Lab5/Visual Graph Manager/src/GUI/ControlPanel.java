package GUI;

import main.Catalog;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ControlPanel extends JPanel {
    JButton loadButton = new JButton("Load");
    JFileChooser loadChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("DAT file", "dat");
    JButton saveButton = new JButton("Save");
    JFileChooser saveChooser = new JFileChooser();
    JButton openButton = new JButton("Open");
    private List<String> graphList = new ArrayList<>();
    JComboBox openGraph = new JComboBox(graphList.toArray());

    public ControlPanel(){
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 10, 10, 3);
        gbc.ipadx = 90;
        gbc.ipady = 10;
//        gbc.weightx = 1;
//        gbc.gridwidth = 1;

        add(loadButton, gbc);
        add(saveButton, gbc);
        add(openButton, gbc);
        add(openGraph, gbc);

        loadChooser.setMultiSelectionEnabled(false);
        loadChooser.addChoosableFileFilter(filter);
        loadChooser.setAcceptAllFileFilterUsed(false);

    }

    public void addGraphToList(String name){
        openGraph.addItem(name);
    }

    public void removerGraphsFromList(){
        openGraph.removeAllItems();
    }
}
