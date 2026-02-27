/**
 * @author mddilshan
 */
package hello.quizengine;

class Question {

    String questionText;
    String[] options;
    int correctAnswer;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion() {

        System.out.println("Q: " + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    int getCorrectAnswer() {
        return correctAnswer;
    }

    String getCorrectOptionText() {
        return options[correctAnswer - 1];
    }
}
