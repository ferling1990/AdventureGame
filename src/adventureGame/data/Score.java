package adventureGame.data;

import java.io.Serializable;

public class Score implements Serializable {

    private int totalPoint;
    private String name;

    public Score(String name, int totalPoint) {
        this.name = name;
        this.totalPoint = totalPoint;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return totalPoint;
    }

    @Override
    public String toString() {
        return "Name: '" + this.name + "', Point: '" + this.totalPoint + "'";
    }
    
}
