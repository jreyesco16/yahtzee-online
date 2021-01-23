package command;

import object.Host;
import object.Guest;
import online.Server;
import online.Connection;
import object.Card;
import menu.GameMenu;
import menu.Menu;

import java.util.Scanner;

public class OnlineCommand implements Command {

    // attributes
    int option;

    // constructor
    public OnlineCommand(int selection) {
        option = selection;
    }

    @Override
    public Menu execute() {

        // get user's name
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();

        if (option == 1) {  // option 1 (user host's game)

            Server server = new Server();
            server.configureLocalHost();
            server.configurePort();
            server.setUpPlayers();
            server.invite();
            server.startServer();

            Host host = new Host(name, new Card(), server);
            // wait for all players to connect to create game
            host.createGame(host);

            // set up a game menu
            return new GameMenu(host, true);

        } else if (option == 2) {   // option 2 (user joins game)

            Connection connection = new Connection();
            connection.connectToServer();
            // send the users name through connection
            connection.write(name);

            Guest guest = new Guest(name, new Card(), connection);

            return new GameMenu(guest, false);
        }

        return null;
    }
}