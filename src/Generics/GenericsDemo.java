package Generics;

public class GenericsDemo {
    public static void main(String[] args) {
        Point<Integer,String> p1 = new Point<>();
        p1.first=23;
        p1.second="Twenty-Three";
        p1.setFirst(23);

        Point<Integer,Integer> p2 = new Point<>();
        p2.first=1;
        p2.second=2;
        p2.setSecond(2);

        Point.doSomething(23,"grs");
        Point.doSomething("df","ty");


    }
}
