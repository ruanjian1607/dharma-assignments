package chapter.stack_queue;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.*;
class StackX4{
    private int maxSize;
    private int[] stackArray;
    private int top;
    public StackX4(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int j){
        stackArray[++top] = j;
    }
    public int pop(){
        return stackArray[top--];
    }
    public int peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (-1 == top);
    }
    public boolean isFull(){
        return (maxSize-1 == top);
    }
    public int size(){
        return top+1;
    }
    public int peekN(int n){
        return stackArray[n];
    }
    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top):");
        for(int j=0;j<size();j++){
            System.out.print(peekN(j));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
class ParsePost{
    private StackX4 theStack;
    private String input;
    public ParsePost(String a){
        input = a;
    }
    public int doParse(){
        theStack = new StackX4(20);
        char ch;
        int j;
        int num1,num2,interAns;
        for(j=0;j<input.length();j++){
            ch = input.charAt(j);
            theStack.displayStack(" "+ch+" ");
            if('0' <= ch && '9'>= ch)
                theStack.push((int)(ch-'0'));
            else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch){
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                        default:
                            interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}
public class PostfixApp {
    public PostfixApp(){
        String input="";
        int output;
        while(true){
            System.out.print("Enter postfix: ");
            System.out.flush();
            try {
                input = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(input.equals(""))
                break;
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();
            System.out.println("Evaluates to "+output);
        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
