package Generics;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        Node curr = new Node(5);
        Node tail;

        for(int i=4;i>0;i--){
            tail=curr;
            curr=new Node(i,tail);
        }

        Iterator<Node> itr = new Node.NodeIteraor(curr);
        while(itr.hasNext()){
            System.out.println(itr.next().getData());
        }
    }


}
