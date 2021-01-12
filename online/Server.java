package online;

import java.util.Scanner;
import java.net.*;

public class Server {
    
    // attributes 
    private InetAddress address;
    private int port;
    private int numberOfPlayers;
    private ServerSocket server;
    
    // constructor 
    public Server(InetAddress address, int port, int numberOfPlayers){
        this.address = address;
        this.port = port;
        this.numberOfPlayers = numberOfPlayers;
    }
    public Server(){

    }

    // boot up the server
    public void startServer(){
        try{
            this.server = new ServerSocket(this.getPort(), this.getNumberOfPlayers(), this.getAddress());
        }catch(Exception e){
            System.out.print("\nError when starting server.\n");
        }
    }

    public void stopServer(){
        try{
            this.server.close();
            System.out.print("\nSuccessfully closed server.\n");
        }catch(Exception e){
            System.out.print("\n");
        }
    }

    public void configureLocalHost(){
        try{
            InetAddress address = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
            this.address = address;
        }catch(Exception e){
            System.out.print("Could not get IP address");
        }
    }

    // allow user to check whether port is free
    public void checkPort(){

        boolean found = false;
        Scanner sc = new Scanner(System.in);
        String portString = "";

        // keep buging user until they enter an available port
        while(!found){
            // get an available port from user
            System.out.print("\nEnter an available port(4 digits): ");
            portString = sc.nextLine();

            // check port entered is 4 digits
            if(!checkPortGrammer(portString)){
                continue;
            }
            // convert port to int
            int port = Integer.parseInt(portString);

            try {
                (new ServerSocket(port)).close();
                this.port = port;
                found = true;
            } catch(Exception e) {
                System.out.print(e);
            }
        }
    }

    // return bool if port is valid
    public boolean checkPortGrammer(String port) {
        boolean gram = true;
        // check if string can be converted into digits
        try{
            int tmp = Integer.parseInt(port);
        } catch(Exception e) {
            gram = false;
        }
        // check if the port is 4 digits long
        if (!(port.length() == 4)){
            gram = false;
        }
        return gram;
    }

    // set up the how many players will be in the game
    public void setUpPlayers(){
        Scanner sc = new Scanner(System.in);
        boolean got = false;
        int playersNum;

        // keep bugging user until they enter 
        while(!got){
            System.out.print("Enter the number of players(up to 4): ");
            String players = sc.nextLine();

            try{
                playersNum = Integer.parseInt(players);

                if(1 < playersNum & playersNum < 5){
                    got = true;
                    this.numberOfPlayers = playersNum;
                }else{
                    System.out.print("The number ented must be greater than 1 and smaller or equal to 4, try again.\n");
                    continue;
                }
            }catch(Exception e){
                System.out.print("You didn't enter a number, try again.\n");
                continue;
            }
        }
    }

    public void invite(){
        // print out a form that host should send to friends
        System.out.print("IP: " + this.address + "\n");
        System.out.print("Port: " + this.port + "\n");
    }
    
    // getters and setters
    public InetAddress getAddress(){
        return this.address;
    }
    public void setAddress(InetAddress address){
        this.address = address;
    }
    public int getPort(){
        return this.port;
    }
    public void setPort(int port){
        this.port = port;
    }
    public int getNumberOfPlayers(){
        return this.numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
    }
    public ServerSocket getServerSocket(){
        return this.server;
    }
    public void setServerSocket(ServerSocket server){
        this.server = server;
    }
}