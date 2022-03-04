import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Pilha p = new PilhaEncadeada();
        p.push(5);

        System.out.println(p.getTop());
    }
}
