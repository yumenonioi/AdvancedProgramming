package Main;

import Locations.Church;
import Locations.Edge;
import Locations.Hotel;
import Locations.Restaurant;
import Map.TravelMap;

public class Main {

    public static void main(String[] args) {
        Hotel v1 = new Hotel("California");
        Church v2 = new Church("St. Peter");
        Church v3 = new Church("St. Mary");
        Church v4 = new Church("St. X");
        Restaurant v5 = new Restaurant("Vidiv");
        Restaurant v6 = new Restaurant("Hall");

        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);

        map.addEdge(v1, v2, 15);
        map.addEdge(v1, v3, 10);
        map.addEdge(v3, v2, 1, false);
        map.addEdge(v3, v4, 1);
        map.addEdge(v4, v5, 1);
//        map.addEdge(v3, v2, 1, false);
        map.addEdge(v5, v5, 1);
//        map.addEdge(v1, v2, 15);
        map.addEdge(v2, v6, 10);

        System.out.println("The map is: \n" + map.getMap());

    }

}
