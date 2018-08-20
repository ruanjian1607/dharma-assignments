package GroceryThreadDemo;

public class produce {
    private String pro_name;
    private int pro_count;

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setPro_count(int pro_count) {
        this.pro_count = pro_count;
    }

    public produce(String pro_name, int pro_count) {
        this.pro_name = pro_name;
        this.pro_count = pro_count;
    }

    public int getPro_count() {
        return pro_count;
    }

    public String getPro_name() {
        return pro_name;
    }
}
