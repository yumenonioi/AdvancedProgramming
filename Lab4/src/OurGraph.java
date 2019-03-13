import java.io.IOException;
import java.util.List;

public class OurGraph {
    private String name;
    private String description;
    private String imageAddress;
    private String definition;
    private List<Node> nodes;

    public OurGraph(String name, String definition, String imageAddress)  throws IOException {
        GraphIO configuration = new GraphIO(name, definition, imageAddress);

        this.name = name;
        this.imageAddress = this.imageAddress;
        this.definition = definition;
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

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
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

    public List<Node> getNodes() {
        return nodes;
    }
}
