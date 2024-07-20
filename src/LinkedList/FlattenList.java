package LinkedList;

public class FlattenList {
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(3);
        head.down = new ListNode2(7);
        head.down.down = new ListNode2(7);
        head.down.down.down = new ListNode2(8);

        head.right = new ListNode2(4);
        head.right.down = new ListNode2(11);

        head.right.right = new ListNode2(20);
        head.right.right.down = new ListNode2(22);

        head.right.right.right = new ListNode2(20);
        head.right.right.right.down = new ListNode2(20);
        head.right.right.right.down.down = new ListNode2(28);
        head.right.right.right.down.down.down = new ListNode2(39);

        head.right.right.right.right = new ListNode2(30);
        head.right.right.right.right.down = new ListNode2(31);
        head.right.right.right.right.down.down = new ListNode2(39);

        display(head);

        head = flattenList(head);
        System.out.println("MergedList");
        display(head);
    }

    static ListNode2 flattenList(ListNode2 head){
        ListNode2 newHead = head;
        ListNode2 curr = head;
        while(curr.right!=null){
            newHead = mergeList(newHead,curr.right);
            curr=curr.right;
        }

        return newHead;
    }

    static ListNode2 mergeList(ListNode2 head1,ListNode2 head2){
        ListNode2 curr1=head1;
        ListNode2 curr2=head2;
        ListNode2 dummyNode=new ListNode2(0);
        ListNode2 tail=dummyNode;
        while(curr1!=null && curr2!=null){
            if(curr1.val<curr2.val){
                tail.down=curr1;
                curr1=curr1.down;
                tail=tail.down;
            }else {
                tail.down = curr2;
                curr2 = curr2.down;
                tail = tail.down;
            }
        }
        while(curr1!=null){
            tail.down=curr1;
            curr1=curr1.down;
            tail=tail.down;
        }

        while(curr2!=null){
            tail.down = curr2;
            curr2 = curr2.down;
            tail = tail.down;
        }
        return dummyNode.down;
    }
    static void display(ListNode2 head){
        ListNode2 curr = head;
        ListNode2 currDown = null;
        while (curr!=null){
            System.out.print(curr.val+"=>");
            currDown = curr.down;
            while(currDown!=null){
                System.out.print(currDown.val+"=>");
                currDown=currDown.down;
            }
            System.out.println("\n");
            curr = curr.right;
        }
    }
}
