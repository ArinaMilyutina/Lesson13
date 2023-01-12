import java.io.*;

public class ConsoleApplication implements Application {

    private final Reader reader = new ConsoleReader();


    private final Writer writer = new ConsoleWriter();
    private final Calculator calculator = new Calculator();

    @Override
    public void run() {
        FileMethod fileMethod = new FileMethod();
        fileMethod.checkFile();
        while (true) {
            writer.write("Enter operation type");
            String type = reader.readString();
            writer.write("Enter number 1");
            double num1 = reader.readDouble();
            writer.write("Enter number 2");
            double num2 = reader.readDouble();
            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            try {
                FileWriter fileWriter = new FileWriter("history.txt", true);
                fileWriter.write(result.toString());
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.write("Result " + result);
            fileMethod.readerFromFile();
        }

    }
}
