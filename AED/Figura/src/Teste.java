import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) throws Exception {
        Ponto p1;
        Circulo c1;
        Cilindro cil1;

        p1 = new Ponto();
        c1 = new Circulo();
        cil1 = new Cilindro();
        

        int x = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada X"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada Y"));
        int raio = Integer.parseInt(JOptionPane.showInputDialog("Insira o raio do círculo"));
        int h = Integer.parseInt(JOptionPane.showInputDialog("Insira a altura do cilindro"));
        
        p1.setPonto(x, y);
        c1.setRaio(raio);
        cil1.setAltura(h);

        JOptionPane.showMessageDialog(null, p1.toString());
        JOptionPane.showMessageDialog(null, c1.toString());
        JOptionPane.showMessageDialog(null, cil1.toString());
    }
}
