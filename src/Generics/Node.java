package Generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Node implements Iterable<Node>{
    private int data;
    private Node next;

    public Node(int data){
        this(data,null);
    }
    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

    public int getData(){
        return this.data;
    }
    @Override
    public Iterator<Node> iterator() {
        return new NodeIteraor(this);
    }
    public static class NodeIteraor implements Iterator<Node>{

        private Node current;
        public NodeIteraor(Node startNode){
            this.current=startNode;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Node next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Node currentData= current;
            current=current.next;
            return currentData;
        }
    }

}
