//This class redifines how to compare Score, used to sort highscore array.
package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

import java.util.Comparator;

public class HighscoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {

        int point1 = score1.getPoint();
        int point2 = score2.getPoint();

        if (point1 > point2) {
            return -1;
        } else if (point1 < point2) {
            return 1;
        } else {
            return 0;
        }
    }
}
