import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) throws Exception {
        Cilindro cil1;

        cil1 = new Cilindro();
        

        int x = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada X"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada Y"));
        int raio = Integer.parseInt(JOptionPane.showInputDialog("Insira o raio do círculo"));
        int h = Integer.parseInt(JOptionPane.showInputDialog("Insira a altura do cilindro"));
        
        cil1.setPonto(x, y);
        cil1.setRaio(raio);
        cil1.setAltura(h);

        JOptionPane.showMessageDialog(null, cil1.toString());
    }
}
