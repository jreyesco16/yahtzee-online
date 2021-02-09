package menu;

import command.Command;
import java.util.Scanner;

// abstract Menu class
abstract public class Menu {

    public int getSelectionFromTerminal(){

        System.out.print("Enter Selection: ");
        Scanner sc = new Scanner(System.in);
        int selection = 10000000;
    
        String selecTmp = sc.nextLine();
    
        try{
            selection = Integer.parseInt(selecTmp);
        }catch(Exception e){
            // user entered a selection that isn't an option
        }
    
        return selection;
    }

    abstract public void displayMenu();
    abstract public Command getCommand();
    abstract public int getSelection();
}
