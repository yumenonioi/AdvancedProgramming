package Model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name = new String();
    private List<Edge> listOfEdges = new ArrayList<>();



    public String getName() {
        return name;
    }

    public List<Edge> getListOfEdges() {
        return listOfEdges;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfEdges(List<Edge> listOfEdges) {
        this.listOfEdges = listOfEdges;
    }
}
