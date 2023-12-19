
/*
 * Matthew Fratepietro 12/19/22
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Category fdr = new Category("Franklin Delano Roosevelt ",
                                "you are defined by your optimism, perseverance, and leadership");
                Category js = new Category("Joseph Stalin", "You are a master at manipulation "
                                + "but it's hidden underneath a friendly verneer. You're kinda popular but you deny it.");
                Category wc = new Category("Winston Churchill",
                                "You are inspiring and passionate");
                Category cdg = new Category("Charles De Gaulle", "You are intelligent, hardworking, and zealous.");
                // Create Questions
                Question q1 = new Question("What do you like to eat?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Beef and peas.", fdr);
                q1.possibleAnswers[1] = new Answer("Potatoes and alcohol", js);
                q1.possibleAnswers[2] = new Answer("Beans and bread", wc);
                q1.possibleAnswers[3] = new Answer("Cheese and water", cdg);

                Question q2 = new Question("How do you usually dress?");
                q2.possibleAnswers[0] = new Answer("Semi Formal, usually out with a collared shirt", fdr);
                q2.possibleAnswers[1] = new Answer("Plain and boring, darker colors", js);
                q2.possibleAnswers[2] = new Answer("Extremely formal, always in a suit and tie", wc);
                q2.possibleAnswers[3] = new Answer("Flamboyant attire, bright and flashy", cdg);

                Question q3 = new Question("What would you do if you saw a homeless person?");
                q3.possibleAnswers[0] = new Answer("Only help if you see someone help first", fdr);
                q3.possibleAnswers[1] = new Answer("Team up with someone to rob them", js);
                q3.possibleAnswers[2] = new Answer("Give them what you can spare", wc);
                q3.possibleAnswers[3] = new Answer("Tell them to get a job", cdg);

                Question q4 = new Question("What do you like to do in your free time?");
                q4.possibleAnswers[0] = new Answer("Read", fdr);
                q4.possibleAnswers[1] = new Answer("Drink", js);
                q4.possibleAnswers[2] = new Answer("Talk to your friends", wc);
                q4.possibleAnswers[3] = new Answer("Go for a run", cdg);

                Question q5 = new Question("What is your favorite mode of transportation?");
                q5.possibleAnswers[0] = new Answer("Cars and trucks", fdr);
                q5.possibleAnswers[1] = new Answer("Walking", js);
                q5.possibleAnswers[2] = new Answer("On boats and planes", wc);
                q5.possibleAnswers[3] = new Answer("On horse", cdg);

                Question q6 = new Question("If you could be any animal what would you be?");
                q6.possibleAnswers[0] = new Answer("Eagle", fdr);
                q6.possibleAnswers[1] = new Answer("Bear", js);
                q6.possibleAnswers[2] = new Answer("Lion", wc);
                q6.possibleAnswers[3] = new Answer("Rooster", cdg);

                Question q7 = new Question("What is your favorite car brand?");
                q7.possibleAnswers[0] = new Answer("Ford", fdr);
                q7.possibleAnswers[1] = new Answer("Toyota", js);
                q7.possibleAnswers[2] = new Answer("Bently", wc);
                q7.possibleAnswers[3] = new Answer("Renault", cdg);

                Question q8 = new Question("What part of the world would you vacation to?");
                q8.possibleAnswers[0] = new Answer("Guam", fdr);
                q8.possibleAnswers[1] = new Answer("Poland", js);
                q8.possibleAnswers[2] = new Answer("India", wc);
                q8.possibleAnswers[3] = new Answer("Algeria", cdg);

                // ... more questions here

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { fdr, js, wc, cdg };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("If you were a board game, you would be " + cList[index].label + ". ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                //prints intro
                System.out.println("This is a Buzz Feed quiz");
                System.out.println("Answer 8 simple questions to find out which historical WWII leader you are");

        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
