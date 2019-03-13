import java.util.List;

public class Catalog {
    private String path;
    private List<Graph> graphs;

    public void setPath(String path) {
        this.path = path;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public String getPath() {
        return path;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }
}
