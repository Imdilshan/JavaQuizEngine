/**
 * @author mddilshan
 */

package hello.quizengine;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ResultSaver {

    void saveResult(User user, int totalQuestions) {

        double percentage = ((double) user.score / totalQuestions) * 100;

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        String record = "Name: " + user.name + " | Score: " + user.score + "/" + totalQuestions +" | Percentage: " + String.format("%.2f", percentage) + "%" +" | Date: " + dateTime;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true))) {

            writer.write(record);
            writer.newLine();

        } 
        catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
    
     void viewResults() {

        File file = new File("results.txt");

        if (!file.exists()) {
            System.out.println("No results found.");
            return;
        }

        System.out.println("\n===== Previous Results =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
        catch (IOException e) {
            System.out.println("Error reading results: " + e.getMessage());
        }
    }
}