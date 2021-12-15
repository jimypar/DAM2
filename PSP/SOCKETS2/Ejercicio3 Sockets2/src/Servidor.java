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

        if (!bd.conectar()){
            System.exit(0);
        }

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

                    String resultado = consulta(mensaje);
                    salida.println(resultado);

                    if (mensaje.equals("$$$DESCONECTARR$$$")) {
                        continuar = false;
                    }
                }else {
                    String resultado = "";
                    if (conectarUsuario(mensaje)!=-1){conectado=true;}
                    resultado = conectarUsuario(mensaje)+"";
                    System.out.println(resultado);
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

    private String consulta(String mensaje) {

        String[] partes = mensaje.split(":");

        try {
            switch (partes[0]){
                case "1":
                    switch (partes[1]){
                        case "1":
                            return bd.consultarEntrenador(partes[2]);
                        case "2":
                            return bd.consultarJugador(partes[2]);
                        case "3":
                            return bd.consultarEstadio(partes[2]);
                    }
                    break;
                case "2":
                    switch (partes[1]){
                        case "1":
                            bd.modificarEntrenador(partes[2],partes[3],partes[4],partes[5]);
                        case "2":
                            bd.modificarJugador(partes[2],partes[3],partes[4],partes[5],partes[6]);
                        case "3":
                            bd.modificarEstadio(partes[2],partes[3],partes[4]);
                    }
                    break;
                case "3":
                    switch (partes[1]){
                        case "1":
                            bd.eliminarEntrenador(partes[2]);
                        case "2":
                            bd.eliminarJugador(partes[2]);
                        case "3":
                            bd.eliminarEstadio(partes[2]);
                    }
                    break;
            }
        }catch (ArrayIndexOutOfBoundsException e){}


        return "No se ha encontrado la peticion";

    }

    private int conectarUsuario(String mensaje) {

        String[] partes = mensaje.split(":");
        int resultado = -1;
        try {
            resultado =  bd.consultarUsuario(partes[0],partes[1]);
        }catch (ArrayIndexOutOfBoundsException e){}

        return resultado;


    }



}

