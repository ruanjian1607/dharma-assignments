package gof;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return instance;
    }

    public String getPaw(){
        return paw;
    }

    private EagerSingleton(){}

    public static void main(String[] args) {
        EagerSingleton single = EagerSingleton.getInstance();
        System.out.println(single.getPaw());
    }

    private String paw = "wo yao chi ren ";
}
