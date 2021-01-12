package object;

import online.Server;
import online.Connection;
import object.Card;
import object.Player;
import java.util.ArrayList;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Host extends Player {

    // attributes
    private Server server;

    // constructor
    public Host(String name, Card card, Server server){
        super(name, card);
        this.server = server;
    }

    // wait for all players to connect
    public Game waitForPlayers(Host host){
        // create ArrayList containing all players
        ArrayList<Player> players = new ArrayList<Player>();

        // wait for all players to join
        int count = 1;
        players.add(host);

        while(count != server.getNumberOfPlayers()){

            System.out.print("Waiting for " + (server.getNumberOfPlayers() - count) + " player to connect.\n");

            String name = "";


            try{
                // wait for a user to connect to server
                Socket socket = this.server.getServerSocket().accept();
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                try{
                    // get the users name
                    name = in.readUTF();

                    // add the player to list
                    players.add(new Guest(name, new Card(), new Connection(socket)));
                    count++;
                }catch(Exception e){
                    System.out.print("Error when getter name from accepted player.\n");
                }

            }catch(Exception e){
                System.out.print("Error when accepting player.\n");
            }


            // inform host that player just joined
            System.out.print("Player " + name + " has joined.\n");
        }

        return new Game(players, new Cup());
    }

    // getters & setters
    public Server getServer(){
        return this.server;
    }
    public void setServer(Server server){
        this.server = server;
    }
}