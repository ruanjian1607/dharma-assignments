package gof;

import java.util.ArrayList;
import java.util.List;

interface Command{
    void execute();
}


class Account{
    private String name = "Hanhan";
    private int balance = 1000;

    public void open(){
        System.out.println("Open account [ Name: " + name + ",Balance:" + balance + "]");
    }

    public void close(){
        System.out.println("Close account [ Name: " + name + ",Balance:" + balance + "]");
    }

}
class Openaccount implements Command{
    private Account account;

    public Openaccount(Account account){
        this.account = account;
    }

    @Override
    public void execute(){
        account.open();
    }
}

class Closeaccount implements Command{
    private Account account;

    public Closeaccount(Account account){
        this.account = account;
    }

    @Override
    public void execute(){
        account.close();
    }
}

class Bank{
    private List<Command> commandList = new ArrayList();

    public void receiveCommand(Command command){
        commandList.add(command);
    }

    public void executeCommand(){
        for (Command command : commandList){
            command.execute();
        }
        commandList.clear();
    }
}


public class DemoCommand {
    public static void main(String[] args) {
        Account account = new Account();
        Openaccount openaccount = new Openaccount(account);
        Closeaccount closeaccount = new Closeaccount(account);

        Bank bank = new Bank();
        bank.receiveCommand(openaccount);
        bank.receiveCommand(closeaccount);

        bank.executeCommand();
    }

}
