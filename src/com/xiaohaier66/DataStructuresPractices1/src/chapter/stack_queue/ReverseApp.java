package chapter.stack_queue;

import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

import java.io.*;
import java.util.ResourceBundle;

class StackY{
    private int maxSize;
    private char[] stackArray;
    private int top;
    public StackY(int max){
        maxSize = max;
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
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxSize -1);
    }

}
class Reverser{
    private String input;
    private String output;
    public Reverser(String in){
        input = in;
    }
    public String doRev(){
        int stackSize = input.length();
        StackY theStack = new StackY(stackSize);
        for(int j=0;j<input.length();j++){
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        output = "";
        while(!theStack.isEmpty()){
            char ch = theStack.pop();
            output += ch;
        }
        return output;
    }
}
public class ReverseApp{
    public ReverseApp() throws IOException{
        String input,output;
        while(true){
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if(input.equals(""))
                break;
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: "+ output);

        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr =  new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
