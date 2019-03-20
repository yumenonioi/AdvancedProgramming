package GUI;

import javax.swing.*;

public class CatalogList extends JList {
    DefaultListModel model = new DefaultListModel<>();

    public CatalogList() {
        String title = "<html><b><font color='red'>" + "Catalog Graphs" + "</font></b></html>";
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setModel(model);
    }

    public void addGraph(String item){
        model.addElement(item);
    }
}
