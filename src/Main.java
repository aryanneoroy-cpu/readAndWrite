
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of("user_notes.txt");

        try {
            if (Files.exists(filePath)) {
                String previousText = Files.readString(filePath);

                System.out.println("Your previous writing:");
                System.out.println("----------------------");
                System.out.println(previousText);
                System.out.println("----------------------");
            } else {
                System.out.println("You haven't saved anything yet!");
            }
        } catch (IOException e) {
            System.out.println("Could not read your previous writing.");
        }

        System.out.println("\nWrite something new:");
        System.out.println("(Type SAVE on a new line when finished)");

        StringBuilder userText = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("SAVE")) {
                break;
            }

            userText.append(line)
                    .append(System.lineSeparator());
        }

        try {
            Files.writeString(filePath, userText.toString());
            System.out.println("Your writing has been saved!");
        } catch (IOException e) {
            System.out.println("Could not save your writing.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
