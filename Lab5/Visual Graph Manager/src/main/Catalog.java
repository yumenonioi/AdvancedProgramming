package main;

import Model.OurGraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<OurGraph> listOfGraphs = new ArrayList<>();

    public void setListOfGraphs(OurGraph graph) {
        this.listOfGraphs.add(graph);
    }

    public void clearListOfGraphs(){
        this.listOfGraphs.clear();
    }

    public List<OurGraph> getListOfGraphs() {
        return listOfGraphs;
    }
}
