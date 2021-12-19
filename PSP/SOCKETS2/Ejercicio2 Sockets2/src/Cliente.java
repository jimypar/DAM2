import java.net.*;
import java.io.*;

public class Cliente {

    private DataInputStream entrada;
    private PrintStream salida;
    private Socket socket;

    private ClienteGUI gui;

    private String server;
    private int port;

    Cliente(String server, int port, ClienteGUI gui) {
        this.server = server;
        this.port = port;
        this.gui = gui;
    }


    public boolean iniciar() {
        try {
            socket = new Socket(server, port);
        }
        catch(Exception ec) {
            return false;
        }

        String msg = "Introduce un año";
        mostrar(msg);

        try
        {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new PrintStream(socket.getOutputStream());
        }
        catch (IOException eIO) {
        }

        Escuchar escuchar = new Escuchar();
        escuchar.start();

        return true;
    }

    private void mostrar(String msg) {
        gui.append(msg + "\n");
    }

    void enviarMensaje(String msg) {
        salida.println(msg);
    }


    class Escuchar extends Thread {

        public void run() {
            while(true) {
                try {
                    String msg = entrada.readLine();
                        gui.append(msg+"\n");
                }
                catch(IOException e) {
                    gui.falloConexion();
                    break;
                }
            }
        }
    }
}
