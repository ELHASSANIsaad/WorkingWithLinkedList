import java.util.List;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void Display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data +" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int Lenght(){

        if(head == null){
            return 0;
        }

        ListNode current = head;
        int lenght = 0;
        while (current != null){
            lenght++;
            current = current.next;
        }
        return lenght;
    }

    public void insertFirst(int data){
        ListNode newHead = new ListNode(data);
        newHead.next = head;

        head = newHead;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if(head == null){
            head = newNode;
            return;
        }

        ListNode currentNode = head;

        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    /*
    * Redundancy: Maintains both currentNode and previousNode which are essentially performing
    * the same tracking, hence there's some redundancy.
    * */

    public void insertAtPosition(int data, int position){
        ListNode newNode = new ListNode(data);

        if(position < 1){
            return;
        }

        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }

        int currentPosition = 1;
        ListNode currentNode = head;

        ListNode previousNode = head;

        while (currentPosition < position && currentNode != null){

            previousNode = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }

        if (currentPosition == position){

            previousNode.next = newNode;
            newNode.next = currentNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // create nodes
        sll.head = new ListNode(2);

        ListNode seconde = new ListNode(5);
        ListNode thirt = new ListNode(77);
        ListNode fourth = new ListNode(45);

        // connect node to get a singly linked list

        sll.head.next = seconde;
        seconde.next = thirt;
        thirt.next = fourth;

        sll.Display();
        System.out.println( "Lenght : "  + sll.Lenght());

//        System.out.println( "After calling AddFirst(1997) : ");
//        sll.insertFirst(1997);
//        sll.Display();
//        System.out.println( "Lenght : "  + sll.Lenght());

        sll.insertLast(8);
        sll.Display();
        System.out.println( "after insertLast : "  + sll.Lenght());

        sll.insertAtPosition(255, 6);

        sll.Display();
        System.out.println( "After insert at position 1 : "  + sll.Lenght());

    }

}
