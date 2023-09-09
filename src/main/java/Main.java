import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList<Toy> toys = new ArrayList<>();

    private static void saveResult(String text) {
        File file = new File("Result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Toy t1 = new Lego();
        Toy t2 = new Robot();
        Toy t3 = new Doll();
        toys.add(new Lego());
        toys.add(new Robot());
        toys.add(new Doll());
        System.out.println("Разыгрываем игрушки:");
        for(Toy item : toys){
            System.out.println(item.getInfo());
        }
        for (int i = 0; i < toys.size(); i++) {
           System.out.println("Вероятность выпадения игрушки \""
                   + toys.get(i).name + "\":  \t"
                   + (toys.get(i).weight*100d/10) + "%");
        }
        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {
        int index = random.nextInt(10); // Выбираем случайный индекс из воображаемого массива
        for (int i = 0; i < toys.size(); i++) { // Ищем элемент, которому принадлежит этот индекс
            index -= toys.get(i).weight;
            if(index < 0) {
 //               System.out.println("Выпала игрушка: " + toys.get(i).name);
                saveResult("Выпала игрушка: " + toys.get(i).name);
                break;
            }
        }
        }
        saveResult("--------------------------------");
    }
}





