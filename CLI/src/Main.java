import org.w3c.dom.ls.LSOutput;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Terminal t = new Terminal();
        Scanner input = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.print("> ");
            userInput = input.nextLine();
            String[] commands = userInput.split(" & ");
            for(int i=0; i<commands.length; i++) {
                if (t.parser.parse(commands[i])) {
                    t.chooseCommandAction();
                }
            }
        }
    }
}
