package adventureGame.data;

import java.util.Comparator;

public class HighscoreComparator implements Comparator<Score> {

    /* Beskriver hvordan compare funktion skal sammenligne score objekt. */
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
