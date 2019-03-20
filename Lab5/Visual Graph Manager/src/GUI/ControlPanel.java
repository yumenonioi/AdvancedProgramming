package GUI;

import main.Catalog;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final CatalogFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton openButton = new JButton("Open");

    public ControlPanel(CatalogFrame frame){
        this.frame = frame;
        init();
    }

    private void init() {
        frame.add(loadButton);
        frame.add(saveButton);
        frame.add(openButton);
    }
}
