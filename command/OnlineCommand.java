package command;

import command.Command;
import object.Player;
import object.Host;
import object.Game;
import online.Server;
import online.Connection;
import object.Card;
import menu.GameMenu;
import src.CLI;
import java.net.*;
import java.io.*;

import java.util.Scanner;

public class OnlineCommand implements Command {

    // attributes
    int option;
	CLI cli = CLI.getCLI();

    // constructor
    public OnlineCommand(int selection) {
        option = selection;
    }

    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter your name: ");

        String name = sc.nextLine();

        // option 1 (user host's game)
        if (option == 1) {

            Server server = new Server();
            server.configureLocalHost();
            server.checkPort();
            server.setUpPlayers();
            server.invite();
            server.startServer();

            Host host = new Host(name, new Card(), server);

            // wait until all players have connected + return Game
            Game game = host.waitForPlayers(host);

            // set up a game menu
            GameMenu gameMenu = new GameMenu(game, true);
            cli.setMenu(gameMenu);

            // set message to guest's that game is starting
            game.LoadGame();


            // option 2 (user joins game)
        } else if (option == 2) {

            // create connection from guest
            Connection connection = new Connection();

            // start connection/ get server + port from guest
            connection.connectToServer();

            // send the users name through connection
            DataOutputStream out;
            try {
                out = new DataOutputStream(connection.getSocket().getOutputStream());
                out.writeUTF(name);
            } catch (Exception e) {
                System.out.print("Error when sending name to server.\n");
            }

            System.out.print("Waiting to start game . . .\n");

            System.out.print(connection.read());



            GameMenu gameMenu = new GameMenu(false);
            cli.setMenu(gameMenu);
            
        }
    }
}