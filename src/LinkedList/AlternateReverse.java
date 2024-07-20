package LinkedList;

public class AlternateReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        System.out.println("List before reverse:");
        displayList(head);

        head = alternateReverseList(head);

        System.out.println("\nList after alternate reverse(A0,An-1,A1,An-2,A2,An-3,....):");
        displayList(head);

    }

    static ListNode alternateReverseList(ListNode head){
        ListNode faster = head;
        ListNode slower = head;

        while(faster.next!=null && faster.next.next!=null){
            faster = faster.next.next;
            slower = slower.next;
        }

        ListNode head2 = slower.next;
        slower.next = null;

        head2 = reverseList(head2);

        ListNode curr = head;
        ListNode temp, next;
        while(curr!=null && head2!=null){
            temp = head2;
            head2 = head2.next;
            next = curr.next;
            curr.next = temp;
            temp.next = next;
            curr = next;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void displayList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+"=>");
            curr = curr.next;
        }
    }
}
