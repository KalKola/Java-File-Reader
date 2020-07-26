import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {

        /* OLD BUFFERED READER METHOD
        File file = new File("speech.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        // Create Scanner for User input
        Scanner sc = new Scanner(System.in);

        // Using the FilenameFilter functional interface to filter only directories
        FilenameFilter filter = (files, fileName) -> {
            return !fileName.contains(".");
        };

        System.out.println("Enter File to Copy: ");
        String originalFile = sc.next();

        // List items contained in the 'directories' directory, passing in our filter to avoid files
        System.out.println("Choose Directory to Copy to: ");
        String[] dir = new File("directories").list(filter);
        for (String directories : dir) {
            System.out.println(directories);
        }
        String copyFile = sc.next();


        // Create Paths for original file and copy destination
        Path source = Paths.get(originalFile);
        Path dest = Paths.get("directories/" + copyFile + "/" + originalFile);

        // Copy file, catch potential IO Exception
        try {
            Files.copy(source, dest, REPLACE_EXISTING);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
