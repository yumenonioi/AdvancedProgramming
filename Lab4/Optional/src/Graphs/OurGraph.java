package Graphs;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSinkImages;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OurGraph implements Serializable, GraphIO{
    private String name;
    private String description= new String();
    private String imageAddress = new String();
    private String definition;

    public OurGraph(String name,String description, String definition, String imageAddress) throws IOException{
        this.name = name;
        this.description = description;
        this.imageAddress = imageAddress;
        this.definition = definition;
        generateImage(name, definition, imageAddress);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public String getDefinition() {
        return definition;
    }


    @Override
    public void generateImage(String name, String definition, String imageAddress) throws IOException{
        FileSinkImages pic = new FileSinkImages(FileSinkImages.OutputType.png, FileSinkImages.Resolutions.VGA);
        Graph newGraph = new SingleGraph(name);
        Path myPath = Paths.get(definition);
        List<String> lines = Files.readAllLines(myPath, StandardCharsets.UTF_8);
        int edgesPointer;

        edgesPointer = lines.indexOf("# Edges") + 1;
        List<String> edges = new ArrayList<>(lines.subList(edgesPointer, lines.size()));

        List<String> nodes = new ArrayList<>(lines.subList(1, edgesPointer - 1));

        for (String node : nodes) {
            node = node.replaceAll("\\s+", "");
            newGraph.addNode(node);
        }


        for (String edge : edges) {
            edge = edge.replaceAll("\\s+", "");
            if (edge.length() > 0) {
                String node1 = edge.substring(0, 1);
                String node2 = edge.substring(1, 2);

                newGraph.addEdge(node1 + node2, node1, node2);
            }
        }

        pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
        pic.writeAll(newGraph, imageAddress);
    }

    @Override
    public String toString() {
        return name;
    }
}
