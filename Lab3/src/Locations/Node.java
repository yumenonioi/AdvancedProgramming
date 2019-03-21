package Locations;

public abstract class Node {
    private String name = new String();
    private String address = new String();
    private boolean visited = false;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isVisited(Node n){
        return this.visited;
    }


}
