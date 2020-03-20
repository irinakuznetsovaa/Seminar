package Seminar1;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serialize {
    public static void record(List<Animals> listAnimals, String fileName) {
        Path path = Paths.get(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(listAnimals);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Animals> read(String fileName) {
        Path path = Paths.get(fileName);
        List<Animals> listAnimals = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            listAnimals = (List<Animals>) ois.readObject();
            return listAnimals;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listAnimals;
    }

    public static void serializer(List<Animals> listAnimals, String fileName){
    Path path = Paths.get(fileName);
        try(DataOutputStream outputStream =
            new DataOutputStream(Files.newOutputStream(path))){
        outputStream.writeInt(listAnimals.size());
        for (Animals animal : listAnimals) {
            outputStream.writeUTF(animal.getName());
            outputStream.writeUTF(animal.getType().name());
            outputStream.writeInt(animal.getAge());
            outputStream.writeInt(animal.getFoodList().size());
            for (Food food : animal.getFoodList()) {
                outputStream.writeUTF(food.getName());
                outputStream.writeFloat(food.getMass());
            }
        }
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
    public static List<Animals> deserializer(String fileName)  {
        Path path = Paths.get(fileName);
        List<Animals> animalList = new ArrayList<>();

        String name;
        TypesAnimals type;
        int age;

        try (DataInputStream inputStream =
                     new DataInputStream(Files.newInputStream(path))) {
            int countAnimal = inputStream.readInt();
            for (int i = 0; i < countAnimal; i++) {
                name = inputStream.readUTF();
                type = TypesAnimals.valueOf(inputStream.readUTF());
                age = inputStream.readInt();
                int countFood = inputStream.readInt();
                List<Food> listFood = new ArrayList<>();
                for (int j = 0; j < countFood; j++) {
                    String nameFood = inputStream.readUTF();
                    float mass = inputStream.readFloat();
                    listFood.add(new Food(nameFood, mass));
                }
                animalList.add(new Animals( type, name, age, listFood));
            }
        }  catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
        return animalList;
    }
}






