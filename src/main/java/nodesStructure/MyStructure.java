package nodesStructure;

import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new LinkedList<>();
    List<INode> temp = new LinkedList<>();

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

//Method to find nested nodes in CompositeNode

    private List<INode> flatten(List <INode> nodes){


        for (INode node : nodes){
            if (node instanceof ICompositeNode){
                flatten(((ICompositeNode) node).getNodes());
            }
            if (!temp.contains(node)){
                temp.add(node);
            }
        }
        return temp;
    }

    public void addNode(INode node){
        nodes.add(node);
    }
}