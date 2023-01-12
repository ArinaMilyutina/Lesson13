import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileMethod {
    public void checkFile() {
        File file = new File("history.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private final Writer writer = new ConsoleWriter();

    public void readerFromFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("history.txt"));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                writer.write(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

