public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args, where "input" is the string command entered by the user
    //It also checks validation of the command name/number of args if valid --> return true, if not --> prints error message then return false
    public boolean parse(String input){
        String[] tempArr = input.split(" ");
        commandName = tempArr[0];
        String[] myArgs = new String[tempArr.length-1];
        for(int i = 1; i<tempArr.length; i++){
            myArgs[i-1] = tempArr[i];
        }
        args = myArgs;

//        switch(commandName) {
//            case "cd":
//                if(args.length > 1){
//                    System.out.println("error");
//                    return false;
//                }
//
//                defualt:
//                System.out.println("invalid command name");
//        }

        return true;} //{cp(commandName), file1.txt, file2.txt }
    public String getCommandName(){
        return commandName;
    }
    public String[] getArgs(){
        return args;
    }
}
