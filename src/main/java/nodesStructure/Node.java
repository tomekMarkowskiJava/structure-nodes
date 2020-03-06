package nodesStructure;

public class Node implements INode{

    private String code;
    private String render;

    public Node(String code, String render) {
        this.code = code;
        this.render = render;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return render;
    }

}