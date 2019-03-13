import java.util.List;

public class Node {
    private String name;
    private List<Edge> connections;

    public void setName(String name) {
        this.name = name;
    }

    public void setConnections(List<Edge> connections) {
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getConnections() {
        return connections;
    }
}
