package command;

public class LocalCommand implements Command {
    public void execute(){
        // user can play with up to four friends
        System.out.print("Playing locally");
    }
}