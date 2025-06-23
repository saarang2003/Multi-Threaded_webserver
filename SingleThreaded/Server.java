import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

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
        new Server().run();
    }
}
