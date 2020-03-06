package nodesStructure;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStructureTest {

    private static MyStructure structure;
    private static MyStructure emptyStructure;

    private static Node node1 = new Node("code1", "renderer1");
    private static Node node2 = new Node("code2", "renderer2");
    private static Node node3 = new Node("code3", "renderer3");
    private static Node node4 = new Node("code4", "renderer4");

    private static CompositeNode compositeNode1 = new CompositeNode("code5", "renderer5");
    private static CompositeNode compositeNode2 = new CompositeNode("code6", "renderer6");

    @BeforeClass
    public static void setUpNodes() {
        compositeNode1.addNode(node1);
        compositeNode1.addNode(node2);
        compositeNode2.addNode(compositeNode1);
    }

    @Before
    public void setUpStructures() {
        emptyStructure = new MyStructure();
        structure = new MyStructure();

        structure.addNode(compositeNode1);
        structure.addNode(compositeNode2);
        structure.addNode(node3);
        structure.addNode(node4);
    }

    @Test
    public void shouldReturnNumberOfNodesInFullStructure() {
        int result = structure.count();
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnNumberOfNodesInEmptyStructure() {
        int result = emptyStructure.count();
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnNodeFoundByCode() {
        String result = structure.findByCode("code3").getCode();
        assertEquals("code3", result);
    }

    @Test
    public void shouldReturnNodeFoundByRenderer() {
        String result = structure.findByRenderer("renderer5").getRenderer();
        assertEquals("renderer5", result);
    }

    @Test
    public void shouldReturnNullWhenNotFoundByCode() {
        INode result = structure.findByCode("code10");
        assertEquals(null, result);

    }

    @Test
    public void shouldReturnNullWhenNotFoundByRenderer() {
        INode result = structure.findByRenderer("renderer8");
        assertEquals(null, result);
    }

    @Test
    public void shouldReturnNullWithFoundByCodeInEmptyStructure() {
        INode result = emptyStructure.findByCode("code1");
        assertEquals(null, result);

    }@Test
    public void shouldReturnNullWithFoundByRendererInEmptyStructure() {
        INode result = emptyStructure.findByRenderer("renderer1");
        assertEquals(null, result);

    }
}