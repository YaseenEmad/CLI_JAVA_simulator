import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Terminal t = new Terminal();
        Scanner input = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.print("> ");
            userInput = input.nextLine();
            if(t.parser.parse(userInput)){
                t.chooseCommandAction();
            }
        }
    }
}
