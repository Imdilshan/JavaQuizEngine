/*
 * @author mddilshan
 */

package hello.quizengine;

import java.io.*;
import java.util.*;

class QuestionLoader{
    
    List<Question> loadQuestions(String fileName){
        
        List<Question> questions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while((line = br.readLine()) != null){
                String questionText = line;
                
                String[] options = new String[4];
                for(int i = 0; i < 4; i++){
                    options[i] = br.readLine();
                }
                
                int correctAnswer = Integer.parseInt(br.readLine());
                br.readLine();
                
                Question q = new Question(questionText, options, correctAnswer);
                questions.add(q);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return questions;
    }  
}
