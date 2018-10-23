package chapter.stack_queue;

import java.io.*;
class StackX3{
    private int maxSize;
    private char[] stackArray;
    private int top;
    public StackX3(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j){
        stackArray[++top] = j;
    }
    public char pop(){
        return stackArray[top--];
    }
    public char peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (-1 == top);
    }
    public int size(){
        return top+1;
    }
    public char peekN(int n){
        return stackArray[n];
    }
    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0;j<size();j++){
            System.out.print( peekN(j));
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
class InToPost{
    private StackX3 theStack;
    private String input = "";
    private String output="";
    public InToPost(String in){
        input = in;
        int stackSize = in.length();
        theStack = new StackX3(stackSize);
    }
    public String doTrans(){
        for(int j=0;j<input.length();j++){
            char ch = input.charAt(j);
            theStack.displayStack("For "+ch+" ");
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                    default:
                        output += ch;
                        break;
            }
        }
        while (!theStack.isEmpty()){
            theStack.displayStack("While ");
            output += theStack.pop();
        }
        theStack.displayStack("End  ");
        return output;
    }
    public void gotOper(char opThis,int prec1){
        while(!theStack.isEmpty()){
            char opTop = theStack.pop();
            if('(' == opTop){
                theStack.push(opTop);
                break;
            }
            else {
                int prec2;
                if('+' == opTop || '-' == opTop)
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec1){
                    theStack.push(opTop);
                    break;
                }
                else
                    output += opTop;
            }
        }
        theStack.push(opThis);
    }
    public void gotParen(char ch){
        while(!theStack.isEmpty()){
            char chx = theStack.pop();
            if('(' == chx)
                break;
            else
                output += chx;
        }
    }
}
public class InfixApp {
    public InfixApp(){
        String input="", output;
        while(true){
            System.out.print("Enter infix: ");
            System.out.flush();
            try {
                input = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(input.equals(""))
                break;
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            System.out.println("Postfix is "+output+'\n');
        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
