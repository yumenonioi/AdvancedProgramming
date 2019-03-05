package Locations;

public class Edge {
    private String indicator;
    private Node node1;
    private Node node2;
    private boolean isBidirectional = false;
    private int cost;

    public Edge(Node node1, Node node2, int cost) {
        setBidirectional(true);
        setNode1(node1);
        setNode2(node2);
        setCost(cost);
    }

    public Edge(Node node1, Node node2, int cost, boolean bidirectional) {
        setBidirectional(bidirectional);
        setNode1(node1);
        setNode2(node2);
        setCost(cost);
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    private void setNode1(Node node1) {
        this.node1 = node1;
    }

    private void setNode2(Node node2) {
        this.node2 = node2;
    }

    private void setBidirectional(boolean bidirectional) {
        isBidirectional = bidirectional;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getIndicator() {
        return indicator;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public boolean getBidirectional() {
        return isBidirectional;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        if (getBidirectional())
            return node1 + "<->" + node2 + " | " + cost;
        else
            return node1 + "->" + node2 + " | " + cost;
    }


    public boolean equals(Edge o) {

        if (o == null)
            return false;
        if (o == this)
            return true;

        Edge compare = o;


        if (this.isBidirectional == true) {
            if (compare.node1 == this.node1) {
                if (compare.node2 == this.node2)
                        return true;
            } else {
                if (compare.node1 == this.node2)
                    if (compare.node2 == this.node1)
                            return true;
            }
        } else {
            if (compare.node1 == this.node1) {
                if (compare.node2 == this.node2) {
                    return true;
                }
            }
        }

        return false;
    }
}
