import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

    private BaseDatos bd;


    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos();
        Servidor servidor = new Servidor(4444,bd);
        servidor.start();
    }

    private static int idUsuario;
    private ArrayList<HiloCliente> clientes;
    private int puerto;
    private boolean continuar;

    public Servidor(int puerto, BaseDatos bd) {
        this.puerto = puerto;
        this.bd = bd;
        clientes = new ArrayList<HiloCliente>();
    }

    public void start() {

        bd.conectar();

        continuar = true;
        try
        {
            ServerSocket serverSocket = new ServerSocket(puerto);
            while(continuar){
                Socket socket = serverSocket.accept();

                if(!continuar){
                    break;
                }


                HiloCliente hiloCliente = new HiloCliente(socket);
                clientes.add(hiloCliente);
                hiloCliente.start();
            }

            serverSocket.close();
            for(int i = 0; i < clientes.size(); ++i) {
                HiloCliente cliente = clientes.get(i);
                    cliente.entrada.close();
                    cliente.salida.close();
                    cliente.socket.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error al crear Servidor");
        }
    }



    protected void cerrarServer() {
        continuar = false;
        try {
            new Socket("localhost", puerto);
        }
        catch(Exception e) {
        }
    }

    class HiloCliente extends Thread {
        Socket socket;
        DataInputStream entrada;
        PrintStream salida;

        int id;
        boolean conectado;
        boolean admin;

        HiloCliente(Socket socket) {
            id = ++idUsuario;
            this.socket = socket;
            try
            {
                salida = new PrintStream(socket.getOutputStream());
                entrada = new DataInputStream(socket.getInputStream());

            }
            catch (IOException e) {
            }
        }

        public void run() {

            boolean continuar = true;

            while(continuar) {
                String mensaje = "";
                try {
                    mensaje = entrada.readLine();
                } catch (SocketException s){
                    continuar = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (conectado){



                    if (mensaje.equals("$$$DESCONECTARR$$$")) {
                        continuar = false;
                    }
                }else {
                    String resultado = "";
                    resultado = conectarUsuario(mensaje);
                    salida.println(resultado);
                }
            }
            cerrar();
        }

        private void cerrar() {
            try {
                salida.close();
                entrada.close();
                socket.close();
            }
            catch (Exception e) {}
        }

    }

    private String conectarUsuario(String mensaje) {

        String[] partes = mensaje.split(":");

        try {
            if (bd.consultarUsuario(partes[0],partes[1])){
                return "1";
            }else {
                return "0";
            }
        }catch (ArrayIndexOutOfBoundsException e){}

        return "0";

    }



}

