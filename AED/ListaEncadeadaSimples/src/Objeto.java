public class Objeto {
    private static int primeInt = 1;
    private int id;
    private static char primeChar = 'a';
    private char nome;
    
    public Objeto(){
        this.id = primeInt;
        primeInt++;
        this.nome = primeChar;
        primeChar++;
    }


}
