package nodesStructure;

import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new LinkedList<>();
    private List<INode> flatNodes = new LinkedList<>();

    private List<INode> getFlattenedNodes() {
        flatten(nodes);
        return flatNodes;
    }

    @Override
    public INode findByCode(String code) {
        return getFlattenedNodes().stream()
                .filter(iNode -> iNode.getCode().equals(code))
                .findFirst().orElse(null);
    }

    @Override
    public INode findByRenderer(String renderer) {
        return getFlattenedNodes().stream()
                .filter(iNode -> iNode.getRenderer().equals(renderer))
                .findFirst().orElse(null);
    }

    @Override
    public int count() {
        return getFlattenedNodes().size();
    }

//Method to flatten structure of nodes from nested nodes in CompositeNode

    private void flatten(List<INode> nodes) {

        for (INode node : nodes) {
            if (node instanceof ICompositeNode) {
                flatten(((ICompositeNode) node).getNodes());
            }
            if (!flatNodes.contains(node)) {
                flatNodes.add(node);
            }
        }
    }

    public void addNode(INode node) {
        nodes.add(node);
    }
}