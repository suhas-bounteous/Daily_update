import java.io.*;
import java.util.*;
public class fileOperations {
    public static void main(String[] args) throws IOException {
        String filePath = "file.txt";

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, this is a sample java text.\n This is java\n You are viewing java\n Java is oop lang");
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(file)) {
            int c =0;
            String target = "java";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                
                String[] str = line.split("\\W+");
                for (String string : str) {
                    if(string.equalsIgnoreCase(target)){
                        c++;
                    }
                }
            }
            System.out.println("No of occurences of the word java are: "+c);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
