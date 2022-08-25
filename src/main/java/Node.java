/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 *
 *
 * Класс  односвязный список со свойствами <b>next</b> , <b>previous</b> , <b>value</b>
 *
 */
public class Node<T extends Comparable<T> > implements Comparable<Node<T>> {

    /** ссылка на следующий элемент */
    private Node next;

    /** ссылка на предыдущий элемент */
    private Node previous;

    /** хранимое значение на предыдущий элемент */
    private T  value;

    public Node(T data) {
        this.next = null;
        this.previous = null;
        this.value = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    public Node getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Node<T> o) {
        return  value.compareTo(o.value);
    }
}
