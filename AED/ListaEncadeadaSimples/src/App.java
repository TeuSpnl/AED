import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada le = new ListaEncadeada();

        for (int i = 0; i < 10; i++) {
            Objeto o = new Objeto();
            le.inserirFim(o);
        }

        JOptionPane.showMessageDialog(null,
                "Bem vindo à lista!\n Eu acabei de criar 10 objetos e inseri eles na lista.\n Clique em OK para ver a lista.");

        le.toString();
    }
}
