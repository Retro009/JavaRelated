package Generics;

public class Point <K,V>{
    public K first;
    public V second;

    public void setFirst(K first){
        this.first=first;
    }

    public void setSecond(V second){
        this.second=second;
    }

    public static <T,H> void doSomething(T tth,H hth){
        System.out.println(tth+","+hth);
    }
}
