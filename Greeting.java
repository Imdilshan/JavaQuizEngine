class Greeting{ 
   String showWelcomeMessage(Scanner input){
        System.out.print("Enter Your Name: ");
        String userName = input.nextLine();
  
        System.out.println("Hello "+userName+"!");
        System.out.println("Best of luck for the Quiz!");
        
        return userName;
    }
}
