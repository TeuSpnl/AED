import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) throws Exception {
        Ponto p1;
        p1 = new Ponto();

        int x = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada X"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada Y"));

        p1.setPonto(x, y);
        JOptionPane.showMessageDialog(null, p1.toString());
    }
}
