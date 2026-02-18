public class QuizEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Greeting greeting = new Greeting();
        
        String name = greeting.showWelcomeMessage(input);
        User user = new User(name);
        
        input.close();
    }
}
