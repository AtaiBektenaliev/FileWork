import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "Все исключения делятся на 2 вида — проверяемые (checked) и непроверяемые (unchecked). \n";

        //создания файла oldFile.txt, и ввод текста
        try {
            FileWriter fileWriter = new FileWriter("oldFile.txt");
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Программа была успешна отработана.");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        //вывод на консоль текст в нутре файла oldFile.txt
        try {
            FileReader fileReader = new FileReader("C:\\Users\\User\\IdeaProjects\\FilesWork\\oldFile.txt");
            Scanner sc = new Scanner(fileReader);
            int i = 1;
            while(sc.hasNextLine()) {
                System.out.println(i + " строка: " + sc.nextLine());
                i++;
            }
            fileReader.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }



        //копирования текста файла oldFile.txt на файл newFile.txt
        try {
            System.out.println("Файл был успешна скопирован.");
            Path bytes = Files.copy(
                    new java.io.File("C:\\Users\\User\\IdeaProjects\\FilesWork\\oldFile.txt").toPath(),
                    new java.io.File("C:\\Users\\User\\IdeaProjects\\FilesWork\\newFile.txt").toPath());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }



        //удаления текста в файле oldFile.txt
        try {
            FileWriter fileReader = new FileWriter("C:\\Users\\User\\IdeaProjects\\FilesWork\\oldFile.txt");
            BufferedWriter out1 = new BufferedWriter(fileReader);
            out1.write("");
            out1.close();
            System.out.println("Файл был успешно очищен.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
