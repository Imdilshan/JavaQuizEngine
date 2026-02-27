/**
 * @author mddilshan
 */

package hello.quizengine;
import java.util.*;

public class QuizEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Greeting greeting = new Greeting();
        String name = greeting.showWelcomeMessage(input);
        
        User user = new User(name);
        
        QuestionLoader loader = new QuestionLoader();
        List<Question> questions = loader.loadQuestions("src/main/resources/Questions.txt");
        
        QuizManager quizManager = new QuizManager();
        ResultSaver saver = new ResultSaver();
        
        int menuChoice;
      
        do {
            
            System.out.println("\n===== MENU =====");
            System.out.println("1. Start Quiz");
            System.out.println("2. View Results");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            menuChoice = input.nextInt();
            
            switch (menuChoice) {

                case 1:
            
                    Collections.shuffle(questions);

                    System.out.println("Total questions available: "+ questions.size());

                    int numQuestions;
                    while (true) {
                        System.out.print("How many questions do you want to attempt? ");

                        if (input.hasNextInt()) {
                            numQuestions = input.nextInt();

                            if (numQuestions > 0 && numQuestions <= questions.size()) {
                                break;
                            }
                            else {
                                System.out.println("Enter between 1 and "+ questions.size());
                            }
                        } 
                        else {
                            System.out.println("Enter a valid number!");
                            input.next();
                        }
                    }

                    List<Question> selectedQuestions = questions.subList(0, numQuestions);
                    quizManager.startQuiz(selectedQuestions, user, input);
                    break;
            
                case 2:
                    saver.viewResults();
                    break;

                case 3:
                    System.out.println("Thank you for playing!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (menuChoice != 3);
        
        input.close();
    }
}