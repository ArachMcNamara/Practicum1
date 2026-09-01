import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pick your Person file");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {

                System.out.println("ID | First | Last | Title | YOB");
                System.out.println("--------------------------------------");

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    String id = parts[0].trim();
                    String first = parts[1].trim();
                    String last = parts[2].trim();
                    String title = parts[3].trim();
                    String yob = parts[4].trim();

                    System.out.println(id + " | " + first + " | " + last + " | " + title + " | " + yob);
                }

            } catch (IOException e) {
                System.out.println("Error reading file.");
            }
        }
    }
}

