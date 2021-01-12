package online;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Connection {
    // attributes
    private String address; // ip address of host
    private int port;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    // constructor
    public Connection() {
    }

    public Connection(Socket socket) {
        this.socket = socket;

        try{
            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = new DataInputStream(socket.getInputStream());
        }catch(Exception e){
            System.out.print("Unable to create input and output to this socket.\n");
        }
    }

    // connect to host
    public void connectToServer() {

        boolean success = false;

        Scanner sc = new Scanner(System.in);

        while (success != true) {
            System.out.print("Enter the ip address of server: ");
            this.address = sc.nextLine();
            try {
                System.out.print("Enter the port of the server: ");
                this.port = sc.nextInt();

                try {
                    this.socket = new Socket(this.address, this.port);
                    success = true;

                    // set up input & output
                    this.out = new DataOutputStream(this.socket.getOutputStream());
                    this.in = new DataInputStream(this.socket.getInputStream());

                    System.out.print("Successfully connected to server.\n");
                } catch (Exception e) {
                    System.out.print("Error when connecting to this address.\n");
                }

            } catch (Exception e) {
                System.out.print("You did not enter a port number, must be 4 digit number.\n");
            }
        }
    }

    // disconnect from host server
    public void disconnectFromServer() {
        try {
            this.socket.close();
            System.out.print("Successfully disconnected from server.\n");
        } catch (Exception e) {
            System.out.print("Unable to disconnect from host server.\n");
        }
    }

    // write to server
    public void write(String line) {
        try {
            this.out.writeUTF(line);
        } catch (Exception e) {
            System.out.print("Unable to write to server.\n");
        }
    }

    // read from server
    public String read() {
        String line = "";
        try {
            line =  this.in.readUTF();
        } catch (Exception e) {
            System.out.print("Unable to read from server.\n");
        }

        return line;
    }

    // getters and setters
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getPort(){
        return this.port;
    }
    public void setPort(int port){
        this.port = port;
    }
    public Socket getSocket(){
        return this.socket;
    }
    public void setSocket(Socket socket){
        this.socket = socket;
    }
}