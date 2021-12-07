import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IniciarSesionGUI extends JFrame implements ActionListener,WindowListener {

    private JLabel usuario,password;
    private JTextField txtUser,txtPassword;
    private JPanel panel;
    private Cliente cliente;
    private boolean conectado;

    private IniciarSesionGUI() {

        super("Cliente");

        panel = new JPanel(new GridLayout(2,2));

        usuario = new JLabel();
        usuario.setText("Usuario : ");
        panel.add(usuario);

        txtUser = new JTextField();
        txtUser.addActionListener(this);
        panel.add(txtUser);

        password = new JLabel();
        password.setText("Contraseña: ");
        panel.add(password);

        txtPassword = new JTextField();
        txtPassword.addActionListener(this);
        panel.add(txtPassword);

        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

        cliente = new Cliente("localhost", 4444, this);
        cliente.iniciar();

    }

    private void aplicacionGUI(){

        panel = new JPanel(new GridLayout(2,2));

        JLabel hola = new JLabel();
        hola.setText("HOLA");
        panel.add(hola);

        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

        cliente = new Cliente("localhost", 4444, this);
        cliente.iniciar();

    }

    void recibir(String str) {
        if (conectado){



        }else{
            if (!str.equals("1")){
                JOptionPane.showMessageDialog(null,"Sesion iniciada","Usuario correcto",JOptionPane.INFORMATION_MESSAGE);
                conectado=true;
                getContentPane().removeAll();
                aplicacionGUI();
            }else {
                JOptionPane.showMessageDialog(null,"Usuario incorrecto","Usuario incorrecto",JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    void falloConexion() {
        cliente.enviarMensaje("$$$SALIR$$$");
    }

    public void actionPerformed(ActionEvent e) {

        cliente.enviarMensaje(txtUser.getText()+":"+txtPassword.getText());

    }


    public void windowClosing(WindowEvent e) { cliente.enviarMensaje("$$$SALIR$$$");
    }

    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}


    public static void main(String[] args) {
       new IniciarSesionGUI();
    }


}
