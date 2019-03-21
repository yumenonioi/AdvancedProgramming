package Model;

public class Edge {
    private String node1 = new String();
    private String node2 = new String();
    private int cost;

    public Edge(String node1, String node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getNode1() {
        return node1;
    }

    public String getNode2() {
        return node2;
    }

    public int getCost() {
        return cost;
    }

    public void setNode1(String node1) {
        this.node1 = node1;
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
