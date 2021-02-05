//Linked Lists more functions
import javax.swing.*;
import java.lang.Math;
import java.util.HashSet;

public class NewClass {

    public static void main(String args[]){

        MyLinkedList list = new MyLinkedList();
        list.head = new MyLinkedList.Node(1);//A

        MyLinkedList.Node second = new MyLinkedList.Node(1);//B
        list.head.next = second;

        MyLinkedList.Node third = new MyLinkedList.Node(2);//C
        second.next = third;
         /*
         1 2 1 2
           |
        t     r
           t    r
              t   r
          */
        MyLinkedList.Node fourth = new MyLinkedList.Node(1);//D
        third.next = fourth;

//        MyLinkedList.Node fifth = new MyLinkedList.Node(1);//E
//        fourth.next = fifth;

//        MyLinkedList.Node sixth = new MyLinkedList.Node(1);//E
//        fifth.next = sixth;

       // MyLinkedList.Node seventh = new MyLinkedList.Node(16);//E
        //sixth.next = fourth;

        //reverseLinkedList(list.head);
        //System.out.println(detectLoopInLinkedList(list.head));
        //findLength(list.head);
        //getMiddleofLinkedList(list.head);
        //System.out.println(detectLoopWithFloydInLinkedList(list.head));
        System.out.println(palindromeLinkedList(list.head));
    }
    public static boolean palindromeLinkedList(MyLinkedList.Node head){
        /*
        1->1->2->2->1
        1->2->2->1->1
         */
        MyLinkedList.Node temp=head;
        MyLinkedList.Node middle= getMiddleofLinkedList(head);
        System.out.println("Middle of linkedlist is "+middle.data);
        MyLinkedList.Node secondpart= middle.next;
        middle.next=null;
        System.out.println(secondpart.data);
        MyLinkedList.Node reverseSecondPartPointer = reverseLinkedList(secondpart);
        while(temp!=middle && reverseSecondPartPointer!=null)
        {
            if(temp.data!=reverseSecondPartPointer.data)
                return false;
            System.out.println("temp pointer of L1 " +temp.data);
            System.out.println("reverselist pointer is "+reverseSecondPartPointer.data);
            temp= temp.next;
            reverseSecondPartPointer=reverseSecondPartPointer.next;
//            System.out.println("temp pointer of L1 " +temp.data);
//            System.out.println("reverselist pointer is "+reverseSecondPartPointer.data);
        }
        return true;

    }
    public static MyLinkedList.Node reverseLinkedList(MyLinkedList.Node head){
        /*
        10->11->12->13->14->15->16->null
        null<-10-\>11->12->13->14->15->16->null
               |    |                   |
             prev  next
                   current
         */
        MyLinkedList.Node prev=null;
        MyLinkedList.Node next=null;
        MyLinkedList.Node current = head;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            //System.out.println(""+prev.next.data);
        }
        return prev;
        //ExampleClass.printList(prev);
    }
    public static boolean detectLoopInLinkedList(MyLinkedList.Node head) {
        /*
        10->11->11->12->13->14->15
                     |-----------|

         */
        MyLinkedList.Node temp = head;
        HashSet<MyLinkedList.Node> hashset = new HashSet<MyLinkedList.Node>();
        while(temp!=null)
        {
            if(hashset.contains(temp)){
                //if it contains then defintely loop
                return true;
            }
            hashset.add(temp);
            System.out.println("pointer at temp= "+temp.data);
            temp=temp.next;

        }

        return false;


    }

    public static int detectLoopWithFloydInLinkedList(MyLinkedList.Node head)
    {

        /*
        10  ->   11   ->   12->13->14->15->16

                            |--------------|
        sp,fs
                sp= 10         fs=10
                sp=11          fs=12
                sp=12         fs=14
                sp=13         fs=16
                sp=14         fs = 13
                sp=15         fs = 15
                sp=16         fs=12
                sp=12         fs= 14
                sp=13         fs= 16
                sp=14         fs= 13
                sp= 15        fs= 15
        */
        MyLinkedList.Node slowPointer = head;
        MyLinkedList.Node fastPointer = head;
        int length=0;
        // 10 20 30 40 50 60 70->null
        while(fastPointer!=null && fastPointer.next!=null )
        {
            System.out.println("slow pointer is" +slowPointer.data +" fast pointer is " +fastPointer.data);
            slowPointer = slowPointer.next;
            fastPointer= fastPointer.next.next;
            length++;

            if(fastPointer==slowPointer) {
                //System.out.println("sp is " + slowPointer.data + " fs is " + fastPointer.data);
                //System.out.println(length);
                return countNodes(fastPointer);

            }
            //System.out.println("slow pointer is" +slowPointer.data +"fast pointer is " +fastPointer.data);
        }
        System.out.println("slow pointer is" +slowPointer.data +"fast pointer is " +fastPointer.data);
        return 0;
    }
    public static int countNodes(MyLinkedList.Node head)
    {
        System.out.println("inside countNodes");
        int length= 1;
        MyLinkedList.Node temp = head;
        System.out.println(temp.data);
        temp =temp.next;
        //  10 ->  11
        //  |12 <- 8|
        while(temp != head)
        {
            System.out.println(temp.data);
            length++;
            if(temp == head){
                break;
            }
            temp=temp.next;
        }
        return length;
    }

    //1 2 3 4
    //slow ptr tortoise
    //fast ptr rabbit
    //even
    //slow temp =temp.next;
    //when temp.next.next == null is the terminating condition
    //fast temp = temp.next.next;
    // slow = fast;
    //odd list
    //actual list 5 10 15 20 25-> null
    //slow ptr 5 10 15
    //fast ptr 5 15 25 ->null

    //now case with the even
    //even list actual 5 10 15 20 25 30-> null
    // slow ptr 5 10 15 20
    // fast ptr 5 15 25 null
    // 20 25 30

    // 1 2 3 4 5
    // 1 3 5 null         6(null)
    public static MyLinkedList.Node getMiddleofLinkedList(MyLinkedList.Node head){
    MyLinkedList.Node slowPointer= head;
    MyLinkedList.Node fastPointer =head;
    //use fastPointer as it reaches the end of list first then the slow pointer (2 steps)
    while(fastPointer.next!=null && fastPointer.next.next!=null  )
    {
        slowPointer=slowPointer.next;
        fastPointer=fastPointer.next.next;
    }
        System.out.println(slowPointer.data);
        //System.out.println(fastPointer.data);
        //ExampleClass.printList(head);
        return slowPointer;
    }
    public static void findLength(MyLinkedList.Node head){
        MyLinkedList.Node temp= head;
        double count=0.0;
        int mid;
        while(temp!=null){
            count++;
          //  System.out.println(count+ " is the count of list");
            temp = temp.next;

        }
        //System.out.println("Length of Linked List is "+ count);
        //if odd then ciel
        //else floor

        if(count%2==0)
        {
            mid= (int)Math.floor(count/2);
            //System.out.println("Middle if even "+mid);
        }
        else{
            mid= (int)Math.ceil(count/2);

            //System.out.println((int)Math.ceil(count/2));
            System.out.println("Middle if odd "+mid);
        }
        MyLinkedList.Node newTemp = head;
        int newCounter=0;
        while(newTemp!= null)
        {
            newCounter++;
            if(newCounter == mid)
            {
                System.out.println("Middle of the List is "+newTemp.data);
                break;
            }

            newTemp= newTemp.next;

        }
        ExampleClass.printList(head);

    }

}

//13->  12 ->11
// 11-> 12 ->13
// 100 elements
//101 elememts
//insert at head
//    10-
