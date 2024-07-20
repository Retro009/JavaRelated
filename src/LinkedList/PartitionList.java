package LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(3);
        System.out.println("Before arranging List:");
        AlternateReverse.displayList(head);
        head = partition(head,5);
        System.out.println("\nAfter Arranging List:");
        AlternateReverse.displayList(head);

    }

    public static ListNode partition(ListNode head,int B){
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode curr1 = null;
        ListNode curr2 = null;

        while(head!=null){
            if(head.val>=B) {
                if (curr2 == null) {
                    curr2 = head;
                    head2 = curr2;
                } else {
                    curr2.next = head;
                    curr2 = curr2.next;
                }
            }else{
                if (curr1 == null){
                    curr1 = head;
                    head1 = curr1;
                }else{
                    curr1.next = head;
                    curr1 = curr1.next;
                }
            }
            head = head.next;
        }

        if(head1!=null)
            curr1.next=null;
        if(head2!=null)
            curr2.next=null;

        if(head1==null)
            return head2;

        curr1.next = head2;
        return head1;
    }
}
