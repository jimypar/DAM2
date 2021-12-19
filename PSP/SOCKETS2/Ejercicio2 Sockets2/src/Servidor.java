import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

    public static void main(String[] args) {
        Servidor servidor = new Servidor(4444);
        servidor.start();
    }

    private static int idUsuario;
    private ArrayList<HiloCliente> clientes;
    private ArrayList<String> years;
    private ArrayList<String> incremento;
    private int puerto;
    private boolean continuar;

    public Servidor(int puerto) {
        this.puerto = puerto;
        clientes = new ArrayList<HiloCliente>();
    }

    public void start() {

        CargarCSV csv = new CargarCSV();
        csv.cargarCSV();
        this.years = csv.getYears();
        this.incremento = csv.getIncremento();

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

    class HiloCliente extends Thread {
        Socket socket;
        DataInputStream entrada;
        PrintStream salida;

        int id;

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

                if (mensaje.equals("$$$DESCONECTARR$$$")) {
                    continuar = false;
                }
                else {
                    String resultado = calcularIncremento(mensaje);
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



    private String calcularIncremento(String mensaje) {

        for (int i=0;i<years.size();i++){
            if (years.get(i).equalsIgnoreCase(mensaje)){
                return incremento.get(i);
            }
        }
        return "No se ha encontrado datos del: "+mensaje;
    }
}

