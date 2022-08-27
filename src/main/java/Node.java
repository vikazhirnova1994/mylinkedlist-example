/**
 * @author Victoria Zhirnova
 * @project mylinkedlist-example
 *
 *
 * Класс  односвязный список со свойствами <b>next</b> , <b>previous</b> , <b>value</b>
 *
 */
public class Node<T> {

    /** ссылка на следующий элемент */
    private Node<T> next;

    /** ссылка на предыдущий элемент */
    private Node<T> previous;

    /** хранимое значение на предыдущий элемент */
    private T  value;

    public Node(T data) {
        this.next = null;
        this.previous = null;
        this.value = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

  /*  @Override
    public int compareTo(Node<T> o) {
        return  this.value > (o.value);
    }*/
}
