package joonseo.final_Budget.persistance;

import joonseo.final_Budget.domain.Info;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataStorage implements DataStorage {
    private static final String FILE_PATH = "src/main/java/joonseo/final_Budget/db/InfoDB.dat";

    @Override
    public void saveExpenses(List<Info> expenses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            throw new RuntimeException("오류 발생", e);
        }
    }

    @Override
    public List<Info> loadExpenses() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Info>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("오류 발생", e);
        }
    }
}
