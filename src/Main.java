import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("speech.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
