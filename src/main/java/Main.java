import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static void handleRequest(Socket socket) throws IOException {
        Scanner scan = new Scanner(socket.getInputStream(), "US-ASCII");
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            if(line.isEmpty())
                break;
        }
        String reply = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/plain;charset=UTF-8\r\n" + "\r\n" + "Privet";
        socket.getOutputStream().write(reply.getBytes("UTF-8"));
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(88);
        while(true){
            Socket socket = server.accept();
            handleRequest(socket);
        }
    }


}
