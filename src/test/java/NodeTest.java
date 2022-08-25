import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 */

public class NodeTest {

    Node<Integer> node;

    @BeforeEach
    void prepareCar(){
        node = new Node(1);
    }


    @Test
    void testGetValue() {
        assertEquals(1, node.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testSetValue(int data) {
        node.setValue(data);
        assertEquals( data, node.getValue());
    }

    @Test
    void testGetNextInFirst() {
        assertEquals(null, this.node.getNext());
    }

    @Test
    void testSetNextLink() {
        Node nextLink = new Node(3);
        node.setNext(nextLink);
        assertEquals(nextLink, this.node.getNext());
    }
}
