import java.util.List;

public class Catalog {
    private String path;
    private List<OurGraph> graphs;

    public void setPath(String path) {
        this.path = path;
    }

    public void setGraphs(List<OurGraph> graphs) {
        this.graphs = graphs;
    }

    public String getPath() {
        return path;
    }

    public List<OurGraph> getGraphs() {
        return graphs;
    }
}
