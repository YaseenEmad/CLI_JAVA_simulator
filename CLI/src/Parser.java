import java.util.ArrayList;
import java.util.List;

public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args, where "input" is the string command entered by the user
    //It also checks validation of the command name/number of args if valid --> return true, if not --> prints error message then return false
    public boolean parse(String input){
        String[] tempArr = input.split(" ");
        commandName = tempArr[0];

        List<String> strings = new ArrayList<String>();
        for(int i=1; i<tempArr.length; i++){
            String tempStr = tempArr[i];
            if(tempArr[i].startsWith("\"") && !tempArr[i].endsWith("\"")){
                i++;
                while(!tempArr[i].endsWith("\"")){
                    tempStr = String.join(" ", tempStr, tempArr[i]); //cp "D:/hello world my name is moamen/file.txt" "files/x.txt"
                    i++;
                }
                tempStr = String.join(" ", tempStr, tempArr[i]);
            }
            if(tempArr[i].startsWith("'") && !tempArr[i].endsWith("'")){
                i++;
                while(!tempArr[i].endsWith("'")){
                    tempStr = String.join(" ", tempStr, tempArr[i]); //cp "D:/hello world my name is moamen/file.txt" "files/x.txt"
                    i++;
                }
                tempStr = String.join(" ", tempStr, tempArr[i]);
            }
            strings.add(tempStr.replace("\"", "").replace("'", ""));
        }

        String[] myArgs = new String[strings.size()];
        strings.toArray(myArgs);
        args = myArgs;

        switch(commandName) {
            case "cd":
                if(args.length > 1){
                    System.out.println("Error: \"cd\" expects 1 or no arguments but got " + args.length);
                    return false;
                }
                break;
            case "pwd":
                if(args.length > 1){
                    System.out.println("Error: \"pwd\" expects 1 or no arguments but got " + args.length);
                    return false;
                }
                break;
            case "date":
                if(args.length > 1){
                    System.out.println("Error: \"date\" expects 1 or no arguments but got " + args.length);
                    return false;
                }
                break;
            case "help":
                if(args.length > 1){
                    System.out.println("Error: \"help\" expects 1 or no arguments but got " + args.length);
                    return false;
                }
                break;
            case "clear":
                if(args.length > 0){
                    System.out.println("Error: \"clear\" expects no arguments but got " + args.length);
                    return false;
                }
                break;
            case "ls":
                if(args.length > 1){
                    System.out.println("Error: \"ls\" expects 1 or no arguments but got " + args.length);
                    return false;
                }
                break;
            case "cp": break;
            case "mv": break;
            case "rmdir": break;
            case "mkdir": break;
            case "cat": break;
            case "more": break;
            case "exit": break;
            default:
                System.out.println("\"" + commandName + "\" is not a valid command");
                return false;

        }

        return true;
    } //{cp(commandName), file1.txt, file2.txt }

    public String getCommandName(){
        return commandName;
    }
    public String[] getArgs(){
        return args;
    }
}
