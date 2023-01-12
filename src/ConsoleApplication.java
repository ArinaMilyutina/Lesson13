import java.io.*;

public class ConsoleApplication implements Application {

    private final Reader reader = new ConsoleReader();
    private final FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("history.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private final Writer writer = new ConsoleWriter();
    private final Calculator calculator = new Calculator();

    @Override
    public void run() {
        checkFile();
        while (true) {
            writer.write("Enter number 1");
            double num1 = reader.readDouble();
            writer.write("Enter number 2");
            double num2 = reader.readDouble();
            writer.write("Enter operation type");
            String type = reader.readString();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            try {
                fileWriter.write(result.toString());
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.write("Result " + result);
            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader("history.txt"));
                String s;
                while ((s=bufferedReader.readLine())!=null){
                    writer.write(s);
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }
    }

    private void checkFile() {
        File file = new File("history.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
