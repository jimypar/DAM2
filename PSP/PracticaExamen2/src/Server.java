import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private int port;
    private ArrayList<String> datos;

    public Server(int port) {
        this.port = port;
        this.datos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Server server = new Server(4444);
        server.start();
    }

    private void start() {

        try{
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            PrintStream salida = new PrintStream(socket.getOutputStream());

            String numero = entrada.readLine();

            resultado1(numero);

            salida.println(resultado1(numero));
            salida.println(resultado2(numero));

        }
        catch (IOException e) {
            System.out.println("Error al crear Servidor");
        }

    }

    private int resultado1(String numero) {

        int num = Integer.parseInt(numero);
        int resultado = num+2;

        return resultado;
    }

    private int resultado2(String numero) {

        int num = Integer.parseInt(numero);
        int resultado = num*2;

        return resultado;
    }


}
