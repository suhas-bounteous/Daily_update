import java.io.*;
import java.util.*;

public class multiWriteFileOP {

    private static final String filePath = "file.txt";
    private static final Object lock = new Object();

    public static void main(String[] args) throws IOException {

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }

        if (file.createNewFile()) {
            System.out.println("File created successfully.");
        } else {
            System.out.println("File already exists.");
        }

        Thread t1 = new Thread(() -> writeToFile(file,
                "Hello, this is thread ONE.\nJava is powerful.\nLearning Java.\n"));

        Thread t2 = new Thread(() -> writeToFile(file,
                "Hello, this is thread TWO.\nJava supports threads.\nI like Java.\n"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(file)) {
            int c = 0;
            String target = "java";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                String[] str = line.split("\\W+");
                for (String string : str) {
                    if (string.equalsIgnoreCase(target)) {
                        c++;
                    }
                }
            }

            System.out.println("No of occurrences of the word java are: " + c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(File file, String content) {
        synchronized (lock) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(content);
                System.out.println(Thread.currentThread().getName() + " wrote to file.");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
