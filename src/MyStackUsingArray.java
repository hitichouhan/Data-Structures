public class MyStackUsingArray {
    public static void main(String[] args){
        MyStack theStack= new MyStack(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        /*to print the stack contents use the method isEmpty to check if the stack is empty or not
        old number are pilled on the top when you do push to stack
        input 1: 20 0th index
        input 2: 30 1st index
        input 3: 40 2nd index
         */
        while(!theStack.isEmpty()){
            long popvalue=theStack.pop();
            System.out.println("Stack pop values : "+popvalue);
        }

    }



}
