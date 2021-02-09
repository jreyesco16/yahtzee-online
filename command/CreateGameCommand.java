package command;

import java.io.IOException;
import java.util.Scanner;

import menu.GameMenu;
import menu.LobbyMenu;
import menu.Menu;
import object.Card;
import object.Guest;
import object.Host;
import online.Connection;
import online.Server;

public class CreateGameCommand implements Command {

    // attributes
    private int selection;
    private String name;

    // constructor
    public CreateGameCommand(int selection){
        this.selection = selection;
    }

    @Override
    public Menu execute() throws IOException {

        // check if the user wants to exit game before asking for name
        if(selection == 0){
            exitGame();
        }

        // get user's name
        Scanner sc = new Scanner(System.in);

        boolean flag = false;

        while(flag == false){

            System.out.print("\nEnter your name: ");
            name = sc.nextLine();

            if(name.length()>7){
                System.out.print("\nName can't be larger than 7 letters long. Try again.\n");
            }else{
                flag = true;
            }
        }

        switch(selection){
            case 1:
                return OnlineHostGame();
            case 2:
                return OnlineGuestGame();
            case 3:
                return LocalGame();
        }
        return new LobbyMenu();
    }

    public Menu OnlineHostGame() {

        Server server = new Server();
        server.configureLocalHost();
        server.configurePort();
        server.setUpPlayers();
        server.invite();
        server.startServer();

        Host host = new Host(name, new Card(), server);

        // wait for all players to connect to create game
        host.createOnlineGame(host);

        // set up a game menu
        return new GameMenu(host);
    }

    public Menu OnlineGuestGame() {

        Connection connection = new Connection();
        connection.connectToServer();
        connection.write(name);

        Guest guest = new Guest(name, new Card(), connection);

        return new GameMenu(guest);
    }

    public Menu LocalGame(){

        Host host = new Host(name, new Card(), null);
        host.createLocalGame(host);

        return new GameMenu(host);
    }

    public Menu exitGame(){
        System.out.print("\n\n\t\t\t\t  Thank you for playing.\n\n");
        System.exit(0);

        return null;
    }    
}
