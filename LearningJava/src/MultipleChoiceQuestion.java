import java.util.Scanner;

public class MultipleChoiceQuestion {
    public static void main(String[] args) {
        String question = "What's my favorite language?";
        String choiceOne = "C";
        String choiceTwo = "Java";
        String choiceThree = "C++";

        // Write a print statement asking the question
        // Write a print statement giving the answer choices
        System.out.println(question);
        System.out.println("A "+ choiceOne);
        System.out.println("B "+ choiceTwo);
        System.out.println("C "+ choiceThree);

        // Have the user input an answer
        // Retrieve the user's input
        Scanner userIn = new Scanner(System.in);
        String userAnswer = userIn.next();

        // If the user's input matches the correctAnswer...
        // then the user is correct and we want to print out a congrats message to the user.
        if (userAnswer.toUpperCase().equals("B")) {
            System.out.println("Congratulations! You are correct");
        }

        // If the user's input does not match the correctAnswer...
        // then the user is incorrect and we want to print out a message saying that the user
        // is incorrect as well as what the correct choice was.
        else {
            System.out.println("Sorry, incorrect. The correct answer is: ");
            System.out.println("B "+ choiceTwo);
        }
    }
}
