package Q1;

public class Main {
    public static void main(String[] args) {
        var myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
