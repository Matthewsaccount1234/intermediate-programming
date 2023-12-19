
//* Matthew Fratepietro 12/19/2022
//A question class with Answers.
// 
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }
    
    public static int errorCheck(Scanner sc) {
        //checks if input is an int
        if (sc.hasNextInt()) {
            String input = sc.next();
            int answer = Integer.valueOf(input);
            //checks if input is 1 through 4
            if (answer > 0 && answer < 5) {
                //returns the input if its valid
                return answer;
            } else {
                //recurses function
                return errorCheck(sc);
            }
        } else {
            //recurses function
            return errorCheck(sc);
        }

    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        int ans = errorCheck(sc);
        return possibleAnswers[ans - 1].cat;
    }

}