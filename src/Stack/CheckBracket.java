package Stack;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String A="-A-B-C";
        String B="";

        solveExpression(A);
    }

    public static int solve(String A,String B){





        return 0;
    }

    static String solveExpression(String A){
        Stack<Character> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();

        StringBuilder s = new StringBuilder();

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                stack.pop();
                if(!operator.isEmpty())
                    operator.pop();
            }else if(ch=='-'){

            }
        }

        System.out.println(s);
        return null;
    }

}
