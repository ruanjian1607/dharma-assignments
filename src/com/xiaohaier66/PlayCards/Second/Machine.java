package Second;

import java.util.Vector;

public class Machine {
    private Vector<String > players;
    private Vector<Vector<Poker>> pokers2;
    private Pokers pokers;
    public Machine(){
        this.pokers = new Pokers();
        this.players = new Vector<>();
        this.pokers2 = new Vector<>();
    }
    public Machine(Vector<String > players){
        this.pokers = new Pokers();
        this.players = players;
        this.pokers2 = new Vector<>();
    }
    public void shuffle(){
        pokers.shuffle();
    }

    public void distribute() {
        if(players.size() ==  0)
            return;
        pokers2 = pokers.distribute(players.size());
        for (int i = 0; i < pokers2.size(); i++) {
            System.out.print(players.get(i)+":\t");
            for (int j = 0; j < pokers2.get(i).size(); j++) {
                System.out.print(pokers2.get(i).get(j).getNumber() +
                        pokers2.get(i).get(j).getPattern() + "\t");
            }
            System.out.println();
        }
    }

    public void showPokers(int groupNum){
        pokers.showPokers(groupNum);
    }

    public void addPlayer(String player){
        if(false == pokers2.isEmpty())
            pokers2.removeAllElements();
        players.add(player);
    }

    public void reSet(){
        pokers.reSet();
        players.removeAllElements();
        pokers2.removeAllElements();
    }

    public void reStart(Vector<String> players){
        reSet();
        this.players = players;
        shuffle();
        distribute();
    }

    public void reStart(){
        shuffle();
        distribute();
    }
    public static void main(String[] args){
        Vector<String> players = new Vector<>();
        Machine machine = new Machine(players);
        players.add("A");
        players.add("B");
        players.add("C");
        players.add("D");
      //  Machine machine = new Machine(players);
        machine.addPlayer("E");
        machine.addPlayer("F");

        machine.showPokers(13);
        System.out.println();
        machine.shuffle();
        machine.showPokers(13);
        System.out.println();
        machine.distribute();
        System.out.println();
        machine.reStart(players);
        System.out.println();
        machine.showPokers(13);

        System.out.println();
        machine.reStart();


    }
}
