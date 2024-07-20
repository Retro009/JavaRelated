package LinkedList;

public class SearchCommonNode {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ListNode B = new ListNode(6);
        B.next = A.next.next;

        System.out.println("List A");
        AlternateReverse.displayList(A);
        System.out.println("\nList B");
        AlternateReverse.displayList(B);

        ListNode commonNode = getIntersectionNode(A,B);
        if(commonNode==null)
            System.out.println("\nthere is no common intersecting node");
        else
            System.out.println("\ncommon intersecting node: "+commonNode.val);
    }
    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode currA=A;
        ListNode currB=B;
        int sizeA,sizeB;
        sizeA=sizeB=0;
        while(currA!=null){
            sizeA++;
            currA = currA.next;
        }
        while(currB!=null){
            sizeB++;
            currB = currB.next;
        }
        if(sizeA==0||sizeB==0)
            return null;

        currA=A;
        currB=B;
        if(sizeA>=sizeB){
            for(int i=0;i<sizeA-sizeB;i++)
                currA = currA.next;
        }else{
            for(int i=0;i<sizeB-sizeA;i++)
                currB = currB.next;
        }

        while(currA!=null){
            if(currA==currB)
                return currA;
            currA=currA.next;
            currB=currB.next;
        }
        return null;
    }
}
