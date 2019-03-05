package Map;

import Locations.Edge;
import Locations.Node;

import java.util.ArrayList;
import java.util.List;

public class TravelMap {
    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addEdge(Node node1, Node node2, int cost) {
        Edge auxEdge = new Edge(node1, node2, cost);
        boolean isValid = false;

        if (edges.isEmpty()) {
            this.edges.add(auxEdge);
        } else {
            for (Edge edge : edges) {
                if (auxEdge.equals(edge)) {
                    System.out.println("Edge already exists.");
                    System.out.println(auxEdge);
                    break;
                } else {
                    isValid = true;
                    break;
                }
            }
        }

        if (!(nodes.contains(node1))) {
            System.out.println("First node is not part of the map.");
            isValid = false;
        }
        if (!(nodes.contains(node2))) {
            System.out.println("Second node is not part of the map.");
            isValid = false;
        }

        if (isValid)
            edges.add(auxEdge);
    }

    public void addEdge(Node node1, Node node2, int cost, boolean bidirectional) {
        Edge auxEdge = new Edge(node1, node2, cost, bidirectional);
        boolean isValid = true;

        if (edges.isEmpty()) {
            this.edges.add(auxEdge);
        } else {
            for (Edge edge : edges) {
                if (auxEdge.getBidirectional() == false) {
                    if (edge.getBidirectional() == false) {
                        if (auxEdge.equals(edge)) {
                            System.out.println("Edge already exists.");
                            System.out.println(auxEdge);
                            break;
                        } else {
                            isValid = true;
                            break;
                        }
                    }
                }
            }
        }

        if (!(nodes.contains(node1))) {
            System.out.println("First node is not part of the map.");
            isValid = false;
        }
        if (!(nodes.contains(node2))) {
            System.out.println("Second node is not part of the map.");
            isValid = false;
        }

        if (isValid)
            edges.add(auxEdge);
    }

    public String getMap() {
        String returnValue = new String();
        for (Edge edge : edges)
            returnValue = returnValue + "\n" + edge.toString();
        return returnValue;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
