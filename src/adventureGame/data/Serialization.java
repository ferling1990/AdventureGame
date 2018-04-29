//This class is used to write and read serializable object to a file.

package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

import java.io.*;

public class Serialization {

    public static void save(Serializable obj, String fileName) throws IOException {
        FileOutputStream dataStream = new FileOutputStream(fileName);
        ObjectOutputStream objectStream = new ObjectOutputStream(dataStream);
        objectStream.writeObject(obj);
        objectStream.close();
    }

    public static Serializable load(String fileName) throws Exception {
        FileInputStream dataStream = new FileInputStream(fileName);
        ObjectInputStream objectStream = new ObjectInputStream(dataStream);
        Serializable obj = (Serializable) objectStream.readObject();
        objectStream.close();
        System.out.println("Loaded: " + obj);
        return obj;
    }
}
