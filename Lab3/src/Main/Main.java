package Main;

import Locations.*;
import Map.TravelMap;
import interfaces.Payable;
import interfaces.Visitable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Node> locations = new ArrayList<>();

        Hotel v1 = new Hotel("California");
        Museum v2 = new Museum("Luvru");
        Museum v3 = new Museum("Prado");
        Church v4 = new Church("St. Mary");
        Church v5 = new Church("St. Peter");
        Restaurant v6 = new Restaurant("Hall");

        locations.addAll(Arrays.asList(v1, v2, v3, v4, v5, v6));

        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);

        // Add ticket prices
        v2.setEntryFee(9);
        v3.setEntryFee(4);

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

        System.out.println("\n" + map.toString());

        v4.setOpeningHour("08:00");
        System.out.println(Visitable.getVisitingDuration(v3));

        locations.stream()
                .filter(l -> l instanceof Visitable)
                .filter(l -> !(l instanceof Payable))
                .sorted((l1, l2) -> ((Visitable) l1).getOpeningHour().compareTo(((Visitable) l2).getOpeningHour()))
                .forEach(s -> System.out.println(s.getName()));

        System.out.println(locations.stream()
                .filter(l -> l instanceof Payable)
                .mapToDouble(l -> ((Payable) l).getEntryFee())
                .average()
                .orElse(Double.NaN)
        );

    }



}
