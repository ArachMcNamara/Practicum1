import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pick your Product file");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {

                System.out.println("ID | Name | Description | Cost");
                System.out.println("----------------------------------------------");

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String desc = parts[2].trim();
                    String cost = parts[3].trim();

                    System.out.println(id + " | " + name + " | " + desc + " | " + cost);
                }

            } catch (IOException e) {
                System.out.println("Error reading file.");
            }
        }
    }
}

