import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {

    public void run() {
        int port = 8010;
        try {
            ServerSocket socket = new ServerSocket(port);
            socket.setSoTimeout(10000); // Corrected syntax: no named argument

            while (true) {
                System.out.println("Waiting for client connection on port " + port);
                try {
                    Socket acceptedConnection = socket.accept();
                     System.out.println("Connected to "+acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("Hello World from the server");
                    // Handle client connection
                } catch (java.net.SocketTimeoutException e) {
                    System.out.println("Connection timed out after 10 seconds.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); // Handle any IOExceptions like port already in use
        }
    }

    public static void main(String[] args) {
         Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
