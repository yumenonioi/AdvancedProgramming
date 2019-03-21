package Commands;

import main.Catalog;

import java.io.Serializable;

public abstract class Command implements Serializable {
//    protected List<OurGraph> listOfGraphs = new ArrayList<>();

    public abstract boolean checkInput();

    public abstract Catalog executeCommand();

//    public void setListOfGraphs(OurGraph graph) {
//        this.listOfGraphs.add(graph);
//    }
//
//    public void clearListOfGraphs(){
//        this.listOfGraphs.clear();
//    }
//
//    public List<OurGraph> getListOfGraphs() {
//        return listOfGraphs;
//    }

    //    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
}
