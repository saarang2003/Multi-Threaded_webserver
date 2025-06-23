import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public void run(){

        int port = 8010 ;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout( timeout : 10000);
        while(true){
            System.out.println("Waiting for client connection on port " + port);
            Socket acceptedConnection = socket.accept();
            
        }

    }
}
