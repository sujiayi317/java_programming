import java.io.IOException;

class GuessChar {
    public static void main(String[] args) throws IOException {
        char ch, ignore, answer = 'K';
        do {
            System.out.println("I'm thinking of a letter between A and Z,\nCan you guess it: ");
            // read a character
            ch = (char) System.in.read();

            // discard any other character in the input buffer.
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

            if (ch == answer) System.out.println("***Right***");
            else {
                System.out.print("Sorry, you are ");
                if (ch < answer) System.out.println("too low");
                else System.out.println("too high");
            }
        } while (answer != ch);
    }
}