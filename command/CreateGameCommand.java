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

        // get user's name
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        this.name = sc.nextLine();

        switch(selection){
            case 1:
                return OnlineHostGame();
            case 2:
                return OnlineGuestGame();
            case 3:
                return LocalGame();
            case 0:
                return exitGame();
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
        System.out.print("\n\nThank you for playing\n");
        System.exit(0);

        return null;
    }

    
}
