/**
 * @author mddilshan
 */

package hello.quizengine;
import java.util.*;

class QuizManager{
    
    void startQuiz(List<Question> questions, User user, Scanner input) {
        
        user.score= 0;
        
        Collections.shuffle(questions);
        
        System.out.println("\n===== Quiz Started =====\n");

        for (Question q : questions) {
            q.displayQuestion();
            
            int answer;
            while(true){
                System.out.print("Your answer: ");
                if (input.hasNextInt()) {
                    answer = input.nextInt();
                    break;
                } 
                else {
                    System.out.println("Please enter a number!");
                    input.next();
                }
            }

            if (answer == q.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                user.score++;
            }
            else {
                System.out.println("Wrong! Correct answer is: "+ q.getCorrectOptionText() + "\n");
            }
        }
         showResult(user, questions.size());
    }
    
     void showResult(User user, int totalQuestions) {

        double percentage = ((double) user.score / totalQuestions) * 100;

        System.out.println("===== Quiz Finished =====");
        System.out.println("Score: " + user.score + "/" + totalQuestions);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Excellent Job " + user.name + "!");
        }
        else if (percentage >= 50) {
            System.out.println("Good Job " + user.name + "!");
        }
        else {
            System.out.println("Keep Practicing " + user.name + "!");
        }
        
        ResultSaver saver = new ResultSaver();
        saver.saveResult(user, totalQuestions);
    }
    
}