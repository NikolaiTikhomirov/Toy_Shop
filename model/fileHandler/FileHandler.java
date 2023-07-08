package model.fileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.ToyList;
import model.PrizeList;

public class FileHandler implements Writable{

    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Сохранить не удалось");
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            Serializable list;
            if (filePath.contains("toy")) {
                list = new ToyList<>();
                System.out.println("Создан новый список игрушек");
            }
            else if (filePath.contains("prize")){
                list = new PrizeList<>();
                System.out.println("Создан новый список призов, ожидающих выдачи");
            }
            else {
                list = "";
                System.out.println("Создан новый список врученных призов");
            }
            FileHandler writable = new FileHandler();
            writable.save(list, filePath);
            return list;
        }
    }
}
