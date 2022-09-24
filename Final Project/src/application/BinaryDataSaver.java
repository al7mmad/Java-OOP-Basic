package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BinaryDataSaver {

     static String BINARYFILENAME = "QuestionBank.dat";
    
    public  void saveDataToBinaryFile(ArrayList<Question> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BINARYFILENAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public  ArrayList<Question> redDataToBinaryFile() {
        ArrayList<Question> dataArrayList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(BINARYFILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            dataArrayList = (ArrayList<Question>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dataArrayList;
    }
    
}
