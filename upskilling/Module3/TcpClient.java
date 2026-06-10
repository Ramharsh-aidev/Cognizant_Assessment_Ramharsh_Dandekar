import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("Server says: " + in.readLine());
            out.println("Hello from Client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
