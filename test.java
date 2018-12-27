import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1 {

  public static void main(String[] args) {
    Socket socket = null;
    try {
        socket = new Socket(args[0], 2019);
        System.out.println("[Connection]Server IP : " + socket.getInetAddress().getHostAddress());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        String[] movie = line.split("/");
        System.out.println("-------------------------");
        for(int idx=0; idx<movie.length; idx++) {
            System.out.println(movie[idx]);
        }
        System.out.println("-------------------------");
      
    }catch (Exception e) {
      System.out.println("Exception : " + e);
    }finally {
        try {
          socket.close();
        }catch (Exception e) {}
        System.out.println("Client End");
    }
  }
}
