import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
public class Terminal {
    Parser parser = new Parser();

    //This method will choose the suitable command method to be called
    public void chooseCommandAction() throws IOException {


        switch (parser.getCommandName()) {
            case "date" -> date();
            case "exit" -> exit();
            case "pwd" -> pwd();
            case "clear" -> clear();
            case "help" -> help();
            case "ls" -> ls();
            case "cp" -> cp(parser.getArgs());
            case "cd" -> cd(parser.getArgs());
            case "mkdir" -> mkdir(parser.getArgs());
            case "rmdir" -> rmdir(parser.getArgs());
            case "cat" -> cat(parser.getArgs());
            case "more" -> more(parser.getArgs());
            case "mv" -> mv(parser.getArgs());
            case "rm" -> rm(parser.getArgs());
        }

    }
    public void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void cd(String[] args){
        if(args.length == 0){
            System.setProperty("user.dir", System.getProperty("user.home"));
            return;
        }
        // Get the current working directory
        Path currentDir = FileSystems.getDefault().getPath(System.getProperty("user.dir"));

        // Resolve the provided relative path against the current working directory
        Path newPath = currentDir.resolve(args[0]).normalize();

        // Check if the new path exists and is a directory
        if (Files.exists(newPath) && Files.isDirectory(newPath)) {
            // Set the new working directory
            System.setProperty("user.dir", newPath.toString());
        } else {
            System.out.println("Error: Directory does not exist or is not a directory.");
        }
    }

    public void ls(){
        File currentDir = new File(System.getProperty("user.dir"));
        File[] files = currentDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " [Directory]");
                } else {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Error: Unable to list files and directories.");
        }
    }
    public void pwd(){
        System.out.println(System.getProperty("user.dir"));
    }
    public void date() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
        String formattedDate = dateFormat.format(currentDate);
        System.out.println(formattedDate);

    }
    public void mv(String[] args) {}
    public void rm(String [] args){}
    public void mkdir (String[] args) {}
    public void rmdir (String[] args){}
    public void cp (String[] args){} //cp file1.txt file2.txt
    public void more (String[] args){}
    public void cat (String[] args) throws IOException {
        for(int i=0; i<args.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(args[i]));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    public void exit (){
        System.exit(0);
    }
    public void help (){
        System.out.println(
                "clear - Clear the console\n" +
                "cd <directory> - Change current directory\n" +
                "ls - List files and directories in the current directory\n" +
                "cp <source> <destination> - Copy file or directory\n" +
                "mv <source> <destination> - Move file or directory\n" +
                "rm <file/directory> - Remove file or directory\n" +
                "mkdir <directory> - Create a new directory\n" +
                "rmdir <directory> - Remove a directory\n" +
                "cat <file> - Display the contents of a file\n" +
                "more <file> - View the contents of a file one screen at a time\n" +
                "pwd - Show current working directory\n" +
                "date - Show the current date and time\n" +
                "exit : Stop all");
    }
}
