package Main;
import java.util.Queue;
import java.util.LinkedList;
import Locations.Node;
import Locations.Edge;
import Map.TravelMap;


public class Greedy {

    public String greedyAlg(Node n1, Node n2){
        Queue<Node> queue = new LinkedList<>();
        Node[] visited = new Node[100];
        String path = new String();
        path = path + n1 + " ";

        queue.add(n1);

        while (!queue.isEmpty()){


        }


        return path;
    }
}
