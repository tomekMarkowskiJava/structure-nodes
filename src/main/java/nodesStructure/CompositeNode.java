
package nodesStructure;

import java.util.List;

public class CompositeNode implements ICompositeNode {

    private String code;
    private String renderer;
    private List<INode> nodes;

    public CompositeNode(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

}