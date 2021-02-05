public class MyStack {
    MyStackNode top;

    private int stackMaxSize;
    private long[] stackArray;
    private int topOfStack;
    public MyStack(int stackMaxSize){
        stackMaxSize=stackMaxSize;
        stackArray=new long[stackMaxSize];
        topOfStack=-1;
    }
    //Add to the stack at the top
    /*
    1. Increment the topOfStack (it points to stack index at the top of stack )
    2. Insert the new element at the incremented top index
     */
    public void push(long element)
    {
        if(isFull()){
            System.out.println("Stack is full");
        }
        else {
            topOfStack++;
            stackArray[topOfStack] = element;
        }
    }
//    public void push(int numberToPush){
//        /*
//        14 -> top of stack
//        13
//        12
//        11
//         */
//        }
    //Remove from stack and return the index of popped element
    public long pop()
    {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        else {
            int old_top = topOfStack;
            topOfStack--;

            return stackArray[old_top];
        }
    }
    public long peak(){
        /*
        return the item which is sitting at top of stack
         */
        return stackArray[topOfStack];
    }

    public boolean isEmpty(){
        return (topOfStack==-1);
    }
    public boolean isFull(){
        return (stackMaxSize-1==topOfStack);
    }

}
