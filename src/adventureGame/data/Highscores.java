/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventureGame.data;

import java.util.*;
import java.io.*;

/**
 *
 * @author Fen
 */
public class Highscores implements Serializable {

    private ArrayList<Score> highscores;            // Array der indeholder de forskellige highscorers.

    public Highscores(ArrayList<Score> highscores) {
        this.highscores = highscores;
    }

    public Highscores() {
        this.highscores = new ArrayList();
    }

    public void addScore(Score s) {
        highscores.add(s);
    }

    public void sortScore() {
            HighscoreComparator comparator = new HighscoreComparator(); //Benytter klassen HighscoreComparator til at override standard compare og sammenligne score objekt.
            Collections.sort(highscores, comparator);

            /* Der ønskes kun en top 5 så alle index i arrayet udover første 5, slettes. */
            while (highscores.size() > 5) {
                deleteHighscore(5);
            }
    }

    public String printHighscore() {
        String scoreliste = "";
        for (Score object : highscores) {
            //System.out.println(object);
            scoreliste += "\n" + (highscores.indexOf(object)+1) + ". " + object; //String appendes sålådes at én string kan returneres.
        }
        scoreliste += "\n";
        return scoreliste;
    }

    public void deleteHighscore(int i) {
        highscores.remove(i);
    }

}
