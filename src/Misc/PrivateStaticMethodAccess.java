package Misc;

public class PrivateStaticMethodAccess {
    static int data=56;
    private static int getData(){
        return data;
    }

    public static void func(){
        System.out.println(PrivateStaticMethodAccess.getData());
    }
}
