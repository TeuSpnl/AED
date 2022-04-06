import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada le = new ListaEncadeada();
        int id = 1;

        // Só pra mostrar que o inserirInicio() funciona
        Object ob = id;
        id++;

        le.inserirInicio(ob);
        
        for (int i = 0; i < 9; i++) {
            Object o = id;
            id++;

            le.inserirFim(o);
        }

        JOptionPane.showMessageDialog(null,
                "Bem vindo à lista!\n Eu acabei de criar 10 objetos e inseri eles na lista.\n Clique em OK para ver a lista.");

        JOptionPane.showMessageDialog(null, le.toString());
    }
}
