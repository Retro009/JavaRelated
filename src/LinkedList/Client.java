package LinkedList;

public class Client {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode reverseList = reverseList(head,3);
        while(reverseList != null){
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }

    public static ListNode reverseList(ListNode A, int B){
        ListNode current = A;
        int temp = B;

        ListNode newHead = null;

        ListNode prev = null;
        ListNode next;

        ListNode prevSubList = null;
        ListNode nextSubList = null;


        prevSubList = current;
        while(current!=null && temp>0){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            temp--;
        }
        newHead = prev; //get the new head

        while(current!=null){
            prev = null;
            temp = B;
            nextSubList = current;
            while(current!=null && temp>0){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                temp--;
            }
            prevSubList.next = prev;
            prevSubList=nextSubList;
        }
        return newHead;
    }
}
