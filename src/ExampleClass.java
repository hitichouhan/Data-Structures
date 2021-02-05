import java.util.LinkedList;

public class ExampleClass {

    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        list.head = new MyLinkedList.Node(10);//A

        MyLinkedList.Node second = new MyLinkedList.Node(11);//B
        list.head.next = second;

        MyLinkedList.Node third = new MyLinkedList.Node(12);//C
        second.next = third;

        MyLinkedList.Node fourth = new MyLinkedList.Node(14);//D
        third.next = fourth;

        MyLinkedList.Node fifth = new MyLinkedList.Node(15);//D
        fourth.next = fifth;
        //System.out.println("-- First List --");
        //printList(list.head);
        //System.out.println("-- Second List --");


        MyLinkedList secondList = new MyLinkedList();
        secondList.head= new MyLinkedList.Node(100);

        MyLinkedList.Node secondListSecondNode = new MyLinkedList.Node(110);//B
        secondList.head.next = secondListSecondNode;

        MyLinkedList.Node secondListThirdNode = new MyLinkedList.Node(120);//C
        secondListSecondNode.next = secondListThirdNode;

        MyLinkedList.Node secondListForthNode = new MyLinkedList.Node(130);//D
        secondListThirdNode.next = secondListForthNode;
        //printList(secondList.head);
        //insertAtStart(list.head);
        //insertAtEnd(secondList.head);
        //System.out.println("-- Merge Two Lists --");
        //mergeTwoLists(list.head,secondList.head);
        //System.out.println(searchElement(list.head,90));
        //findAndInsertNewNodeInTheMiddle(list.head, 12 , 13);
        //deleteNodeFromList(list.head,15);
        LinkedList mylist = new LinkedList();
    }
    //Deleteting a node
    public static void deleteNodeFromList(MyLinkedList.Node head, int valueToDelete)
    {
       //10 -> 11 -> 12 ->14 -> 15

        MyLinkedList.Node temp = head;
        if(valueToDelete == temp.data){
            temp = temp.next;
            printList(head);
            return;
        }

        while(temp.next!= null) {

            if (temp.next.data == valueToDelete) {

                System.out.println(temp.data);
                System.out.println(temp.next.data);
                temp.next = temp.next.next;
                System.out.println("List after deletion");
                System.out.println(temp.data);
                break;
            }
            temp = temp.next;
        }

        System.out.println("Following is complete list after delete");
        printList(head);
    }

// find an element and insert at certain location
    public static void findAndInsertNewNodeInTheMiddle(MyLinkedList.Node node, int valueToSearch, int valueToInsert)
    {
        //10 -> 11-> 12 -> 14
        //10 -> 11-> 12 -> 13 ->14

        MyLinkedList.Node temp = node;
        while(temp !=null ) { //
            if (temp.data == valueToSearch) //
            {
                break;
            }
            temp = temp.next;
        }
        //System.out.println("----Reached  at------" +temp.data);
        //System.out.println(temp.data);

        MyLinkedList.Node nextElementsOfList = temp.next;
        //System.out.println("----Printing next elements after  ------" +temp.data);
        //printList(nextElementsOfList);
        //System.out.println("now created a next elements of the linked list");
        MyLinkedList.Node newNode = new MyLinkedList.Node(13);
        //System.out.println("new node created with data " +newNode.data);
        temp.next = newNode;
        //System.out.println("temp is still " +temp.data);
        //System.out.println("now appending the new node");
        newNode.next = nextElementsOfList;

        //System.out.println("now the temp is " +temp.data);
        //System.out.println("appending the remaining nodes of the list after newNode");
        printList(node);

    }
    public static int searchElement(MyLinkedList.Node node, int valueToSearch)
    {
        //10 -> 12 -> 13 -> 14
        //10 -> 12 -> 13 -> 11 ->14

        //this function now finds the given number and returns its frequency
        int count=0;
        MyLinkedList.Node temp = node;
        while(temp != null) { //
            if (temp.data == valueToSearch) //
            {
                System.out.println("Value found");
                //break;
                count++;
            }
            temp = temp.next;
        }
        //System.out.println(count);
        return count;
    }

    public static void traverseLinkedList(MyLinkedList.Node head) {
        MyLinkedList.Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void insertAtStart(MyLinkedList.Node head){
        MyLinkedList.Node newHeadNode = new MyLinkedList.Node(30);
        newHeadNode.next = head;
        head = newHeadNode;
    }

    //A->B->C->D->null
    // loop condition to reach till second last because current pointer now points to last node as C.next is D(D->null)
    // D.next is now new node
    public static void insertAtEnd(MyLinkedList.Node node){
        MyLinkedList.Node temp = node;
        while(temp.next!=null)
        {
           // System.out.println(temp.data);
            temp= temp.next;
        }
        MyLinkedList.Node newNodeatEnd = new MyLinkedList.Node(40);
        temp.next= newNodeatEnd;
        printList(node);

    }
    //A B C D-> null
    //J K L M ->null
    //A B C D  J K L M
    public static void mergeTwoLists(MyLinkedList.Node firstListHead, MyLinkedList.Node secondListHead)
    {
        MyLinkedList.Node temp= firstListHead;

        while(temp.next != null){
            //System.out.println(firstListHead.data);
            temp = temp.next;

        }
        temp.next= secondListHead;
        printList(firstListHead);
    }
    public static void printList(MyLinkedList.Node head)
    {
        while(head != null)

        {
            System.out.println(head.data);
            head= head.next;
        }
    }
}
