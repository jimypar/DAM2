import java.net.*;
import java.io.*;

public class Cliente {

    private DataInputStream entrada;
    private PrintStream salida;
    private Socket socket;

    private IniciarSesionGUI gui;
    private String server;
    private int port;

    private boolean conectado;

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    Cliente(String server, int port, IniciarSesionGUI gui) {
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

        try{
            entrada = new DataInputStream(socket.getInputStream());
            salida = new PrintStream(socket.getOutputStream());
        }
        catch (IOException eIO) {
        }

        Escuchar escuchar = new Escuchar();
        escuchar.start();

        return true;
    }

    void enviarMensaje(String msg) {
        salida.println(msg);
    }

    void desconectar() {
        try {
            entrada.close();
            salida.close();
            socket.close();
        }
        catch(Exception e) {}

        gui.falloConexion();

    }



    class Escuchar extends Thread {

        public void run() {
            while(true) {
                try {
                    String msg = entrada.readLine();
                    gui.recibir(msg);
                }
                catch(IOException e) {
                    gui.falloConexion();
                    break;
                }
            }
        }
    }

}
