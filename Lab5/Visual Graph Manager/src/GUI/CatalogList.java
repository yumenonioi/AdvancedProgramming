package GUI;

import javax.swing.*;

public class CatalogList extends JList {
    DefaultListModel model = new DefaultListModel<>();

    public CatalogList() {
        String title = "<html><b><font color='white'>" + "Catalog Model" + "</font></b></html>";
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setModel(model);
        this.isDisplayable();
    }

    public void addGraph(String item){
        model.addElement(item);
    }
    public void removeGraphs(){
        model.removeAllElements();
    }
}
