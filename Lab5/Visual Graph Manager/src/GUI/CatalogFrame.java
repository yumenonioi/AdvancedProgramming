package GUI;

import main.Catalog;
import org.graphstream.graph.Graph;

import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
    GraphForm form = new GraphForm();
    CatalogList list;
    ControlPanel control;

    private Catalog catalog = new Catalog();

    public CatalogFrame() {
        super("Visual Graph Manager");
        init();
    }

    private void init(){
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(1000, 900));
        form.setPreferredSize(new Dimension(1000, 300));
        this.pack();

        form.setBackground(Color.GRAY);
        this.add(form, BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
