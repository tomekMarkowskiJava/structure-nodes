package nodesStructure;

import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new LinkedList<>();

    private List<INode> getFlattenedNodes() {
        return flatten(nodes);
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

    private List<INode> flatten(List <INode> nodes){
        List<INode> temp = new LinkedList<>();

        for (INode node : nodes){
            if (node instanceof ICompositeNode){
                flatten(((ICompositeNode) node).getNodes());
            }
            temp.add(node);
        }
        return temp;
    }
}