package controller;

import java.io.*;


public class DataController {

    protected static Object readSerializedObject(String filename) throws IOException, ClassNotFoundException {
        Object data;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            data = objectInputStream.readObject();
            objectInputStream.close();
        } catch (EOFException e) {
            return null;
        }

        return data;
    }


    protected static void writeSerializedObject(String filename, Object data) throws IOException {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        fileOutputStream = new FileOutputStream(filename);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }
}
