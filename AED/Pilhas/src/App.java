import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String strIn = "5+6";
        String strOut = Expression.infixToPosFix(strIn);

        JOptionPane.showMessageDialog(null, strOut);
    }
}
