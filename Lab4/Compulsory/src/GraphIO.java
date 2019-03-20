import com.sun.org.apache.xpath.internal.axes.SubContextList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSink;
import org.graphstream.stream.file.FileSinkDOT;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.ui.view.Viewer;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GraphIO {
    private String imageAddress;
    private String definition;

    public GraphIO(String name, String definition, String imageAddress) throws IOException {
        this.generateImage(name, definition, imageAddress);
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public String getDefinition() {
        return definition;
    }

    public void generateImage(String name, String definition, String imageAddress) throws IOException {
        FileSinkImages pic = new FileSinkImages(FileSinkImages.OutputType.png, FileSinkImages.Resolutions.VGA);
        Graph newGraph = new SingleGraph(name);
        Path myPath = Paths.get(definition);
        List<String> lines = Files.readAllLines(myPath, StandardCharsets.UTF_8);
        int edgesPointer;

        edgesPointer = lines.indexOf("# Edges") + 1;
        List<String> edges = new ArrayList<>(lines.subList(edgesPointer, lines.size()));

        List<String> nodes = new ArrayList<>(lines.subList(1, edgesPointer-1));

        for(String node : nodes){
            node = node.replaceAll("\\s+", "");
            newGraph.addNode(node);
        }


        for(String edge : edges){
            edge = edge.replaceAll("\\s+", "");
            if(edge.length()>0) {
                String node1 = edge.substring(0, 1);
                String node2 = edge.substring(1, 2);

                newGraph.addEdge(node1 + node2, node1, node2);
            }
        }

//        newGraph.display();

        pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
        pic.writeAll(newGraph, imageAddress);

//
//        newGraph.addAttribute("ui.screenshot", imageAddress);
    }
}
