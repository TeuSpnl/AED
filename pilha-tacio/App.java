public class App {
    public static void main(String[] args)  {
        String strIn = "5+6";
        String strOut = Expressions.infixToPosFix(strIn);

        System.out.println(strOut);
    }
}
