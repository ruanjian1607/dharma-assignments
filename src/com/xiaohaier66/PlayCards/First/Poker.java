package First;

public class Poker {
    private String number;
    private String pattern;
    private String color;

    public Poker(String number, String pattern, String color) {
        this.number = number;
        this.pattern = pattern;
        this.color = color;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
